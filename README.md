# Kinde Starter Kit - Java

This project provides example of how to use the Kinde-Java-SDK.

## Register an account on Kinde

To get started set up an account on [Kinde](https://app.kinde.com/register).

## Setup your local environment

Clone this repo and install dependencies by running `mvn clean install`

## Project Overview
This project consists of the following sub projects
- kinde-core-example: This is a unit test that provides an example of how to use the library directly.
- kinde-j2ee-exmaple: An example J2EE project, using the Kinde-j2ee servlet.
- kinde-management-example: This is a unit test that gives you an example of how to use the management API directly.
- springboot-pkce-client-example: A standalone pkce springboot example.
- springboot-thymeleaf: A complete spring boot standalone example.

## Configuring the kinde-core-example and kinde-management-example
In `.env` file, set the following variables with the details from the Kinde `App Keys` page

```shell
KINDE_DOMAIN=https://burntjam.kinde.com
KINDE_CLIENT_ID=<replace>
KINDE_CLIENT_SECRET=<replace>
KINDE_REDIRECT_URI=http://localhost:8080/kinde-j2ee-app/login
KINDE_GRANT_TYPE=CODE
KINDE_SCOPES=openid
```

## Configurating the kinde-j2ee-example
The kinde-j2ee-example is a war, and is deployed into a running application server such as tomcat. In order to configure it, you need to export the following variables

```shell
export KINDE_DOMAIN=https://burntjam.kinde.com
export KINDE_CLIENT_ID=<replace>
export KINDE_CLIENT_SECRET=<replace>
export KINDE_REDIRECT_URI=http://localhost:8080/kinde-j2ee-app/login
export KINDE_GRANT_TYPE=CODE
export KINDE_SCOPES=openid
```

## Configuring the springboot-pkce-client-example.
This configuration is performed through the supplied application.yaml file.
```yaml
spring:
  security:
    oauth2:
      client:
        provider:
          kinde:
            issuer-uri: https://<replace>.kinde.com
        registration: 
          pkce: 
            provider: kinde
            client-id: <replace>
            client-secret: <replace>
            scope: openid,email
```
