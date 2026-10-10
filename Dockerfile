# syntax=docker/dockerfile:1.7

FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /workspace
COPY pom.xml .
COPY consortium-shared-kernel/pom.xml consortium-shared-kernel/pom.xml
COPY consortium-regulation/pom.xml consortium-regulation/pom.xml
COPY consortium-product-catalog/pom.xml consortium-product-catalog/pom.xml
COPY consortium-product-catalog/product-catalog-api/pom.xml consortium-product-catalog/product-catalog-api/pom.xml
COPY consortium-product-catalog/product-catalog-domain/pom.xml consortium-product-catalog/product-catalog-domain/pom.xml
COPY consortium-product-catalog/product-catalog-application/pom.xml consortium-product-catalog/product-catalog-application/pom.xml
COPY consortium-product-catalog/product-catalog-infrastructure/pom.xml consortium-product-catalog/product-catalog-infrastructure/pom.xml
COPY consortium-group/pom.xml consortium-group/pom.xml
COPY consortium-group/group-api/pom.xml consortium-group/group-api/pom.xml
COPY consortium-group/group-domain/pom.xml consortium-group/group-domain/pom.xml
COPY consortium-group/group-application/pom.xml consortium-group/group-application/pom.xml
COPY consortium-group/group-infrastructure/pom.xml consortium-group/group-infrastructure/pom.xml
COPY consortium-quota/pom.xml consortium-quota/pom.xml
COPY consortium-contribution/pom.xml consortium-contribution/pom.xml
COPY consortium-ledger/pom.xml consortium-ledger/pom.xml
COPY consortium-assembly/pom.xml consortium-assembly/pom.xml
COPY consortium-contemplation/pom.xml consortium-contemplation/pom.xml
COPY consortium-closure/pom.xml consortium-closure/pom.xml
COPY consortium-integration/pom.xml consortium-integration/pom.xml
COPY consortium-bootstrap/pom.xml consortium-bootstrap/pom.xml
RUN --mount=type=cache,target=/root/.m2 mvn -B -ntp dependency:go-offline

COPY . .
RUN --mount=type=cache,target=/root/.m2 mvn -B -ntp -DskipTests package

FROM build AS test
RUN --mount=type=cache,target=/root/.m2 mvn -B -ntp clean verify

FROM eclipse-temurin:21-jre AS runtime
WORKDIR /app
RUN addgroup --system consortium && adduser --system --ingroup consortium consortium
COPY --from=build /workspace/consortium-bootstrap/target/consortium-bootstrap-*.jar /app/consortium-core.jar

ENV JAVA_OPTS="" \
    SERVER_PORT=8080 \
    OTEL_LOGS_EXPORTER=none \
    OTEL_TRACES_EXPORTER=none \
    OTEL_METRICS_EXPORTER=none

EXPOSE 8080
USER consortium
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/consortium-core.jar"]
