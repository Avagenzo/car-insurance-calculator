# System Architecture

The system follows a **modular, layered architecture** using [Spring Modulith](https://spring.io/projects/spring-modulith).


| Layer | Responsibility |
|-------|----------------|
| Web | Provides UI and user input forms |
| Quote | Calculates and persists premiums |
| Region | Loads and maps postcodes to region factors |

---

## Data Flow

1. User submits the form (km, vehicle type, postcode)
2. Controller passes data to `QuoteService`
3. Service requests regional factor from `RegionService`
4. `RegionRepository` reads the CSV for region mapping
5. Final premium = **kmFactor × vehicleFactor × regionFactor**
6. Result persisted and displayed via Thymeleaf