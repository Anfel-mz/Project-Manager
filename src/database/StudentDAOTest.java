<<<<<<< HEAD
package database;

import model.Student;
import util.Sex;
import java.time.LocalDate;
import java.util.ArrayList;

public class StudentDAOTest {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // Create a new student
        /*Student newStudent = new Student("John Doe", LocalDate.of(1990, 1, 1), Sex.MALE, "123 Main St", "john@example.com", 1);
        studentDAO.create(newStudent);
        System.out.println("Student created: " + newStudent);*/

        // Read the student
        Student readStudent = studentDAO.read(1);
        System.out.println("Read student: " + readStudent);

        // Update the student
        /*readStudent.setFullName("Jean Dupont");
        studentDAO.update(readStudent);
        System.out.println("Student updated: " + readStudent);*/

        // Get all students
        ArrayList<Student> allStudents = studentDAO.getAll();
        System.out.println("All students:");
        for (Student student : allStudents) {
            System.out.println(student);
        }

        // Delete the student
        studentDAO.delete(studentDAO.read(7));
        studentDAO.delete(studentDAO.read(8));
        studentDAO.delete(studentDAO.read(9));

        System.out.println("Student deleted");

        // Get all students after deletion
        allStudents = studentDAO.getAll();
        System.out.println("All students after deletion:");
        for (Student student : allStudents) {
            System.out.println(student);
        }
    }
}

=======
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
        Student readStudent = studentDAO.getStudent(newStudent.getId());
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

>>>>>>> 3095955c871f5f2d33d6d5d0612170eff38c7932
