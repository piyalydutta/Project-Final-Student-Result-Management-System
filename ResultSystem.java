import java.util.*;

public class ResultSystem {
    Map<Integer, Student> students = new HashMap<>();

    void addStudent(Student student) {
        students.put(student.id, student);
    }

    void displayRankingsWithHighlight(int currentStudentId) {
        List<Student> rankedList = new ArrayList<>(students.values());
        rankedList.sort((s1, s2) -> s2.getTotalMarks() - s1.getTotalMarks());

        System.out.println("\n--- Student Rankings ---");
        int rank = 1;
        for (Student s : rankedList) {
            String highlight = (s.id == currentStudentId) ? " <-- You" : "";
            System.out.println("Rank " + rank + ": " + s.name + " (Total: " + s.getTotalMarks() + ")" + highlight);
            rank++;
        }
        System.out.println("-------------------------");
    }

    void login(int studentId, String password, Scanner sc) {
        if (students.containsKey(studentId)) {
            Student s = students.get(studentId);
            if (s.password.equals(password)) {
                System.out.println("\nWelcome, " + s.name + "!");
                int choice;
                do {
                    System.out.println("\nMenu:");
                    System.out.println("1. Show Marks and Grades");
                    System.out.println("2. Check Pass/Fail");
                    System.out.println("3. Subjects Yet to Pass");
                    System.out.println("4. Generate Performance Report");
                    System.out.println("5. Apply for Recheck");
                    System.out.println("6. View Rank");
                    System.out.println("0. Logout");
                    System.out.print("Enter your choice: ");
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1 -> s.showMarksAndGrades();
                        case 2 -> System.out.println("Status: " + (s.isPassed() ? "Passed" : "Failed"));
                        case 3 -> System.out.println("Subjects Yet to Pass: " + s.subjectsYetToPass());
                        case 4 -> s.generateReport();
                        case 5 -> s.applyForRecheck();
                        case 6 -> displayRankingsWithHighlight(s.id);
                        case 0 -> System.out.println("Logged out.");
                        default -> System.out.println("Invalid choice! Try again.");
                    }
                } while (choice != 0);
            } else {
                System.out.println("Incorrect password.");
            }
        } else {
            System.out.println("Student ID not found!");
        }
    }
}
