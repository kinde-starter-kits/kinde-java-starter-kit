# Spring boot Kinde OAuth Stand alone project example

This project demonstrates the integration of OAuth2 login with Kinde using Spring Boot and Spring Security. The application provides a simple web interface with authentication and role-based authorization.

Run the app, go to `http://localhost:8080` and click sign up to add your new Kinde application. You will need your Kinde domain, client id and client secret from the Kinde portal for the `.env` file. You will also need to configure roles and permissions on the Kinde portal. This starter uses three for demonstration purposes: `read`, `write` and `admin`. You will need to add at least `admin` as a minimum. 

## Table of Contents

- [Requirements](#requirements)
- [Project Setup](#project-setup)
- [Configurations](#configurations)
- [Running the Application](#running-the-application)
- [Endpoints](#endpoints)
- [Security Configuration](#security-configuration)
- [Logout Handling](#logout-handling)

## Requirements

- Java 17 or later
- Maven 3.6+
- Spring Boot 3.3.3

## Project Setup

1. **Clone the repository:**

   ```bash
   git clone git@github.com:KomanRudden/kinde-spring-thymeleaf-oauth.git
   cd kinde-spring-thymeleaf-oauth
   ```

2. **Build the project:**

   ```bash
   mvn clean install
   ```

3. **Run the application:**

   ```bash
   mvn spring-boot:run
   ```

## Configurations

### Dependencies

The `pom.xml` includes the following essential dependencies:

- `spring-boot-starter-security`: Provides core Spring Security components.
- `spring-boot-starter-oauth2-client`: Enables OAuth2 client capabilities.
- `spring-boot-starter-oauth2-resource-server`: Supports resource server capabilities with JWT.
- `spring-boot-starter-thymeleaf`: Allows server-side rendering using Thymeleaf.
- `spring-webflux`: Required for the reactive WebClient used in OAuth2 requests.
- `kinde-core`: Kinde specific SDK for interacting with their API.

### Environmental Configuration

#### Environmental configuration
Configuring via the operating system

```shell
export KINDE_DOMAIN=https://<replace>.kinde.com
export KINDE_CLIENT_ID=<replace>
export KINDE_CLIENT_SECRET=<replace>
export KINDE_REDIRECT_URI=http://localhost:8080/kinde-j2ee-app/login
export KINDE_GRANT_TYPE=CODE
export KINDE_SCOPES=openid
export KINDE_PREFIX=<replace>
```

#### '.env' file configuration
'.env' file configuration
```shell
KINDE_DOMAIN=https://<replace>.kinde.com
KINDE_CLIENT_ID=<replace>
KINDE_CLIENT_SECRET=<replace>
KINDE_REDIRECT_URI=http://localhost:8080/kinde-j2ee-app/login
KINDE_GRANT_TYPE=CODE
KINDE_SCOPES=openid
KINDE_PREFIX=<replace>
```

### Security Configuration

The security is configured in `SecurityConfig.java`. Key configurations include:

- **OAuth2 Login and Resource Server:** The application is set up as an OAuth2 client and resource server, using JWT for securing API endpoints.
- **Method-level Security:** Secures individual controller methods based on roles.
- **JWT Authority Extraction:** Extracts roles from the JWT `permissions` claim and maps them to Spring Security authorities.

## Running the Application

1. **Start the Application:**
   Run the application using the Maven command:

   ```bash
   mvn spring-boot:run
   ```

2. **Access the Application:**
   Open your browser and navigate to `http://localhost:8080`.

## Endpoints

The application provides several endpoints:

- **`/home` or `/`** - Publicly accessible landing page.
- **`/admin`** - Accessible to users with the `admin` role. 
- **`/read`** - Accessible to users with the `read` role.
- **`/write`** - Accessible to users with the `write` role.
- **`/dashboard`** - Displays the user's Kinde profile data.
- **`/register`** - Register a new user for your Kinde Organisation.
- **`/create/org`** - Create a new Kinde Organsisation.

## Security Configuration

- **Public Access:**
  The landing page (`/home`, `/`) and static resources (`/css/**`) are accessible without authentication.

- **Authenticated Access:**
  Other routes require authentication, and access is controlled by roles. For example, `/register` and `/create/org` require the `admin` role.

- **JWT Processing:**
  The JWT `permissions` claim is used to assign roles provided from Kinde.

## Logout Handling

The application handles logout with the following settings:

- **Logout URL:** `/logout`
- **Logout Success URL:** `/`
- **Session Management:** Invalidates the session and clears authentication.

## Conclusion

This project sets up a basic Spring Boot application with OAuth2 authentication and role-based authorization using Kinde. You can extend the functionality by customizing the roles, adding more endpoints, or integrating additional services as needed.