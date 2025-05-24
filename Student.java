 import java.util.*;

public class Student {
    int id;
    String name;
    String password;
    List<Subject> subjects = new ArrayList<>();
    boolean appliedForRecheck = false;

    public Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    void addSubject(String subjectName, int marks) {
        subjects.add(new Subject(subjectName, marks));
    }

    void editSubjectMarks(String subjectName, int marks) {
        for (Subject sub : subjects) {
            if (sub.name.equalsIgnoreCase(subjectName)) {
                sub.marks = marks;
                System.out.println("Marks updated.");
                return;
            }
        }
        System.out.println("Subject not found.");
    }

    void deleteSubject(String subjectName) {
        boolean removed = subjects.removeIf(sub -> sub.name.equalsIgnoreCase(subjectName));
        System.out.println(removed ? "Subject removed." : "Subject not found.");
    }

    void showMarksAndGrades() {
        System.out.println("\n--- Marks and Grades ---");
        for (Subject sub : subjects) {
            System.out.println(sub.name + ": " + sub.marks + " (" + sub.getGrade() + ")");
        }
    }

    boolean isPassed() {
        return subjects.stream().allMatch(s -> s.marks >= 40);
    }

    int subjectsYetToPass() {
        return (int) subjects.stream().filter(s -> s.marks < 40).count();
    }

    void generateReport() {
        System.out.println("\nStudent ID: " + id);
        System.out.println("Name: " + name);
        showMarksAndGrades();
        System.out.println("Total Marks: " + getTotalMarks());
        System.out.println("Status: " + (isPassed() ? "Passed" : "Failed"));
        if (appliedForRecheck) {
            System.out.println("Applied for Recheck: YES");
        }
        System.out.println("-------------------------");
    }

    void applyForRecheck() {
        if (!appliedForRecheck) {
            appliedForRecheck = true;
            System.out.println("Recheck applied successfully.");
        } else {
            System.out.println("Recheck already applied.");
        }
    }

    int getTotalMarks() {
        return subjects.stream().mapToInt(s -> s.marks).sum();
    }
}
