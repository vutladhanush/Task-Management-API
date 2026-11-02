# Task Management REST API

A robust backend application built with Java, Spring Boot, Spring Data JPA, and MySQL to manage users and their tasks through RESTful APIs.

## Overview

This project provides a complete task management solution where users can be created, updated, retrieved, and deleted, and tasks can be assigned, tracked, and managed efficiently. It follows REST architectural principles and includes DTO-based request/response handling, global exception handling, and database persistence using JPA and Hibernate.

## Features

- User management with CRUD operations
- Task management with CRUD operations
- One-to-many user-task relationship
- Task status tracking: `PENDING`, `IN_PROGRESS`, `COMPLETED`
- Task priority levels: `LOW`, `MEDIUM`, `HIGH`
- DTO-based API request and response models
- Centralized exception handling
- MySQL database integration
- RESTful API design for scalable back-end services

## Tech Stack

| Technology | Purpose |
|-----------|---------|
| Java 17 | Backend programming language |
| Spring Boot | Application framework |
| Spring Data JPA | Data access and persistence |
| Hibernate | ORM framework |
| MySQL | Relational database |
| Maven | Build and dependency management |
| Postman | API testing |
| Git & GitHub | Version control |

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
├── README.md
└── screenshots/
