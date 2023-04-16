FROM openjdk:17

WORKDIR /app

COPY target/*.jar /app/truco.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "truco.jar"]