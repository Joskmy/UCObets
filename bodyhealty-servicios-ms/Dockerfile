FROM openjdk:23-jdk

WORKDIR /app
COPY target/*.jar app.jar

CMD ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]