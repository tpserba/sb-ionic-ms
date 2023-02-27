FROM openjdk:17-jdk-alpine
MAINTAINER baeldung.com
COPY target/reactjava-be-0.0.1-SNAPSHOT.war employee-service.war
ENTRYPOINT ["java", "-jar", "/employee-service.war"]