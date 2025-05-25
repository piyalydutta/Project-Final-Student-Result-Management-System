import java.util.Scanner;

public class StudentResultManagementSystem {
    public static void main(String[] args) {
        AdminPanel adminSystem = new AdminPanel();

        Student s1 = new Student(101, "Alice", "Alice@123");
        s1.addSubject("Math", 85);
        s1.addSubject("Science", 78);
        s1.addSubject("English", 92);

        Student s2 = new Student(102, "Bob", "Bob@456");
        s2.addSubject("Math", 55);
        s2.addSubject("Science", 35);
        s2.addSubject("English", 60);

        Student s3 = new Student(103, "Charlie", "Charlie@789");
        s3.addSubject("Math", 95);
        s3.addSubject("Science", 88);
        s3.addSubject("English", 90);

        adminSystem.addStudent(s1);
        adminSystem.addStudent(s2);
        adminSystem.addStudent(s3);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome to Student Result Management System");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    sc.nextLine();
                    System.out.print("Enter Admin Password: ");
                    String adminPass = sc.nextLine();
                    if (adminPass.equals("Admin@123")) {
                        adminSystem.adminPanel(sc);
                    } else {
                        System.out.println("Incorrect password. Access denied.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter your Student ID to login: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter your Password: ");
                    String password = sc.nextLine();
                    adminSystem.login(id, password, sc);
                }
                default -> System.out.println("Invalid Choice! Exiting...");
            }
        }
    }
}
