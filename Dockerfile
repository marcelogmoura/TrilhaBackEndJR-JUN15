FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ADD ./target/task-0.0.1-SNAPSHOT.jar task.jar
ENTRYPOINT ["java","-jar","/task.jar"]
