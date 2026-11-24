# Calculation Service (EJB + REST)

A small Java EE application that exposes a **calculator as a REST service** and stores every calculation in a database.

Authors: Mohamed Ahmed (20206064) and Mohamed Anas (20206062)

## Features

- `POST /calc` - send a calculation and get the result
- `GET /calculations` - list all stored calculations
- `Calculation` is a JPA entity; the service is a stateless EJB

## Tech stack

- Java, Maven (`war`)
- EJB (`@Stateless`), JPA (`persistence.xml`), JAX-RS
- Deployed on a JBoss / WildFly server

## Project structure

```
src/main/java/
├── application/   # JAX-RS application
├── ejbs/          # Calculation entity
├── query/         # data access
└── services/      # CalculationService (REST), Helper
src/main/resources/META-INF/persistence.xml
```

## Build and run

```bash
mvn clean package
# deploy target/*.war to WildFly / JBoss EAP
```
