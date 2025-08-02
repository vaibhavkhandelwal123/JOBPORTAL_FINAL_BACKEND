FROM maven:3.5.4-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/Job-Portal-0.0.1-SNAPSHOT.jar Job-Portal.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","Job-Portal.jar"]