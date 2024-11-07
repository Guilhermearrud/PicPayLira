# PicPay Backend Challenge

This project is a backend application developed as part of a challenge for **PicPay**. It was built using the **Java Spring Framework** and implements core functionality for handling user and transaction management. The primary classes implemented in the project are:

- **User**: This class models the user entity, including their information and related functionality.
- **Transaction**: This class handles the logic for creating and managing transactions between users.
- **Controllers**: REST controllers that expose the APIs for interacting with users and transactions.
- **Services**: Business logic for managing users, transactions, and ensuring proper authorization and validation.

## Dependencies

Here is a list of the dependencies used in the project along with a brief description of their purpose:

1. **spring-boot-starter-data-jpa**
   - **Description**: This dependency provides support for **Java Persistence API (JPA)**. It simplifies database operations and allows you to easily integrate and work with relational databases.
   
2. **spring-boot-starter-web**
   - **Description**: This dependency is used to build web applications with **Spring MVC**. It includes everything needed to create REST APIs, such as support for controllers, views, and JSON responses.
   
3. **spring-boot-devtools**
   - **Description**: This dependency provides tools to improve the development experience, including automatic restarts, live reload, and debugging support during runtime. It’s marked as **optional** and **runtime** so it doesn’t affect production builds.
   
4. **h2**
   - **Description**: **H2** is a lightweight **in-memory database** used for development and testing purposes. It allows you to quickly set up a database without needing an external service.
   - **Scope**: `runtime` (only available during runtime for development or testing purposes).
   
5. **lombok**
   - **Description**: **Lombok** is a Java library that helps reduce boilerplate code. It automatically generates getters, setters, constructors, and other common methods, making the code more concise.
   - **Scope**: `optional` (not a required dependency for the final build but used to simplify development).
   
