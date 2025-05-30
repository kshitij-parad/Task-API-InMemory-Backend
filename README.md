Sure Kshitij! Here's a **clean, detailed, and professional** version of the `README.md` for your Spring Boot backend project: **TaskZen**. It's copy-paste ready.

---

```markdown
# 🧘 TaskZen - Backend

TaskZen is a simple, secure, and scalable **Task Management REST API** built with **Spring Boot** and **MySQL**, designed for personal productivity applications. This backend handles authentication, user-specific task management, and integrates seamlessly with a modern frontend (built using Next.js).

---

## 📌 Key Features

- 🔐 **JWT Authentication** (Login & Registration)
- 🧑‍💻 **User-Specific Task Management** (Users can only access their own tasks)
- ✅ **CRUD Operations** for tasks
- 🔄 **DTO-based Clean API Design**
- 🔒 **Spring Security Integration**
- 🌐 **CORS Enabled** for frontend communication

---

## 📁 Project Structure

```

TaskZen-Backend/
├── config/             # Spring Security configuration
├── controller/         # REST Controllers for auth and tasks
├── dto/                # Data Transfer Objects (request/response models)
├── model/              # JPA Entities (User, Task)
├── repository/         # Spring Data JPA Repositories
├── service/            # Business Logic
├── security/           # JWT Filters and Utilities
└── application.properties

````

---

## 🔧 Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Security + JWT**
- **MySQL**
- **Spring Data JPA**
- **Lombok**
- **Maven**

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/kshitij-parad/TaskZen-Backend.git
cd TaskZen-Backend
````

### 2. Configure MySQL database

Update `src/main/resources/application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/taskzen_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and run the app

```bash
./mvnw spring-boot:run
```

Server will start at: `http://localhost:8080`

---

## 🔐 Authentication Endpoints

| Method | Endpoint             | Description           |
| ------ | -------------------- | --------------------- |
| POST   | `/api/auth/register` | Register a new user   |
| POST   | `/api/auth/login`    | Login and receive JWT |

> **Note**: You’ll receive a JWT token on login. Use this token in all subsequent requests as:

```
Authorization: Bearer <token>
```

---

## 📌 Task Management Endpoints (Protected)

| Method | Endpoint         | Description          |
| ------ | ---------------- | -------------------- |
| GET    | `/api/task`      | List all tasks       |
| POST   | `/api/task`      | Create a new task    |
| PUT    | `/api/task/{id}` | Update existing task |
| DELETE | `/api/task/{id}` | Delete a task        |

* 🧍 Each task is tied to a specific user.
* 👮 Users **cannot access or modify** others' tasks.

---

## ✅ Completed Functionalities

* [x] Login & Registration (JWT)
* [x] Role-based security (user-specific tasks)
* [x] CRUD operations with validation
* [x] DTOs for request & response bodies
* [x] Logout functionality (client side)
* [x] Integration-ready for frontend

---

## 🤔 Why Use This Project?

This project is ideal if you're:

* Practicing full-stack app development
* Preparing for backend developer interviews
* Learning Spring Security with JWT
* Building a personal productivity app

---

## 👤 Author

**Kshitij Parad**
🔗 [GitHub Profile](https://github.com/kshitij-parad)

---

## 📄 License

This project is open-source and free to use.

---
