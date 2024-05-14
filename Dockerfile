FROM maven:3.8.5-amazoncorretto-17
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:17.0.1-amazoncorretto
COPY --from=build /target/natija_app-0.0.1-SNAPSHOT.jar natija_app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","natija_app.jar"]