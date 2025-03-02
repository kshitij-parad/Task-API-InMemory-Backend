# 📝 Task API - Spring Boot (In-Memory)

A simple Spring Boot REST API for managing tasks with an in-memory storage system.

---

## 🚀 Features
- Add, update, delete, and retrieve tasks.
- Uses an **AtomicInteger** for unique task IDs.
- No database required (in-memory storage).

---

## 🏗️ Tech Stack
- **Backend:** Spring Boot
- **Language:** Java
- **Build Tool:** Maven

---

## 🔧 Setup Instructions

### **1️⃣ Prerequisites**
- Java 17+ installed
- Maven installed

### **2️⃣ Clone the Repository**
```sh
git clone https://github.com/kshitij-parad/todo-app-backend.git
cd todo-app-backend
3️⃣ Run the Application
sh
Copy
Edit
mvn spring-boot:run
The server will start at: http://localhost:8080

📌 API Endpoints
🌟 Get All Tasks
http
Copy
Edit
GET /api/task
Response:

json
Copy
Edit
[
  {
    "id": 1,
    "name": "Example Task",
    "desc": "This is a sample task"
  }
]
➕ Add a Task
http
Copy
Edit
POST /api/task
Request Body:

json
Copy
Edit
{
  "name": "New Task",
  "desc": "Task description"
}
Response: "Task {id} Added Successfully."

🗑️ Delete a Task
http
Copy
Edit
DELETE /api/task/{id}
Response: "Task Deleted!!"

🔄 Update a Task
http
Copy
Edit
PUT /api/task/{id}
Request Body:

json
Copy
Edit
{
  "name": "Updated Task",
  "desc": "Updated description"
}
Response: "Task Updated!"

🎯 To-Do List
✅ Add more validations
✅ Improve error handling
🔲 Integrate with a database (MySQL/PostgreSQL)
👨‍💻 Author
Kshitij Parad
📧 Your Email
📌 GitHub: @kshitij-parad

📝 License
This project is licensed under the MIT License.

yaml
Copy
Edit

---

✅ **This file is ready to be used!** Let me know if you need any changes. 🚀
