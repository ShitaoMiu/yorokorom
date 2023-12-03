FROM openjdk:11 AS builder
EXPOSE 8080
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar
FROM openjdk:11
COPY --from=builder /build/libs/yorokorom_backend-0.0.1-SNAPSHOT.jar /yorokorom_backend.jar
ENTRYPOINT [ "java", "-jar", "/yorokorom_backend.jar" ]
VOLUME [ "/tmp" ] 
