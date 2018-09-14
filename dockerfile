FROM openjdk:8u171-jdk-alpine3.8
LABEL Description="MemberInfoService running JDK8 on Alpine 3.8"
LABEL Jeremy Menke-Fields <jeremy.menke-fields@deancare.com>
VOLUME /tmp
ADD member-info-0.1.0-SNAPSHOT.jar app.jar
EXPOSE 9102
ENTRYPOINT ["java", "-jar", "/app.jar"]
