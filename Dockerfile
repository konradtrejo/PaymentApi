FROM eclipse-temurin:8-jdk-jammy

WORKDIR /app

COPY target/Payment-service-api-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]