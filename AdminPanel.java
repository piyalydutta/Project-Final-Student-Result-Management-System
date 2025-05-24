 import java.util.Scanner;

public class AdminPanel extends ResultSystem {

    public void adminPanel(Scanner sc) {
        int choice;
        do {
            System.out.println("\n--- Admin Panel ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student Marks");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Add Subject to Student");
            System.out.println("6. Delete Subject from Student");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Set Password: ");
                    String pass = sc.nextLine();
                    addStudent(new Student(id, name, pass));
                    System.out.println("Student added successfully.");
                }
                case 2 -> {
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (students.containsKey(id)) {
                        Student student = students.get(id);
                        student.showMarksAndGrades();
                        System.out.print("Enter Subject Name to Edit Marks: ");
                        String subject = sc.nextLine();
                        System.out.print("Enter New Marks: ");
                        int marks = sc.nextInt();
                        student.editSubjectMarks(subject, marks);
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter Student ID to Delete: ");
                    int id = sc.nextInt();
                    students.remove(id);
                    System.out.println("Student deleted successfully.");
                }
                case 4 -> students.values().forEach(Student::generateReport);
                case 5 -> {
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Subject Name: ");
                    String subject = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();
                    students.get(id).addSubject(subject, marks);
                    System.out.println("Subject added successfully.");
                }
                case 6 -> {
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Subject Name to Delete: ");
                    String subject = sc.nextLine();
                    students.get(id).deleteSubject(subject);
                }
            }
        } while (choice != 0);
    }
}
