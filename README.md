## About
Sample [Spring Boot](http://projects.spring.io/spring-boot/) application to be used during DevOps 101 trainings workshop sessions

## Requirements

For building and running the application you need:

- [JDK 1.11](https://jdk.java.net/archive/)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.definex.devopstraining.DevopsTrainingApplication` class from your IDE.

Alternatively you can package the application with maven and run the application via command line
```shell
mvn clean package
```
locate to the target directory and execute the package
```shell
cd target
java -jar devops-training-0.0.1.jar
```

use command below to retireve book information generated during initialization by `import.sql`
```shell
curl http://localhost:8080/training/v1/book/all
```

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.