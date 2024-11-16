FROM openjdk:23-jdk

WORKDIR /app

COPY target/bodyhealty-servicios-ms-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/cert.p12 cert.p12

EXPOSE 8443

ENTRYPOINT ["java", "-jar", "app.jar"]