FROM openjdk:8-jre-alpine
EXPOSE 8081
WORKDIR /usr/src/app/target
COPY target/*.jar .
ENTRYPOINT [ "sh", "-c", "java -jar /usr/src/app/target/*.jar" ]
