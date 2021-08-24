# springboot seed

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) seed app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `seed.back.admin.App` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) in the admin module like so:

```shell
mvn spring-boot:run
```

## Accessing the H2 Console
 Access this URL : [H2-CONSOLE](http://localhost:8080/h2-console)
## API Documentation
 - The OpenAPI descriptions will be available at this [Path](http://localhost:8080/v3/api-docs/).
 - The OpenAPI definitions are in JSON format by default. For yaml format : [YML Format](http://localhost:8080/api-docs.yaml).
 - You can access the API documentation at: [SWAGGER UI](http://localhost:8080/swagger-ui.html).
   
## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
