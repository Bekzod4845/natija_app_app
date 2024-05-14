FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /natija_app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/natija_app-0.0.1-SNAPSHOT.jar natija_app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","natija_app.jar"]



