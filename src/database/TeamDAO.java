package database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import model.*;
import util.*;

/**
 * Team (#ID_student1, #ID_student2, #ID_project, dateOfSubmit)
 * use private methods to verify the constraints you have on your objects (like if the project already exisits in the database
 * @author manfe
 *
 */

public class TeamDAO implements CRUDDAO<Team,Integer>{

	private Connection connection;
	
	public 	TeamDAO() {
		connection = DatabaseConnection.getConnection();
	}
	
	@Override
	public void create(Team team) {
		String query = "INSERT INTO team (Id_student1, ID_student2, ID_project, dateOfSubmit) VALUES (?, ?, ?, ?)";
    	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
   
    		preparedStatement.setInt(1, team.getStudent1().getId());
            preparedStatement.setInt(2, team.getStudent2().getId());
            preparedStatement.setInt(3, team.getIdProject());
            preparedStatement.setDate(4,Date.valueOf(team.getDateOfSubmit()));
           
          
    	
            preparedStatement.executeUpdate();
    	
    }catch (SQLException e) {
        e.printStackTrace();
    }
		
	}

	@Override
	public Team read(Integer a) {
		
		return null;
	}
	
	public Team read(int idstudent1, int idstudent2, int idProject) {
		
		Team team = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM team WHERE ID_student1 = ? AND ID_student2 = ? AND ID_Project = ?";
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
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

	@Override
	public void update(Team team) {
		String query = "UPDATE student SET dateOfSubmit=? WHERE ID_student1=? AND ID_student2=? AND ID_project=?";

    	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	
            preparedStatement.setDate(1, Date.valueOf(team.getDateOfSubmit()));
            preparedStatement.setInt(2, team.getStudent1().getId());
            preparedStatement.setInt(3, team.getStudent2().getId());
            preparedStatement.setInt(4, team.getIdProject());

            preparedStatement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
		
	}

	@Override
	public void delete(Team team) {
		String query = "DELETE FROM team WHERE ID_student1=? AND ID_student2=? AND ID_project=?";
        try { PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setInt(1,team.getStudent1().getId());
            preparedStatement.setInt(2,team.getStudent2().getId());
            preparedStatement.setInt(3,team.getIdProject());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public ArrayList<Team> getAll() {
		ArrayList<Team> allTeams = new ArrayList<>();
		String query = "SELECT * FROM team";
		
		try { PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
        
		while (resultSet.next()) {
            int idstudent1 = resultSet.getInt("ID_student1");
            int idstudent2 = resultSet.getInt("ID_student2");
            int idproject = resultSet.getInt("ID_project");
            LocalDate dateOfSubmit = resultSet.getDate("dateOfSubmit").toLocalDate();
            

            allTeams.add(new Team(getStudent(idstudent1), getStudent(idstudent2), idproject, dateOfSubmit));
            //allStudents.add(read(idstudent1, idstudent2, idproject);
        }
   
		} catch (SQLException e) {
        e.printStackTrace();
    
		}
		
		return allTeams;
		
	}
	
	
	
	private Student getStudent(Integer id) {
		
		Student student = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM student WHERE ID_student = ?";
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
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
	

}
