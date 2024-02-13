package database;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import model.*;
import util.*;

public class StudentDAO extends AbstractDAO implements CRUDDAO<Student>{
    
	
	public StudentDAO() {
		super();
	}


	@Override
	public void create(Student student) { //addStudent
	    	
			String query = "INSERT INTO Student (fullName, dateOfBirth, sex, address, email, ID_program) VALUES (?, ?, ?, ?, ?, ?)";
	    	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	   
	    		preparedStatement.setString(1, student.getFullName());
	            preparedStatement.setDate(2, Date.valueOf(student.getDateOfBirth()));
	            preparedStatement.setObject(3, student.getSex().toString());
	            preparedStatement.setString(4, student.getAddress());
	            preparedStatement.setString(5, student.getEmail());
	            preparedStatement.setInt(6, student.getIdProgram());
	          
	    	
	            preparedStatement.executeUpdate();
	    	
	    }catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	

	@Override
	public void update(Student student) {
	   
        String query = "UPDATE Student SET fullName=?, dateOfBirth=?, sex=?, address=?, email=?, ID_program=? WHERE ID_student=?";

    	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	
    		preparedStatement.setString(1, student.getFullName());
            preparedStatement.setDate(2, Date.valueOf(student.getDateOfBirth()));
            preparedStatement.setObject(3, student.getSex().toString());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getIdProgram());
            preparedStatement.setInt(7, student.getId());

            preparedStatement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	}


	@Override
	public void delete(Student student) {
        String query = "DELETE FROM Student WHERE ID_student=?";
        try { PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setInt(1,student.getId() );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}
	
	public ArrayList<Student> getAll(){
		
		ArrayList<Student> allStudents = new ArrayList<Student>();
		String query = "SELECT * FROM Student";
		
		try { PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
        
		while (resultSet.next()) {
            int id = resultSet.getInt("ID_student");
            String fullName = resultSet.getString("fullName");
            LocalDate dateOfBirth = resultSet.getDate("dateOfBirth").toLocalDate();
            Sex sex = Sex.valueOf(resultSet.getString("sex"));
            String address = resultSet.getString("address");
            String email = resultSet.getString("email");
            int programId = resultSet.getInt("ID_program");

            allStudents.add(new Student(id, fullName, dateOfBirth, sex, address, email, programId));
            //allStudents.add(read(id);
        }
   
		} catch (SQLException e) {
        e.printStackTrace();
    
		}
		
		return allStudents;
		
	}
}

