FROM openjdk
EXPOSE 8080
ADD build/libs/conditional-spring-0.0.1-SNAPSHOT.jar condapp.jar
ENTRYPOINT ["java","-jar","/condapp.jar"]