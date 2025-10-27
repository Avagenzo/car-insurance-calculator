# Application Modules

## 1. `region` Module
- Loads `postcodes.csv`
- Maps postcode → region code
- Looks up configurable factors (from YAML)
- Provides factor via `RegionService`

## 2. `quote` Module
- Calculates insurance premium
- Applies rounding (2 decimals)
- Persists quotes in H2 via `QuoteRepository`
- Provides REST endpoint `/api/quotes/calculate`

## 3. `web` Module
- Renders Thymeleaf templates (`index.html`, `result.html`)
- Integrates with `QuoteService`
- Provides user-friendly web interface

## 4. Shared Infrastructure
- Uses Spring Boot auto-configuration
- Uses Spring Modulith for logical separation