FROM openjdk:8-jdk-alpine as build
WORKDIR /usr/src/app
COPY . .
RUN apk add maven
RUN mvn test
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
