FROM openjdk:19-jdk-alpine

WORKDIR /app

# Copy the Spring Boot project into the image
COPY target/UserServer-0.0.1-SNAPSHOT.jar /app/UserServer.jar

# Install SQLite
RUN apk add --no-cache sqlite

# Copy the database file into the image
COPY target/user.db /app/user.db

EXPOSE 1339

# Set the command to run the Spring Boot project
CMD ["java", "-jar", "/app/UserServer.jar"]
