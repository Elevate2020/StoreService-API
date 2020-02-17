FROM openjdk:8-jre-alpine
EXPOSE 8080
WORKDIR /usr/src/app/target
COPY target/*.jar .
ENTRYPOINT [ "sh", "-c", "java -jar /usr/src/app/target/*.jar" ]
