# Employee Payroll App

Spring Boot + JdbcTemplate + MySQL, layered architecture (Controller → Service → DAO → DTO).

## Setup in IntelliJ

1. Open IntelliJ → **File → Open** → select this `EmployeePayRoll` folder (IntelliJ will detect the `pom.xml` and import it as a Maven project).
2. Make sure MySQL is running locally. Update credentials in
   `src/main/resources/application.properties` if your username/password isn't `root/root`.
   You don't need to create the database or table manually — `createDatabaseIfNotExist=true`
   creates the DB, and `schema.sql` auto-creates the `employees` table on startup.
3. Run `EmployeePayRollApplication.java` (green play button, or right-click → Run).
4. App starts on `http://localhost:8080`.

## Payroll calculation

`basicSalary` and `allowances` are stored; `taxPercent` is stored as a percentage (e.g. `10` = 10%).
`grossSalary` and `netSalary` are **not stored** — they're calculated on every response:

- `grossSalary = basicSalary + allowances`
- `netSalary = grossSalary - (grossSalary * taxPercent / 100)`

## API Endpoints

| Method | URL | Body |
|---|---|---|
| GET | `/employees` | — |
| GET | `/employees/{id}` | — |
| POST | `/employees` | JSON below |
| PUT | `/employees/{id}` | JSON below |
| DELETE | `/employees/{id}` | — |

### Sample POST body

```json
{
  "name": "Arman Sheikh",
  "department": "Engineering",
  "basicSalary": 50000,
  "allowances": 5000,
  "taxPercent": 10
}
```

### Sample response

```json
{
  "id": 1,
  "name": "Arman Sheikh",
  "department": "Engineering",
  "basicSalary": 50000,
  "allowances": 5000,
  "taxPercent": 10,
  "grossSalary": 55000.00,
  "netSalary": 49500.00
}
```

## What's different from the reference code

- Added `basicSalary`, `allowances`, `taxPercent` fields instead of a single `salary` field.
- Added derived (non-persisted) `grossSalary`/`netSalary` getters on the `Employee` DTO —
  computed live, so they're always in sync with the stored numbers.
- Added `schema.sql` so the table is created automatically instead of needing manual SQL.
- Added `@Valid` on the controller's `@RequestBody` params — the reference code declared
  validation annotations on the DTO but never triggered them.
- Added a `GlobalExceptionHandler` so `EmployeeNotFoundException` and validation errors return
  clean JSON instead of a raw Spring stack trace.
- Removed the unused `import java.net.InterfaceAddress;` that was in the reference `EmployeeService`
  interface (leftover, unused).
