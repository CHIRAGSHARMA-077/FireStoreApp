# Firestore CRUD Android App

This is a simple Android application built using **Firebase Firestore** that demonstrates basic CRUD (Create, Read, Update, Delete) operations.  
The app allows users to enter a **Name** and **Email**, store them in Firestore, retrieve all records, update existing records, and delete them.  

---

## 🚀 Features
- **Save Data** → Add a new document to Firestore  
- **Read Data** → Fetch all documents and display them in a `TextView`  
- **Update Data** → Update existing user data in Firestore  
- **Delete Data** → Remove user data from Firestore  

---

## 📱 UI Components
- 2 × `EditText` (Name, Email)  
- 4 × `Button` (Save, Read, Update, Delete)  
- 1 × `TextView` (to show results)  

---

## 🛠️ Tech Stack
- **Java**  
- **Firebase Firestore**  
- **Android Studio**  

---

## 📂 Project Structure
app/
├── java/
│ └── com.example.firestoreapp/
│ ├── MainActivity.java
│ └── Friend.java
├── res/
│ ├── layout/activity_main.xml
└── google-services.json


📸 Screenshots
1. Firestore Data (2 documents)
   <img width="1366" height="768" alt="Image" src="https://github.com/user-attachments/assets/d78fbdfc-288f-4717-9222-7eeb73d558c0" />


   <img width="1366" height="768" alt="Image" src="https://github.com/user-attachments/assets/e7f11681-542d-4328-8dcb-d61d086a0d66" />


2. Update Operation
   <img width="1366" height="768" alt="Image" src="https://github.com/user-attachments/assets/151d10b0-c806-4192-9f40-800b91d17f5e" />

   <img width="1366" height="768" alt="Image" src="https://github.com/user-attachments/assets/6af4c1ea-cd30-4589-a755-31e6546f42cf" />

3. Displaying Data in TextView
   <img width="1366" height="768" alt="Image" src="https://github.com/user-attachments/assets/ae54e3bf-a291-4d1d-8d27-873809989e93" />

✨ Future Improvements

Show Firestore data in a RecyclerView instead of TextView.

Add authentication for multiple users.

Improve UI with Material Design.
