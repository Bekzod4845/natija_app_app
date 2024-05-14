FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /target/natija_app-0.0.1-SNAPSHOT.jar natija_app.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","natija_app.jar"]
