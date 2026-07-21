package org.consortiumcore.shared.error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class ApplicationMessageResolver {

    private static final String MESSAGES_RESOURCE = "application.messages.yml";

    private static final AtomicReference<ApplicationMessages> CURRENT =
            new AtomicReference<>(new DefaultApplicationMessages(loadClasspathMessages()));

    private ApplicationMessageResolver() {
    }

    public static void configure(ApplicationMessages messages) {
        CURRENT.set(Objects.requireNonNull(messages));
    }

    public static void configure(Map<String, String> messages) {
        CURRENT.set(new DefaultApplicationMessages(messages));
    }

    public static String resolve(ApplicationError error, Object... arguments) {
        return CURRENT.get().resolve(error, arguments);
    }

    private static Map<String, String> loadClasspathMessages() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = ApplicationMessageResolver.class.getClassLoader();
        }

        Map<String, String> messages = new HashMap<>();
        try {
            Enumeration<java.net.URL> resources = classLoader.getResources(MESSAGES_RESOURCE);
            while (resources.hasMoreElements()) {
                try (InputStream stream = resources.nextElement().openStream()) {
                    messages.putAll(parseFlatYaml(stream));
                }
            }
        } catch (IOException exception) {
            return Map.of();
        }
        return messages;
    }

    private static Map<String, String> parseFlatYaml(InputStream stream) throws IOException {
        Map<String, String> messages = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();
                if (trimmed.isBlank() || trimmed.startsWith("#")) {
                    continue;
                }

                int separator = trimmed.indexOf(':');
                if (separator <= 0) {
                    continue;
                }

                String key = trimmed.substring(0, separator).trim();
                String value = trimmed.substring(separator + 1).trim();
                messages.put(key, unquote(value));
            }
        }
        return messages;
    }

    private static String unquote(String value) {
        if (value.length() >= 2 && value.startsWith("\"") && value.endsWith("\"")) {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }

    private record DefaultApplicationMessages(Map<String, String> messages) implements ApplicationMessages {

        private DefaultApplicationMessages {
            messages = Map.copyOf(messages);
        }

        @Override
        public String resolve(ApplicationError error, Object... arguments) {
            String pattern = messages.getOrDefault(error.messageKey(), error.defaultMessage());
            return MessageFormat.format(pattern, arguments);
        }
    }
}
