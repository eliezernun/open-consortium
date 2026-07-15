package org.consortiumcore.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.consortiumcore")
public class ConsortiumCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsortiumCoreApplication.class, args);
    }
}
