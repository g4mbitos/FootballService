FROM openjdk:8
ADD target/football.jar football.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "football.jar"]