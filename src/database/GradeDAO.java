package database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;

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
		String query = "INSERT INTO Grade (Id_student1, ID_student2, ID_project, gradeEssay, gradePresentation1, gradePresentation2, finalGrade1, finalGrade2) VALUES (?, ?, ?, ?,?,?,?,?)";
    	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
   
    		preparedStatement.setInt(1, grade.getStudent1().getId());
            preparedStatement.setInt(2, grade.getStudent2().getId());
            preparedStatement.setInt(3, grade.getIdProject());
            preparedStatement.setFloat(4, grade.getGradeEssay());
            preparedStatement.setFloat(5, grade.getGradePresentation1());
            preparedStatement.setFloat(6, grade.getGradePresentation2()); 
            preparedStatement.setFloat(7, grade.getFinalGrade1());
            preparedStatement.setFloat(8, grade.getFinalGrade2()); 
          
    	
            preparedStatement.executeUpdate();
    	
    }catch (SQLException e) {
        e.printStackTrace();
    }
		
	}
	
	
	@Override
	public void update(Grade grade) {
		String query = "UPDATE Grade SET gradeEssay=?, gradePresentation1=?, gradePresentation2=?, finalGrade1=?, finalGrade2=? WHERE ID_student1=? AND ID_student2=? AND ID_project=?";

    	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	
            preparedStatement.setFloat(1, grade.getGradeEssay());
            preparedStatement.setFloat(2, grade.getGradePresentation1());
            preparedStatement.setFloat(3, grade.getGradePresentation2());
            preparedStatement.setFloat(4, getFinalGrade(grade)[0]);
            preparedStatement.setFloat(5, getFinalGrade(grade)[1]);
            preparedStatement.setInt(6, grade.getStudent1().getId());
            preparedStatement.setInt(7, grade.getStudent2().getId());
            preparedStatement.setInt(8, grade.getIdProject());

            preparedStatement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void delete(Grade grade) {
		String query = "DELETE FROM Grade WHERE ID_student1=? AND ID_student2=? AND ID_project=?";
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
		String query = "SELECT * FROM Grade";
		
		try { PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
        
		while (resultSet.next()) {
            int idstudent1 = resultSet.getInt("ID_student1");
            int idstudent2 = resultSet.getInt("ID_student2");
            int idproject = resultSet.getInt("ID_project");
            float gessay = resultSet.getInt("gradeEssay");
        	float gpresentation1 = resultSet.getFloat("gradePresentation1");
        	float gpresentation2 = resultSet.getFloat("gradePresentation2");
        	float finalgrade1 = resultSet.getFloat("finalGrade1");
        	float finalgrade2 = resultSet.getFloat("finalGrade2");

            
            

            allGrades.add(new Grade (getStudent(idstudent1), getStudent(idstudent2), idproject,gessay, 
            		gpresentation1, gpresentation2, finalgrade1, finalgrade2));
            
        }
   
		} catch (SQLException e) {
        e.printStackTrace();
    
		}
		
		return allGrades;
	}
	
	public float[] getFinalGrade(Grade grade) {
		
		float finalGrade1;
		float finalGrade2;
		Team team = getTeam(grade.getStudent1().getId(), grade.getStudent2().getId(), grade.getIdProject());
		Project project = getProject(grade.getIdProject());
			
			if((grade.getGradeEssay() == 0 && grade.getGradePresentation1() == 0)|| team.getDateOfSubmit().equals(LocalDate.parse("1111-11-11"))||Objects.isNull(team.getDateOfSubmit())) {
				grade.setFinalGrade1(0);
				finalGrade1 = 0;
			} else {
				finalGrade1 = (grade.getGradeEssay() + grade.getGradePresentation1())/2;
			}
		
		
			if((grade.getGradeEssay() == 0 && grade.getGradePresentation2() == 0)|| team.getDateOfSubmit().equals(LocalDate.parse("1111-11-11")) || Objects.isNull(team.getDateOfSubmit() )) {
				grade.setFinalGrade2(0);
				finalGrade2 = 0;
			} else {
				finalGrade2 = (grade.getGradeEssay() + grade.getGradePresentation2())/2;
			}
		
		
		if(team.getDateOfSubmit().isAfter(project.getDeadline())) {
			
			long daysLate = ChronoUnit.DAYS.between(project.getDeadline(), team.getDateOfSubmit());
		    
		    finalGrade1 -= daysLate;
		    finalGrade2 -= daysLate;

		    finalGrade1 = Math.max(0, finalGrade1);
		    finalGrade2 = Math.max(0, finalGrade2);

		    grade.setFinalGrade1(finalGrade1);
		    grade.setFinalGrade2(finalGrade2);

		}
		
		return new float[]{finalGrade1, finalGrade2};
	}
	
	

}
