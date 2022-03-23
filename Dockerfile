FROM openjdk:latest

USER root



EXPOSE 8082



ADD target /

ENTRYPOINT ["java","-jar","/bug-tracking-service-0.0.1-SNAPSHOT.jar"]