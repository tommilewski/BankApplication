# BankApplication
Bank Application is a backend application written in Java using the Spring Boot framework. The application simulates a banking system where users can create an account, deposit money, make transfers, and check their transaction history.

# The following technologies were used in the project:
- Java 19 - the programming language used to write the application.
- Spring Boot - the framework used to create web applications.
- Maven - the build tool used to manage dependencies and build the application.
- JUnit - the framework used for unit testing.
- PostgreSQL - the database used to store data in production.
- H2 - the database used for testing.

# Running the Application
To run the application, follow these steps:
- Clone the repository to your local environment.
- Open the project in your IDE.
- Configure the connection to the PostgreSQL database in the application.properties file.
- Run the application with the command `mvn spring-boot:run`.

# Testing
- The JUnit framework and the H2 database were used for testing. To run the tests, follow these steps:
- Make sure that the H2 database is configured in the application.properties file.
- Run the unit tests with the command `mvn test`.

# TODO (in the future)
- Enable deposit and withdrawal of money. ✅
- Implement currency conversion during transfers. ✅
- Write more tests to increase the test coverage.
- Add security.
