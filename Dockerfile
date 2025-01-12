# Use the official OpenJDK image as the base
FROM apache/spark:latest


# Set environment variables
ENV SPARK_VERSION=3.4.1
ENV HADOOP_VERSION=3

# Install dependencies
# RUN apk add --no-cache curl bash

# Create a directory for the application
WORKDIR /app

# Copy the application JAR
COPY SparkJava-0.0.1-SNAPSHOT.jar /app/app.jar

# Define the entry point (optional)
 ENTRYPOINT ["spark-submit"]
