package database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;

/**
 * Grade (#ID_student1, #ID_student2, #ID_project, gradeEssay, 
 * gradePresentation, finalGrade)
 * @author manfe
 *
 */

public class GradeDAO extends AbstractDAO implements CRUDDAO<Grade>{
	
	
	public GradeDAO() {
		super();
	}

	@Override
	public void create(Grade grade) {
		String query = "INSERT INTO team (Id_student1, ID_student2, ID_project, gradeEssay, gradePresentation,finalGrade) VALUES (?, ?, ?, ?,?,?)";
    	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
   
    		preparedStatement.setInt(1, grade.getStudent1().getId());
            preparedStatement.setInt(2, grade.getStudent2().getId());
            preparedStatement.setInt(3, grade.getIdProject());
            preparedStatement.setInt(4, grade.getGradeEssay());
            preparedStatement.setInt(2, grade.getGradePresentation());
            preparedStatement.setInt(3, grade.getFinalGrade());           
          
    	
            preparedStatement.executeUpdate();
    	
    }catch (SQLException e) {
        e.printStackTrace();
    }
		
	}
	
	
	@Override
	public void update(Grade grade) {
		String query = "UPDATE team SET gradeEssay=?, gradePresentation=? grade WHERE ID_student1=? AND ID_student2=? AND ID_project=?";

    	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	
            preparedStatement.setInt(1, grade.getGradeEssay());
            preparedStatement.setInt(2, grade.getGradePresentation());
            preparedStatement.setInt(2, grade.getStudent1().getId());
            preparedStatement.setInt(3, grade.getStudent2().getId());
            preparedStatement.setInt(4, grade.getIdProject());

            preparedStatement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void delete(Grade grade) {
		String query = "DELETE FROM grade WHERE ID_student1=? AND ID_student2=? AND ID_project=?";
        try { PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setInt(1,grade.getStudent1().getId());
            preparedStatement.setInt(2,grade.getStudent2().getId());
            preparedStatement.setInt(3,grade.getIdProject());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public ArrayList<Grade> getAll() {
		ArrayList<Grade> allGrades = new ArrayList<>();
		String query = "SELECT * FROM grade";
		
		try { PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
        
		while (resultSet.next()) {
            int idstudent1 = resultSet.getInt("ID_student1");
            int idstudent2 = resultSet.getInt("ID_student2");
            int idproject = resultSet.getInt("ID_project");
            int gessay = resultSet.getInt("gradeEssay");
        	int gpresentation = resultSet.getInt("gradePresentation");
        	int finalgrade = resultSet.getInt("finalGrade");

            
            

            allGrades.add(new Grade (getStudent(idstudent1), getStudent(idstudent2), idproject,gessay, gpresentation, finalgrade));
            
        }
   
		} catch (SQLException e) {
        e.printStackTrace();
    
		}
		
		return allGrades;
	}
	
	

}
