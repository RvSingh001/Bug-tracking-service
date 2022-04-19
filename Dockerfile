FROM openjdk:11-jdk-alpine
USER root
EXPOSE 9090
ADD target /
ENTRYPOINT ["java","-jar","/bug-tracking-service-0.0.1-SNAPSHOT.jar"]
