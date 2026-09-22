# Kinde Management Example

This project demonstrates how to use the Kinde Management library, which leverages the OpenAPI specification to generate client code for interacting with the Kinde management API. This example covers tasks such as managing users, applications, roles, and other administrative functions within your Kinde domain.

## Overview

The Kinde Management library provides a simplified way to access Kinde's management API, making it easy to manage user roles, applications, and other administrative tasks for your Kinde domain. This example will guide you through interacting programmatically with your Kinde environment.

## Setup

To configure the unit tests, create a `.env` file in the root directory of this project. This file will contain the necessary environment variables required for the tests to run successfully.

### Required Environment Variables

```shell
KINDE_DOMAIN=https://{YOUR_DOMAIN}.kinde.com
KINDE_CLIENT_ID={YOUR_CLIENT_ID}
KINDE_CLIENT_SECRET={YOUR_CLIENT_SECRET}
KINDE_REDIRECT_URI=http://localhost:8080/kinde-j2ee-app/login
KINDE_GRANT_TYPE=authorization_code
KINDE_SCOPES=openid
KINDE_AUDIENCE=https://{YOUR_DOMAIN}.kinde.com/api
```

#### Explanation of Each Variable
- **KINDE_DOMAIN**: Replace `{YOUR_DOMAIN}` with your Kinde domain (e.g., `myapp.kinde.com`).
- **KINDE_CLIENT_ID**: Replace `{YOUR_CLIENT_ID}` with your application's client ID, which you can obtain from the Kinde dashboard.
- **KINDE_CLIENT_SECRET**: Replace `{YOUR_CLIENT_SECRET}` with your application's client secret, also available from the Kinde dashboard.
- **KINDE_REDIRECT_URI**: Replace `{YOUR_REDIRECT_URI}` with the appropriate URI where Kinde will redirect users after authentication. Typically set to `http://localhost:8080/kinde-j2ee-app/login` during testing.
- **KINDE_GRANT_TYPE**: Set to `authorization_code`, indicating that the application will use the Authorization Code Grant flow.
- **KINDE_SCOPES**: Set to `openid` to request an ID token from the identity provider.
- **KINDE_AUDIENCE**: Replace `{YOUR_DOMAIN}` with the URL of the API endpoint for your domain, specifying which API your client should have access to.

Make sure to replace all placeholder values (`{YOUR_DOMAIN}`, `{YOUR_CLIENT_ID}`, `{YOUR_CLIENT_SECRET}`) with your specific configuration details before running the tests.

### Installing Dependencies

Before running the tests, make sure all necessary dependencies are installed. You can do this by running the following command:

```shell
mvn clean install
```

This command will install all required Maven dependencies for the project.

## Running the Tests

You can run the unit tests using either your Integrated Development Environment (IDE) or Maven from the command line.

### Running Tests with Maven

To run the tests using Maven, use the following command:

```shell
mvn -Dtest=KindeManagementExampleTest test
```

This command will execute the `KindeManagementExampleTest` class, running all tests defined within it. Make sure you run this command from the project's root directory.

## Using the Example

Once the tests have successfully run, you can modify the example operations to suit your specific use case. The provided examples include user management, application settings, and more. Simply update the method parameters to match your domain requirements.

## Expected Output

Upon successful execution, the tests will confirm key management functionalities, such as creating users and assigning roles, displaying confirmation messages in the console.

