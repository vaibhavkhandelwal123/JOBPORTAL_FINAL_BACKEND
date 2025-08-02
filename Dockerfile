# ---------- Build Stage ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# ---------- Runtime Stage ----------
FROM openjdk:17-slim
WORKDIR /app

# Copy only the built JAR from the previous stage
COPY --from=build /app/target/Job-Portal-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot uses
EXPOSE 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
