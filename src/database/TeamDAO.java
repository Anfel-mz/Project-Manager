package database;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import model.*;
/**
 * Team (#ID_student1, #ID_student2, #ID_project, dateOfSubmit)
 * use private methods to verify the constraints you have on your objects (like if the project already exisits in the database
 * @author manfe
 *
 */

public class TeamDAO extends AbstractDAO implements CRUDDAO<Team>{
	private GradeDAO gradeDAO = new GradeDAO();
	
	public 	TeamDAO() {
		super();
	}
	
	@Override
	public void create(Team team) {
		String query = "INSERT INTO Team (Id_student1, ID_student2, ID_project, dateOfSubmit) VALUES (?, ?, ?, ?)";
    	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
   
    		preparedStatement.setInt(1, team.getStudent1().getId());
            preparedStatement.setInt(2, team.getStudent2().getId());
            preparedStatement.setInt(3, team.getIdProject());
            preparedStatement.setDate(4,Date.valueOf(team.getDateOfSubmit()));
           
          
    	
            preparedStatement.executeUpdate();
            gradeDAO.create(new Grade(team.getStudent1(), team.getStudent2(), team.getIdProject()));
    	
    }catch (SQLException e) {
        e.printStackTrace();
    }
		
	}

	@Override
	public void update(Team team) {
		String query = "UPDATE Team SET dateOfSubmit=? WHERE ID_student1=? AND ID_student2=? AND ID_project=?";

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
		String query = "DELETE FROM Team WHERE ID_student1=? AND ID_student2=? AND ID_project=?";
        try { PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setInt(1,team.getStudent1().getId());
            preparedStatement.setInt(2,team.getStudent2().getId());
            preparedStatement.setInt(3,team.getIdProject());

            preparedStatement.executeUpdate();
            gradeDAO.delete(new Grade(team.getStudent1(), team.getStudent2(),team.getIdProject()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public ArrayList<Team> getAll() {
		ArrayList<Team> allTeams = new ArrayList<>();
		String query = "SELECT * FROM Team";
		
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

}
