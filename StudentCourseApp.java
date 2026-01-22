
package M5;

import java.sql.*;
import java.util.Scanner;

public class StudentCourseApp {

    // <<< Adjust these to your environment >>>
    private static final String URL      = "jdbc:postgresql://localhost:5432/training_db";
    private static final String USER     = "hzjuy";
    private static final String PASSWORD = "";
    // <<< ---------------------------------- >>>

    private static Connection getConnection() throws SQLException {
        // DriverManager will load the PostgreSQL driver if the JAR is on the classpath
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void addStudent(Scanner in) {
        System.out.print("Enter name: ");
        String name = in.nextLine().trim();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(in.nextLine().trim());

        System.out.print("Enter email: ");
        String email = in.nextLine().trim();

        String sql = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, email);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Failed to add student: " + e.getMessage());
        }
    }

    private static void addCourse(Scanner in) {
        // Show students first to help the user pick an ID
        showStudents();

        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(in.nextLine().trim());

        System.out.print("Enter course name: ");
        String courseName = in.nextLine().trim();

        System.out.print("Enter grade: ");
        String grade = in.nextLine().trim();

        String sql = "INSERT INTO courses (student_id, course_name, grade) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setString(2, courseName);
            ps.setString(3, grade);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Course added successfully!");
            }
        } catch (SQLException e) {
            // If the student_id doesn't exist, you’ll get a FK error here.
            System.out.println("Failed to add course: " + e.getMessage());
        }
    }

    private static void showStudents() {
        String sql = "SELECT id, name, age, email FROM students ORDER BY id";

        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\nID | Name                | Age | Email");
            System.out.println("-----------------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");

                System.out.printf("%-3d| %-20s| %-4d| %s%n", id, name, age, email);
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Failed to list students: " + e.getMessage());
        }
    }

    private static void showCourses() {
        String sql = """
            SELECT c.id, c.course_name, c.grade, s.name AS student_name
            FROM courses c
            JOIN students s ON s.id = c.student_id
            ORDER BY c.id
            """;

        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\nID | Course Name         | Grade | Student Name");
            System.out.println("------------------------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String courseName = rs.getString("course_name");
                String grade = rs.getString("grade");
                String studentName = rs.getString("student_name");

                System.out.printf("%-3d| %-20s| %-6s| %s%n", id, courseName, grade, studentName);
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Failed to list courses: " + e.getMessage());
        }
    }

    private static void menu() {
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                System.out.println("===== STUDENT COURSE MANAGEMENT =====");
                System.out.println("1. Add Student");
                System.out.println("2. Add Course");
                System.out.println("3. Show Students");
                System.out.println("4. Show Courses");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");

                String choice = in.nextLine().trim();
                switch (choice) {
                    case "1" -> addStudent(in);
                    case "2" -> addCourse(in);
                    case "3" -> showStudents();
                    case "4" -> showCourses();
                    case "0" -> {
                        System.out.println("Exiting application. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
