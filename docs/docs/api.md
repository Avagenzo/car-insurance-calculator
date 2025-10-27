# REST API Reference

All API endpoints are under `/api/quotes`.

---

## `POST /api/quotes/calculate`

Calculates and persists a new insurance quote.

### Example Request
```json
{
  "jahresKilometer": 12000,
  "fahrzeugtyp": "SUV",
  "postleitzahl": "79189"
}
```