FROM maven:3.9.8-eclipse-temurin-17 AS build

WORKDIR /workspace

COPY spring_backend/pom.xml spring_backend/pom.xml
COPY spring_backend/src spring_backend/src
COPY *.html *.js *.css ./
COPY img ./img

RUN mkdir -p spring_backend/src/main/resources/static
RUN cp -r *.html *.js *.css img spring_backend/src/main/resources/static/

WORKDIR /workspace/spring_backend
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=build /workspace/spring_backend/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
