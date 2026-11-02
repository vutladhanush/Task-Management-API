# Task Management REST API

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Backend-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![Maven](https://img.shields.io/badge/Build-Maven-red)

A RESTful backend service built with **Java 17, Spring Boot, Spring Data JPA, and MySQL** for managing users and their tasks. It follows a layered architecture (Controller → Service → Repository), uses DTOs to decouple the API from the persistence model, and handles errors consistently through a global exception handler.

---

## Table of Contents

- [Key Features](#key-features)
- [Tech Stack](#tech-stack)
- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [Data Model](#data-model)
- [Getting Started](#getting-started)
- [API Reference](#api-reference)
- [Sample Requests and Responses](#sample-requests-and-responses)
- [Error Handling](#error-handling)
- [Testing](#testing)
- [Future Enhancements](#future-enhancements)
- [Author](#author)

---

## Key Features

- **User management**: full CRUD for users.
- **Task management**: full CRUD for tasks.
- **One-to-many relationship**: a user can own multiple tasks.
- **Task lifecycle**: status values `PENDING`, `IN_PROGRESS`, `COMPLETED`.
- **Task prioritization**: priority values `LOW`, `MEDIUM`, `HIGH`.
- **DTO-based design**: request and response objects are separate from entities.
- **Global exception handling**: consistent error responses via `@RestControllerAdvice`.
- **Externalized configuration**: database credentials are read from environment variables, never hard-coded.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Programming language |
| Spring Boot | Application framework |
| Spring Data JPA | Data access layer |
| Hibernate | ORM |
| MySQL | Relational database |
| Maven | Build and dependency management |
| Postman | API testing |
| Git & GitHub | Version control |

## Architecture

The application is organized in three layers with clear responsibilities:

```text
Client (Postman / Frontend)
        │
        ▼
Controller layer   → handles HTTP requests and responses, maps DTOs
        │
        ▼
Service layer      → business logic and validation
        │
        ▼
Repository layer   → Spring Data JPA interfaces
        │
        ▼
MySQL database
```

## Project Structure

```text
task-management-api/
├── src/
│   ├── main/
│   │   ├── java/com/task/
│   │   │   ├── controller/      # REST controllers
│   │   │   ├── dto/             # Request and response objects
│   │   │   ├── entity/          # JPA entities and enums
│   │   │   ├── exception/       # Custom exceptions and global handler
│   │   │   ├── repository/      # Spring Data JPA repositories
│   │   │   ├── service/         # Business logic
│   │   │   └── TaskManagementApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## Data Model

```text
User (1) ─────────< (N) Task
```

| Entity | Notable fields |
|---|---|
| User | id, name, email, tasks |
| Task | id, title, description, status, priority, dueDate, user |

> Adjust the field list above to match your entity classes exactly.

## Getting Started

### Prerequisites

- Java 17 or higher
- MySQL 8.x (running locally)
- Git
- Maven (optional, the Maven Wrapper is included)

### 1. Clone the repository

```bash
git clone https://github.com/vutladhanush/task-management-api.git
cd task-management-api
```

### 2. Create the database

```sql
CREATE DATABASE task_db;
```

### 3. Configure environment variables

| Variable | Example |
|---|---|
| `DB_URL` | `jdbc:mysql://localhost:3306/task_db` |
| `DB_USERNAME` | `root` |
| `DB_PASSWORD` | `your_mysql_password` |

**Linux / macOS**

```bash
export DB_URL=jdbc:mysql://localhost:3306/task_db
export DB_USERNAME=root
export DB_PASSWORD=your_mysql_password
```

**Windows (PowerShell)**

```powershell
$env:DB_URL="jdbc:mysql://localhost:3306/task_db"
$env:DB_USERNAME="root"
$env:DB_PASSWORD="your_mysql_password"
```

### 4. Run the application

**Linux / macOS**

```bash
./mvnw spring-boot:run
```

**Windows**

```bash
mvnw.cmd spring-boot:run
```

The API is available at **http://localhost:8081**.

## API Reference

**Base URL:** `http://localhost:8081`

### User Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/users` | Create a user |
| GET | `/api/users` | Get all users |
| GET | `/api/users/{id}` | Get a user by ID |
| PUT | `/api/users/{id}` | Update a user |
| DELETE | `/api/users/{id}` | Delete a user |

### Task Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/tasks` | Create a task |
| GET | `/api/tasks` | Get all tasks |
| GET | `/api/tasks/{id}` | Get a task by ID |
| PUT | `/api/tasks/{id}` | Update a task |
| DELETE | `/api/tasks/{id}` | Delete a task |

### Allowed Enum Values

| Field | Values |
|---|---|
| `status` | `PENDING`, `IN_PROGRESS`, `COMPLETED` |
| `priority` | `LOW`, `MEDIUM`, `HIGH` |

## Sample Requests and Responses

### Create a task

`POST /api/tasks`

```json
{
  "title": "Learn Spring Boot",
  "description": "Build REST APIs using Spring Boot",
  "status": "PENDING",
  "priority": "HIGH",
  "dueDate": "2026-11-15",
  "userId": 1
}
```

Example response (`201 Created`; update to match your actual response DTO):

```json
{
  "id": 1,
  "title": "Learn Spring Boot",
  "description": "Build REST APIs using Spring Boot",
  "status": "PENDING",
  "priority": "HIGH",
  "dueDate": "2026-11-15",
  "userId": 1
}
```

## Error Handling

Errors are handled centrally by a global exception handler so clients always receive a predictable response. Example for a missing resource (`404 Not Found`; update to match your actual error format):

```json
{
  "timestamp": "2026-11-02T15:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Task not found with id: 99"
}
```

## Testing

All endpoints can be tested with **Postman**:

1. Start the application.
2. Create a user with `POST /api/users`.
3. Create a task with `POST /api/tasks`, using that user's ID.
4. Exercise the GET, PUT and DELETE endpoints.

## Future Enhancements

- Authentication and authorization with Spring Security and JWT
- Request validation with Bean Validation (`@Valid`)
- Pagination, sorting and filtering for task listings
- Swagger / OpenAPI documentation
- Unit and integration tests with JUnit and Mockito
- Docker and Docker Compose setup

## Author

**Dhanush Vutla**

- GitHub: [github.com/vutladhanush](https://github.com/vutladhanush)
