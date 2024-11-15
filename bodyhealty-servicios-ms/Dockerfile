FROM openjdk:23-jdk

WORKDIR /app
COPY target/*.jar app.jar
EXPOSE ${PORT:8443}

CMD ["java", "-jar", "app.jar"]