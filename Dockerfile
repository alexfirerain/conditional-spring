FROM openjdk:18-ea-11-jdk-alpine3.15
EXPOSE 8081
ADD build/libs/conditional-spring-0.0.1-SNAPSHOT.jar conditiapp.jar
ENTRYPOINT ["java","-jar","/conditiapp.jar"]