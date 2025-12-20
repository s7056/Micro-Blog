# Getting Started

Install java 21 or higher
make sure to have JAVA_HOME environmental variable set to folder where java is installed

# Backend
To run backend app:
go to /Micro-Blog/backend folder and run app with maven:
- cd backend
- mvnw.com spring-boot:run  (Na Widnowsie)
- ./mvnw spring-boot:run    (Na Linuxie i macOs)

# Maven
maven wrapper is included in project in backend/ folder. It can be used from commandline
mvnw.cmd <polecenie>



# DataBase
database is built-in, runs from file and doesn't require any additional configurations

# API
In Postman workspace there's a project Micro-Blog that contains requests to our API

We use JWT, so we need token for our requests,
postman is configured to automatically use token received in login request

workflow:
 - POST Register - request to register user 
 - POST Login    - logs in registered user, responds with JWT token

all other existing requests are configured to use the last token received from login request

If you're creating new request chose authorization 'Inherit from parent'
or explicitly Authorization: Bearer token with token set to {{token}} 


Can also use curls, but POSTMAN is better
# Register
```bash
curl -X POST http://localhost:8080/api/auth/register -H "Content-Type: application/json" -d '{"login":"alice","name":"Alice Doe","email":"alice@example.com","password":"Secret123"}'
```
```bash
curl -X POST http://localhost:8080/api/auth/register -H "Content-Type: application/json" -d '{"login":"belice","name":"Belice Doe","email":"belice@example.com","password":"Secret123"}'
```
```bash
curl -X POST http://localhost:8080/api/auth/register -H "Content-Type: application/json" -d '{"login":"celice","name":"Celice Doe","email":"celice@example.com","password":"Secret123"}'
```
```bash
curl -X POST http://localhost:8080/api/auth/register -H "Content-Type: application/json" -d '{"login":"delice","name":"Delice Doe","email":"delice@example.com","password":"Secret123"}'
```

# Login but POST also works)

```bash
curl -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d '{"login":"alice","password":"Secret123"}'
```
```bash
curl -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d '{"login":"belice","password":"Secret123"}'
```





