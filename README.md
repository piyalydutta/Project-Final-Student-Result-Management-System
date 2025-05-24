📚 Student Result Management System (Java Console App)
This is a Java-based console application for managing student academic results. It provides two roles: Admin and Student, each with specific features to add, view, and manage student marks, subjects, and performance reports.

🔧 Features
👨‍💼 Admin Features
Admin Login by Password – Secure login using password Admin@123.

Add Student – Register new students with ID, name, and password.

Edit Student Marks – Modify marks for any subject of a student.

Delete Student – Remove a student permanently from the system.

View All Students – Generate full performance reports for all students.

Add Subject to Student – Add a new subject with marks to a specific student.

Delete Subject from Student – Remove a subject from a student's record.

Logout – Exit the admin panel securely.

🎓 Student Features
Student Login – Login using Student ID and password.

Show Marks and Grades – View marks along with corresponding grades.

Check Pass/Fail – Displays whether the student has passed all subjects.

Subjects Yet to Pass – Shows count of failed subjects (marks < 40).

Generate Performance Report – Detailed academic report with total marks and status.

Apply for Recheck – Request a recheck (can be applied only once).

View Rank – View overall student ranking based on total marks.

Logout – Exit student dashboard.

🏗️ Project Structure
StudentResultManagementSystem.java – Main class to launch and manage login.

AdminPanel.java – Contains admin operations and inherits student database from ResultSystem.

ResultSystem.java – Manages student storage and common login functionalities.

Student.java – Represents student data and logic for marks, grades, and reports.

Subject.java – Represents individual subject and mark with grade logic.

🛠️ Technologies Used
Language: Java (JDK 17+)

Input: Console (Scanner)

Structure: OOP (Encapsulation, Inheritance)

🚀 How to Run
Compile All Files

bash
Copy
Edit
javac *.java
Run the Main Program

bash
Copy
Edit
java StudentResultManagementSystem
Choose Option 1 or 2 for Admin or Student login and explore features.

📌 Default Test Data
Three students are pre-added with IDs and passwords:

ID: 101, Name: Alice, Password: Alice@123

ID: 102, Name: Bob, Password: Bob@456

ID: 103, Name: Charlie, Password: Charlie@789

✅ Output Sample
pgsql
Copy
Edit
Welcome to Student Result Management System
1. Admin Login
2. Student Login
Enter your choice: _
📄 License
This project is provided for educational purposes and free to use or extend.
