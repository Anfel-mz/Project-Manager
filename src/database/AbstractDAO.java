package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Grade;
import model.Program;
import model.Project;
import model.Student;
import model.Team;
import util.Promo;
import util.Sex;

public abstract class AbstractDAO {
	
	protected static Connection connection;

    static {
        connection = DatabaseConnection.getConnection();
    }
		
	public AbstractDAO() {
	}

	
	public Student getStudent(Integer id) {
			
			Student student = null;
	        ResultSet resultSet = null;
	        String query = "SELECT * FROM Student WHERE ID_student = ?";
	        
	        try {
	            PreparedStatement preparedStatement = AbstractDAO.connection.prepareStatement(query);
	            preparedStatement.setInt(1, id);
	            resultSet = preparedStatement.executeQuery();
	
	            if (resultSet.next()) {
	                String fullName = resultSet.getString("fullName");
	                LocalDate dateOfBirth = resultSet.getDate("dateOfBirth").toLocalDate();
	                Sex sex = Sex.valueOf(resultSet.getString("sex"));
	                String address = resultSet.getString("address");
	                String email = resultSet.getString("email");
	                int programId = resultSet.getInt("ID_program");
	
	                student = new Student(id, fullName, dateOfBirth, sex, address, email, programId);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	
	        return student;
	    }
	
	
	public Project getProject(int idProject) {
			
			Project project = null;
	        ResultSet resultSet = null;
	        String query = "SELECT * FROM Project WHERE ID_project = ?";
	        
	        try {
	            PreparedStatement preparedStatement = AbstractDAO.connection.prepareStatement(query);
	        
	            preparedStatement.setInt(1, idProject);   
	            
	            resultSet = preparedStatement.executeQuery();
	
	            if (resultSet.next()) {
	                LocalDate deadline= resultSet.getDate("deadline").toLocalDate();
	                String course = resultSet.getString("course");
	                String subject = resultSet.getString("subject");
	                
	                project = new Project(idProject, course, subject, deadline);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	
	        return project;
		}
	
	public Team getTeam(int idstudent1, int idstudent2, int idProject) {
			
			Team team = null;
	        ResultSet resultSet = null;
	        String query = "SELECT * FROM Team WHERE ID_student1 = ? AND ID_student2 = ? AND ID_Project = ?";
	        
	        try {
	            PreparedStatement preparedStatement = AbstractDAO.connection.prepareStatement(query);
	            preparedStatement.setInt(1, idstudent1); 
	            preparedStatement.setInt(2, idstudent2); 
	            preparedStatement.setInt(3, idProject);   
	            
	            resultSet = preparedStatement.executeQuery();
	
	            if (resultSet.next()) {
	                LocalDate dateOfSubmit = resultSet.getDate("dateOfSubmit").toLocalDate();
	                team = new Team (getStudent(idstudent1), getStudent(idstudent2), idProject, dateOfSubmit);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	
	        return team;
		}
	
	public Grade getGrade(int idstudent1, int idstudent2, int idProject) {
		
			Grade grade = null;
	        ResultSet resultSet = null;
	        String query = "SELECT * FROM Grade WHERE ID_student1 = ? AND ID_student2 = ? AND ID_Project = ?";
	    
	    try {
	        PreparedStatement preparedStatement = AbstractDAO.connection.prepareStatement(query);
	        preparedStatement.setInt(1, idstudent1); 
	        preparedStatement.setInt(2, idstudent2); 
	        preparedStatement.setInt(3, idProject);   
	        
	        resultSet = preparedStatement.executeQuery();
	
	        if (resultSet.next()) {
	        	int gessay = resultSet.getInt("gradeEssay");
	        	int gpresentation1 = resultSet.getInt("gradePresentation1");
	        	int gpresentation2 = resultSet.getInt("gradePresentation2");
	        	int finalgrade1 = resultSet.getInt("finalGrade1");
	        	int finalgrade2 = resultSet.getInt("finalGrade2");
	
	
	            grade = new Grade (getStudent(idstudent1), getStudent(idstudent2), idProject,gessay, gpresentation1, gpresentation2, finalgrade1, finalgrade2);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	
	    return grade;
	}
	
	public Program getProgram(Integer idProgram) {
		Program program = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM Program WHERE ID_program = ?";
		try {
		PreparedStatement preparedStatement = AbstractDAO.connection.prepareStatement(query);
		preparedStatement.setInt(1, idProgram);
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
		String name = resultSet.getString("name");
		Promo promo = Promo.valueOf(resultSet.getString("promotion"));
		
		program = new Program(idProgram, name, promo);
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return program;
		}


}
