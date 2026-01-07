package Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static int idCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void addStudent() {
        sc.nextLine(); 
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        students.add(new Student(idCounter++, name, marks));
        System.out.println("Student added successfully");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static void searchStudent() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found");
    }

    private static void updateStudent() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter new marks: ");
                s.setMarks(sc.nextInt());
                System.out.println("Student updated");
                return;
            }
        }
        System.out.println("Student not found");
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student deleted");
                return;
            }
        }
        System.out.println("Student not found");
    }
}

