# Kinde Java Starter - Extended Examples

This repository contains the re-developed version of the original Kinde Java starter, now extended to include multiple sub-projects, each focusing on different aspects of integration and usage of Kinde services. The new structure consists of five sub-projects:

1. **[kinde-core-example](./kinde-core-example)**
2. **[kinde-j2ee-example](./kinde-j2ee-example)**
3. **[kinde-management-example](./kinde-management-example)**
4. **[springboot-pkce-client-example](./springboot-pkce-client-example)**
5. **[springboot-thymeleaf-full-example](./springboot-thymeleaf-full-example)**

## Overview of Sub-Projects

### 1. `[kinde-core-example](./kinde-core-example)`

The `[kinde-core-example](./kinde-core-example)` project is a unit test example that demonstrates how to access Kinde's APIs programmatically. This example is ideal for those who want to see how the core functionalities of Kinde can be accessed and tested through Java-based unit tests.

### 2. `[kinde-j2ee-example](./kinde-j2ee-example)`

The `[kinde-j2ee-example](./kinde-j2ee-example)` is a Java 2 Enterprise Edition (J2EE) example that requires the installation of a J2EE application server such as Apache Tomcat. This project demonstrates how to integrate Kinde into a traditional J2EE web application, showcasing integration practices with the J2EE ecosystem.

### 3. `[kinde-management-example](./kinde-management-example)`

The `[kinde-management-example](./kinde-management-example)` is another unit test-based example, similar to `[kinde-core-example](./kinde-core-example)`, but focuses on utilizing Kinde's management APIs. This project is useful for users interested in interacting with the management layer of Kinde, including administrative features.

### 4. `[springboot-pkce-client-example](./springboot-pkce-client-example)`

The `[springboot-pkce-client-example](./springboot-pkce-client-example)` is a standalone Spring Boot application that showcases the usage of Proof Key for Code Exchange (PKCE) in an OAuth flow. This example does **not** require the use of the Kinde libraries and instead relies solely on the Spring framework's OAuth libraries. It is perfect for those looking to implement PKCE-based authentication without any Kinde-specific libraries.

### 5. `[springboot-thymeleaf-full-example](./springboot-thymeleaf-full-example)`

The `[springboot-thymeleaf-full-example](./springboot-thymeleaf-full-example)` is a comprehensive Spring Boot application that expands on the `[springboot-pkce-client-example](./springboot-pkce-client-example)`. It includes a more detailed implementation, making use of the Thymeleaf templating engine for rendering dynamic content. This example provides a full-featured application setup, demonstrating various use cases of OAuth authentication, token handling, and integration with Kinde services.

## Getting Started

To get started with any of these sub-projects:

1. **Clone the repository**:
   ```sh
   git clone https://github.com/your-username/kinde-java-starter.git
   cd kinde-java-starter
   ```

2. **Navigate to the desired sub-project** and follow the instructions provided in the sub-project's README (if available).

## Requirements

- **JDK 11 or higher**
- **Maven or Gradle** for dependency management
- **Spring Boot**, **Apache Tomcat**, or other application servers as needed

Each sub-project may have its own set of specific dependencies and requirements, which are detailed in their respective build files (`pom.xml` or `build.gradle`).

## Running the Examples

- For **Spring Boot** examples, you can run them using the following command:
  ```sh
  ./mvnw spring-boot:run
  ```

- For **J2EE** examples, ensure you have deployed the WAR file to a J2EE application server like Apache Tomcat.

- For **Unit Test** examples (`[kinde-core-example](./kinde-core-example)` and `[kinde-management-example](./kinde-management-example)`), simply run the tests using your preferred IDE or through Maven/Gradle:
  ```sh
  ./mvnw test
  ```

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please fork the repository, create a feature branch, and submit a pull request.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.

## Contact

If you have any questions or issues, please open an issue on GitHub or contact us at [your-email@example.com].
