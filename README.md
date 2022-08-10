**Used JPA to perform CRUD operations and Swagger to handle exceptions.**

# Spring Boot - Enabling Swagger2

Swagger2 is an open source project used to generate the REST API documents for RESTful web services. It provides a user interface to access our RESTful web services via the web browser.

## To enable the Swagger2 in Spring Boot application, you need to add the following dependencies in our build configurations file (POM.xml).

```
<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger2</artifactId>
   <version>2.9.2</version>
</dependency>
```

```
<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger-ui</artifactId>
   <version>2.9.2</version>
</dependency>
```

Now, add the @EnableSwagger2 annotation in your main Spring Boot application. The @EnableSwagger2 annotation is used to enable the Swagger2 for your Spring Boot application. or you can create new config class and add @EnableSwagger2 annotation in that file. 

## We can acess the Swagger UI through thr URL http://localhost:8080/swagger-ui.html

