FROM openjdk:23-jdk

EXPOSE 8443
COPY target/*.jar app.jar
COPY src/main/resources/cert.p12 /cert.p12
ENTRYPOINT ["java", "-jar", "/app.jar"]