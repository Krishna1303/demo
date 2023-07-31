FROM openjdk:17

# Set the working directory inside the container
# WORKDIR /app

# Copy the compiled Spring Boot JAR file into the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your Spring Boot application listens on
EXPOSE 8081

# Command to run your application when the container starts
CMD ["java", "-jar", "app.jar"]
