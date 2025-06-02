FROM eclipse-temurin:17
LABEL mantainer="Dalton"
WORKDIR /app
COPY target/Raven-0.0.1-SNAPSHOT.jar /app/raven-docker.jar
ENTRYPOINT ["java", "-jar", "raven-docker.jar"]