# Employee Management System API

Overview

The **Employee Management System API** is a RESTful backend application built using **Spring Boot**. It provides CRUD (Create, Read, Update, Delete) operations for managing employee records and demonstrates core backend development concepts such as layered architecture, DTOs, validation, and global exception handling.

This project was built as part of my Spring Boot learning journey to strengthen my backend development fundamentals through hands-on implementation.

---

 Features

* Create a new employee
* Retrieve all employees
* Retrieve an employee by ID
* Update employee details
* Delete an employee
* Request and Response DTO implementation
* Bean Validation for request data
* Custom Exception Handling
* Global Exception Handling
* RESTful API design
* Spring Data JPA integration
* H2 in-memory database

---

 Tech Stack

* Java 18
* Spring Boot
* Spring Web MVC
* Spring Data JPA
* Hibernate
* Bean Validation
* H2 Database
* Gradle
* Postman
* IntelliJ IDEA

---

Project Structure

```
src
└── main
    ├── java
    │   └── com.example.Employee.Management.System.API
    │       ├── controller
    │       ├── dto
    │       ├── entity
    │       ├── exception
    │       ├── repository
    │       ├── service
    │       └── EmployeeManagementSystemApiApplication
    └── resources
        └── application.properties
```

The project follows a layered architecture:

```
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
H2 Database
```

---

 REST API Endpoints

| HTTP Method | Endpoint         | Description                 |
| ----------- | ---------------- | --------------------------- |
| POST        | `/employee`      | Create a new employee       |
| GET         | `/employee`      | Retrieve all employees      |
| GET         | `/employee/{id}` | Retrieve an employee by ID  |
| PUT         | `/employee/{id}` | Update an existing employee |
| DELETE      | `/employee/{id}` | Delete an employee          |

---

 Request Validation

The application validates incoming requests using Bean Validation.

Implemented validations include:

* Name must not be blank
* Email must be a valid email address
* Department must not be blank
* Salary must not be null
* Salary must be greater than 0

Example validation response:

```json
{
  "name": "must not be blank",
  "email": "must be a well-formed email address",
  "department": "must not be blank",
  "salary": "must be greater than 0"
}
```

---

 Exception Handling

The application uses a Global Exception Handler to return meaningful error responses.

Implemented exceptions:

* EmployeeNotFoundException
* MethodArgumentNotValidException

Example:

```json
{
  "name": "must not be blank",
  "email": "must be a well-formed email address"
}
```

---

 API Testing

The REST APIs were tested using **Postman**.

Test scenarios covered:

* Create Employee
* Get All Employees
* Get Employee by ID
* Update Employee
* Delete Employee
* Employee Not Found
* Invalid Email
* Blank Required Fields
* Negative Salary
* Missing Required Fields

---

## 📚 Concepts Learned

Through this project, I gained practical experience with:

* Spring Boot application structure
* Layered Architecture
* REST API development
* CRUD operations
* DTO Pattern
* Spring Data JPA
* Bean Validation
* Global Exception Handling
* Custom Exception Handling
* Request validation using `@Valid`
* API testing with Postman
