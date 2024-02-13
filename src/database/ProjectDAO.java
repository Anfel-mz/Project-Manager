package database;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Project;
import java.time.LocalDate;

public class ProjectDAO extends AbstractDAO implements CRUDDAO<Project>{
	public ProjectDAO() {
		super();
	}
	
	@Override
	public void create(Project project) {
	String query = "INSERT INTO Project (course, subject, deadline) VALUES (?, ?, ?)";
	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	preparedStatement.setString(1, project.getCourse());
	preparedStatement.setString(2, project.getSubject());
	preparedStatement.setDate(3, Date.valueOf(project.getDeadline()));
	
	preparedStatement.executeUpdate();
	}catch (SQLException e) {
	e.printStackTrace();
	}
	}
	
	@Override
	public void update(Project project) {
	String query = "UPDATE Project SET course=?, subject=?, deadline=? WHERE ID_project=?";
	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	
	preparedStatement.setString(1, project.getCourse());
	preparedStatement.setString(2, project.getSubject());
	preparedStatement.setDate(3, Date.valueOf(project.getDeadline()));
	preparedStatement.setInt(4, project.getIdProject());
	preparedStatement.executeUpdate();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	@Override
	public void delete(Project project) {
	String query = "DELETE FROM Project WHERE ID_project=?";
	try { PreparedStatement preparedStatement = connection.prepareStatement(query);
	preparedStatement.setInt(1,project.getIdProject() );
	preparedStatement.executeUpdate();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	}
	@Override
	public ArrayList<Project> getAll() {
	ArrayList<Project> allProjects = new ArrayList<Project>();
	String query = "SELECT * FROM Project";
	try { PreparedStatement preparedStatement = connection.prepareStatement(query);
	ResultSet resultSet = preparedStatement.executeQuery();
	while (resultSet.next()) {
	int id = resultSet.getInt("ID_project");
	String course = resultSet.getString("course");
	String subject = resultSet.getString("subject");
	LocalDate deadline = resultSet.getDate("deadline").toLocalDate();
	
	allProjects.add(new Project(id, course, subject, deadline));
	//allStudents.add(read(id);
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return allProjects;
	}

}
