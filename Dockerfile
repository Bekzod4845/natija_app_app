FROM eclipse-temurin:17-jdk-alpine
VOLUME /ompany
COPY target/*.jar natija_app.jar
ENTRYPOINT ["java","-jar","/natija_app.jar"]