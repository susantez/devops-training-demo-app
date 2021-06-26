FROM adoptopenjdk/openjdk11
COPY target/*.jar /devops-training.jar
ENTRYPOINT ["java","-jar","/devops-training.jar"]

