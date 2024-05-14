FROM maven:3.2.2-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/natija_app-0.0.1-SNAPSHOT.jar natija_app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","natija_app.jar"]