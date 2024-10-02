# # Use an official OpenJDK runtime as a parent image
# FROM openjdk:17-jdk-alpine
#
# # Set the working directory inside the container
# WORKDIR /app
#
# # Add the application's JAR file to the container
# # If using Maven, change 'target' to match your JAR path
# COPY target/*.jar /app/app.jar
#
# # Expose the port your Spring Boot app runs on
# EXPOSE 8080
#
# # Run the application
# ENTRYPOINT ["java", "-jar", "/app/app.jar"]
