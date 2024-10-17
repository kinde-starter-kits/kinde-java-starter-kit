# Kinde Java Starter - Extended Version

This repository contains an extended version of the original Kinde Java starter. The updated version has been restructured into several sub-projects, each designed to demonstrate different use cases and configurations for working with Kinde. Below you'll find descriptions and links to each sub-project.

## Sub-Projects Overview

### 1. [kinde-core-example](./kinde-core-example)
A unit test example showcasing how to access Kinde APIs directly. This project focuses on the basics of interacting with Kinde's core APIs, providing a minimal example to get started quickly.

### 2. [kinde-j2ee-example](./kinde-j2ee-example)
An example project demonstrating how to integrate Kinde with a J2EE application. This requires the installation of Tomcat or a similar J2EE application server to run. It is ideal for those working in legacy environments that require a J2EE setup.

### 3. [kinde-management-example](./kinde-management-example)
A unit test example similar to `kinde-core-example`, but focusing specifically on Kinde's management APIs. It is designed to demonstrate how to use the management endpoints for administrative tasks.

### 4. [kinde-springboot-starter-example](./kinde-springboot-starter-example)
Built using the Kinde Spring Boot starter, this example shows how to use the Kinde Spring Boot library to auto-wire and auto-configure a Spring Boot project for authentication against Kinde. It provides a simple and efficient way to integrate Kinde with your Spring Boot application.

### 5. [springboot-pkce-client-example](./springboot-pkce-client-example)
A Spring Boot standalone example that does not rely on Kinde libraries. This example is only dependent on the Spring framework's OAuth libraries and uses a PKCE token for authentication. It is a good starting point for those who prefer using Spring's native libraries for OAuth.

### 6. [springboot-thymeleaf-full-example](./springboot-thymeleaf-full-example)
A comprehensive Spring Boot example that includes Thymeleaf. Similar to `springboot-pkce-client-example`, but with more detailed integration, including frontend interactions. This example is ideal for developers looking for a complete implementation of a web application with Kinde authentication.

## Getting Started

To get started with any of the examples, clone this repository and navigate to the respective sub-project directory. Each project contains its own `README.md` file with instructions on how to build and run the example.

```sh
# Clone the repository
git clone https://github.com/yourusername/kinde-java-starter.git

# Navigate to a specific example
git checkout kinde-core-example
```

Follow the instructions in each sub-project to understand the setup, dependencies, and running procedures.

## Contributing

Feel free to open issues and contribute to this project by adding new examples or enhancing the existing ones. Contributions are always welcome!

## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.