# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.0/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.0/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/4.0.0/reference/web/servlet.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/4.0.0/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Security](https://docs.spring.io/spring-boot/4.0.0/reference/web/spring-security.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/4.0.0/reference/using/devtools.html)

http://localhost:8080/hsqldb

# Register
curl -X POST http://localhost:8080/api/auth/register -H "Content-Type: application/json" -d '{"login":"alice","name":"Alice Doe","email":"alice@example.com","password":"Secret123"}'

# Login (form login works with session, but POST also works)
curl -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -c cookie.txt -d '{"login":"alice","password":"Secret123"}'
