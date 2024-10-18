# Kinde Spring Boot Starter Example

This project is an example of how to use the Kinde Spring Boot Starter to automatically wire and configure a Spring Boot application. It streamlines the process of setting up authentication with Kinde's OAuth service, making it faster and easier.

## Overview

The Kinde Spring Boot Starter allows developers to quickly integrate Kinde authentication into their Spring Boot applications. This includes support for:

- User-facing applications
- Backend services
- Machine-to-Machine (M2M) configurations

By leveraging this starter, you can reduce the time needed to set up secure authentication for your Spring Boot projects by up to 50%, compared to manual configuration.

## Features
- **Auto-configuration**: Simplifies Spring Boot integration with Kinde.
- **OAuth Support**: Allows easy setup of user and M2M OAuth flows.
- **Rapid Development**: Facilitates quick development and testing of secure Spring Boot applications.

## Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- An IDE like IntelliJ IDEA (optional)

## Getting Started

### Clone the Repository
To start using the Kinde Spring Boot Starter Example, clone this repository:

```sh
git clone https://github.com/kinde-starter-kits/kinde-java-starter-kit.git
cd kinde-java-starter-kit/kinde-springboot-starter-example
```

### Build the Project
The project is built using Maven. To build the project, use the following command:

```sh
mvn clean install
```

### Running the Application
To run the application, you can use either the command line or an IDE like IntelliJ.

#### Using Maven Command Line
To run the application via Maven, execute:

```sh
mvn spring-boot:run
```

#### Using IntelliJ IDEA
If you're using IntelliJ IDEA, simply open the project and use the built-in options to compile and run the application.

## Configuration

The project supports three types of configuration for Kinde's OAuth service:

### 1. Environmental Variables
You can set the necessary configuration values as environment variables. This method is convenient for different environments (development, staging, production) where values change frequently.

Set the following environment variables:
- `KINDE_DOMAIN`: The domain for your Kinde instance (e.g., `https://<business-name>.kinde.com`).
- `KINDE_CLIENT_ID`: Your Kinde client ID.
- `KINDE_CLIENT_SECRET`: Your Kinde client secret.
- `KINDE_SCOPES`: The scopes required, such as `openid,email,profile`.

### 2. .env File
Another option is to use a `.env` file to configure the application. This file should be placed in the root directory of the project.

Example `.env` file:
```
KINDE_DOMAIN=https://<business-name>.kinde.com
KINDE_CLIENT_ID=<client-id>
KINDE_CLIENT_SECRET=<client-secret>
KINDE_SCOPES=openid,email,profile
```

Make sure to replace `<business-name>`, `<client-id>`, and `<client-secret>` with the actual values provided by Kinde.

### 3. YAML Configuration
You can also configure the application by updating the `application.yml` file, located in the `src/main/resources` directory, with your specific settings:

```yaml
kinde:
  oauth2:
    domain: https://<business-name>.kinde.com
    client-id: <client-id>
    client-secret: <client-secret>
    scopes: openid,email,profile
```

Replace `<business-name>`, `<client-id>`, `<client-secret>`, and other values with your credentials provided by Kinde.

## Authentication Flow
This example project implements user-facing authentication using PKCE:
- **User-facing applications**: Users are redirected to Kinde for login using the PKCE flow, and upon successful authentication, are redirected back to your application.

## Additional Resources
For more information about the Kinde Spring Boot Starter and detailed documentation, please refer to:

- [Kinde Documentation](https://kinde.com/docs)
- [Spring Boot Reference Documentation](https://spring.io/projects/spring-boot)

## Contributing
If you'd like to contribute to this project, please fork the repository and submit a pull request with your changes.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

