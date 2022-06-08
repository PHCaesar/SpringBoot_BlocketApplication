# Dockerfile
FROM openjdk:18-jdk as build
COPY . /app
WORKDIR /app
RUN chmod +x mvnw
RUN ./mvnw package

FROM openjdk:18
COPY --from=build /app/target/*.jar /app.jar
CMD java -jar /app.jar