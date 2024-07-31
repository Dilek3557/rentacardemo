FROM openjdk:21-jdk
EXPOSE 8080
ARG JAR_FILE=target/rentAcar-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "/application.jar"]
