# Task Management REST API

A backend application built using **Java, Spring Boot, Spring Data JPA, and MySQL** to manage users and their tasks through RESTful APIs.

## Features

- User Management – Create, retrieve, update, and delete users.
- Task Management – Create, retrieve, update, and delete tasks.
- User–Task Relationship – Assign multiple tasks to a user.
- Task Status Management – PENDING, IN_PROGRESS, COMPLETED.
- Task Priority Management – LOW, MEDIUM, HIGH.
- DTO-based request and response handling.
- Global exception handling.
- MySQL database integration.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Data JPA | Database Operations |
| Hibernate | ORM |
| MySQL | Database |
| Maven | Build Management |
| Postman | API Testing |
| Git & GitHub | Version Control |

## Project Structure

```text
task-management/
├── src/
│   ├── main/
│   │   ├── java/com/task/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── entity/
│   │   │   ├── exception/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── TaskManagementApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE task_db;
```

Configure the following environment variables:

```text
DB_URL=jdbc:mysql://localhost:3306/task_db
DB_USERNAME=root
DB_PASSWORD=your_mysql_password
```

The application uses these environment variables for database connectivity.

## Run the Application

**1. Clone the repository**

```bash
git clone https://github.com/vutladhanush/task-management-api.git
```

**2. Navigate to the project directory**

```bash
cd task-management-api
```

**3. Configure MySQL credentials**

Set the required environment variables and ensure MySQL is running.

**4. Run the application**

Windows:

```bash
mvnw.cmd spring-boot:run
```

Linux / macOS:

```bash
./mvnw spring-boot:run
```

Application runs at:

```text
http://localhost:8081
```

## REST API Endpoints

### User APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/users` | Create user |
| GET | `/api/users` | Get all users |
| GET | `/api/users/{id}` | Get user by ID |
| PUT | `/api/users/{id}` | Update user |
| DELETE | `/api/users/{id}` | Delete user |

### Task APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/tasks` | Create task |
| GET | `/api/tasks` | Get all tasks |
| GET | `/api/tasks/{id}` | Get task by ID |
| PUT | `/api/tasks/{id}` | Update task |
| DELETE | `/api/tasks/{id}` | Delete task |

## Sample Task Request

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

## Testing

All REST API endpoints can be tested using **Postman**.
## API Testing Screenshots

All REST API endpoints were tested using Postman.

### Create User
![Create User](screenshots/create-user.png)

### Get All Users
![Get All Users](screenshots/get-users.png)

### Create Task
![Create Task](screenshots/create-task.png)

### Get All Tasks
![Get All Tasks](screenshots/get-tasks.png)

### Get Task By ID
![Get Task By ID](screenshots/get-task-by-id.png)

### Update Task
![Update Task](screenshots/update-task.png)

### Delete Task
![Delete Task](screenshots/delete-task.png)

## Author

**Dhanush Vutla**

- GitHub: https://github.com/vutladhanush

---

⭐ If you find this project useful, feel free to explore the repository.
