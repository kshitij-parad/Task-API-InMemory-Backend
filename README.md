---
# 📝 Task API - Spring Boot (In-Memory)

A simple **Spring Boot** REST API for managing tasks using an **in-memory storage system**.

---

## 🚀 Features
- CRUD operations: **Add, Update, Delete, and Retrieve Tasks**.
- Uses an **AtomicInteger** for unique task IDs.
- No database required (**In-Memory Storage**).

---

## 🏗️ Tech Stack
- **Backend:** Spring Boot  
- **Language:** Java  
- **Build Tool:** Maven  

---

## 🔧 Setup Instructions

### **1️⃣ Prerequisites**
- Java **17+** installed  
- Maven installed  

### **2️⃣ Clone the Repository**
```sh
git clone https://github.com/kshitij-parad/Task-API-InMemory-Backend.git
cd Task-API-InMemory-Backend
```

### **3️⃣ Run the Application**
```sh
mvn spring-boot:run
```
The server will start at: [http://localhost:8080](http://localhost:8080)

---

## 📌 API Endpoints

### 🌟 Get All Tasks
```http
GET /api/task
```
**Response:**
```json
[
  {
    "id": 1,
    "name": "Example Task",
    "desc": "This is a sample task"
  }
]
```

### ➕ Add a Task
```http
POST /api/task
```
**Request Body:**
```json
{
  "name": "New Task",
  "desc": "Task description"
}
```
**Response:** `"Task {id} Added Successfully."`

### 🗑️ Delete a Task
```http
DELETE /api/task/{id}
```
**Response:** `"Task Deleted!!"`

### 🔄 Update a Task
```http
PUT /api/task/{id}
```
**Request Body:**
```json
{
  "name": "Updated Task",
  "desc": "Updated description"
}
```
**Response:** `"Task Updated!"`

---

## 🎯 To-Do List
✅ Add more validations  
✅ Improve error handling  
🔲 Integrate with a database (**MySQL/PostgreSQL**)  

---

## 👨‍💻 Author  
**Kshitij Parad**  
📌 GitHub: [@kshitij-parad](https://github.com/kshitij-parad)  

---

## 📝 License  
This project is licensed under the **MIT License**.

---
