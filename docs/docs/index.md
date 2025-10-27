# Insurance Calculator

A lightweight **Spring Boot + Thymeleaf** application to calculate car insurance premiums based on:

- Jahreskilometer (annual mileage)
- Fahrzeugtyp (vehicle type)
- Region (postcode → federal state)

---

## Features

- Modular structure (`region`, `quote`, `web`)
- Configurable region factors in `application.yml`
- Postcode lookup via CSV file
- Persisted quotes in an H2 database
- Tested with JUnit, Mockito & MockMvc

---

## Quick Start

### Prerequisites
* Java 21+
* Maven 3.6+

#### Build and run
`./mvnw spring-boot:run`

#### Open in browser
https://car-insurance-calculator-production.up.railway.app/
