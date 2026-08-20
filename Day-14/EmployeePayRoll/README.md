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

## Security

HTTP Basic auth with two in-memory roles (hardcoded for local dev — see `SecurityConfig.java`):

| Role | Username | Password | Access |
|---|---|---|---|
| ADMIN | `admin` | `admin123` | Full access — CRUD employees, generate payslips |
| EMPLOYEE | `employee` | `employee123` | Read-only — view employees and payslips |

All `GET` endpoints accept either role. `POST /employees`, `PUT /employees/{id}`,
`DELETE /employees/{id}`, and `POST /employees/{id}/payslips` require `ADMIN`.

**Known limitation:** EMPLOYEE is read-only but not scoped to "their own" data — any
authenticated EMPLOYEE can currently read every employee's records and payslips. Proper
row-level scoping (linking a username to a specific `employeeId`) is a reasonable next
step but wasn't in scope for "basic auth."

### Example: authenticated request

```bash
curl -u admin:admin123 http://localhost:8080/employees

curl -u employee:employee123 -X POST http://localhost:8080/employees \
  -H "Content-Type: application/json" \
  -d '{"name":"Test","department":"Eng","basicSalary":1000}'
# -> 403 Forbidden (EMPLOYEE can't create)
```

## Payslips

A payslip is a **frozen snapshot** of an employee's pay for a given month — unlike
`Employee.grossSalary`/`netSalary` (calculated live), a payslip's numbers don't change
even if the employee's salary is edited afterward.

| Method | URL | Body |
|---|---|---|
| POST | `/employees/{employeeId}/payslips` | `{ "month": "2026-08" }` (optional — defaults to current month) |
| GET | `/employees/{employeeId}/payslips` | — (list, newest month first) |
| GET | `/employees/{employeeId}/payslips/{payslipId}` | — |

- Generating a payslip for a month that already has one returns **409 Conflict**.
- Generating for a non-existent employee returns **404 Not Found**.
- `month` must be `yyyy-MM` format if provided, e.g. `"2026-08"`.

### Sample POST response

```json
{
  "id": 1,
  "employeeId": 1,
  "payMonth": "2026-08",
  "basicSalary": 50000,
  "allowances": 5000,
  "taxPercent": 10,
  "grossSalary": 55000.00,
  "netSalary": 49500.00,
  "generatedAt": "2026-08-20T12:34:56.789"
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
- Added a `Payslip` entity/table with its own DAO, service, and controller — a monthly snapshot
  of pay, separate from the live `Employee` gross/net calculation.
- Added Spring Security with HTTP Basic and two in-memory roles (ADMIN full access, EMPLOYEE
  read-only). All endpoints now require authentication.
