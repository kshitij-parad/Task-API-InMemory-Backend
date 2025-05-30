## 🧘 TaskZen - Backend

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

### 2. Configure the MySQL database

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskzen_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> Make sure MySQL is running and the database `taskzen_db` is created manually or auto-created.

### 3. Run the application

```bash
./mvnw spring-boot:run
```

App will be available at: `http://localhost:8080`

---

## 🔐 Authentication Endpoints

| Method | Endpoint             | Description           |
| ------ | -------------------- | --------------------- |
| POST   | `/api/auth/register` | Register a new user   |
| POST   | `/api/auth/login`    | Login and receive JWT |

> After login, you will get a JWT token. Pass this token in the `Authorization` header:

```
Authorization: Bearer <token>
```

---

## 🧠 Task API Endpoints (JWT Required)

| Method | Endpoint         | Description                 |
| ------ | ---------------- | --------------------------- |
| GET    | `/api/task`      | Get tasks of logged-in user |
| POST   | `/api/task`      | Create a new task           |
| PUT    | `/api/task/{id}` | Update a task by ID         |
| DELETE | `/api/task/{id}` | Delete a task by ID         |

* ✅ Users can only manage **their own tasks**
* 🔐 Every request must include a valid JWT

---

## ✅ Completed Features

* [x] JWT Login and Registration
* [x] User-specific task isolation
* [x] DTOs for clean request/response
* [x] Frontend-compatible CORS
* [x] Logout (client-side)
* [x] Dynamic task list with Edit/Delete
* [x] MySQL Database integration

---

## 🧪 Example JSON Payloads

### Register

```json
{
  "username": "kp",
  "password": "password"
}
```

### Login

```json
{
  "username": "kp",
  "password": "password"
}
```

### Create Task

```json
{
  "name": "New Task",
  "description": "Do something productive"
}
```

---

## 👨‍💻 Author

**Kshitij Parad**
🔗 [GitHub Profile](https://github.com/kshitij-parad)

---

## 📄 License

This project is open-source and free to use.
```
