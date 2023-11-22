package database;

import model.Student;
import util.Sex;
import java.time.LocalDate;
import java.util.ArrayList;

public class StudentDAOTest {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // Create a new student
        Student newStudent = new Student("John Doe", LocalDate.of(1990, 1, 1), Sex.MALE, "123 Main St", "john@example.com", 1);
        studentDAO.create(newStudent);
        System.out.println("Student created: " + newStudent);

        // Read the student
        Student readStudent = studentDAO.read(newStudent.getId());
        System.out.println("Read student: " + readStudent);

        // Update the student
        readStudent.setFullName("Jhon updated");
        studentDAO.update(readStudent);
        System.out.println("Student updated: " + readStudent);

        // Get all students
        ArrayList<Student> allStudents = studentDAO.getAll();
        System.out.println("All students:");
        for (Student student : allStudents) {
            System.out.println(student);
        }

        // Delete the student
        studentDAO.delete(readStudent);

        System.out.println("Student deleted");

        // Get all students after deletion
        allStudents = studentDAO.getAll();
        System.out.println("All students after deletion:");
        for (Student student : allStudents) {
            System.out.println(student);
        }
    }
}

