# Dockerfile
FROM openjdk:11-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/_2122-4bhif-pos1-csesierei-blocketwiki-0.0.1-SNAPSHOT.jar
COPY target/_2122-4bhif-pos1-csesierei-blocketwiki-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]