# Use OpenJDK 17 base image
FROM openjdk:17

# Set working directory
WORKDIR /app

# Copy all Java files into the container
COPY src/ /app/src

# Compile Java files
RUN javac src/*.java -d out

# Set the classpath to compiled output
WORKDIR /app/out

# Command to run the application
CMD ["java", "Main"]
