package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Program;
import util.Promo;

public class ProgramDAO extends AbstractDAO implements CRUDDAO<Program> {

	public ProgramDAO() {
		super();
	}
	@Override
	public void create(Program program) {
	String query = "INSERT INTO Program (name, promotion) VALUES (?, ?)";
	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	preparedStatement.setString(1, program.getName());
	preparedStatement.setObject(2, program.getPromo().toString());
	
	preparedStatement.executeUpdate();
	}catch (SQLException e) {
	e.printStackTrace();
	}
	}

	@Override
	public void update(Program program) {
	String query = "UPDATE Program SET name=?, promotion=?";
	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	
	preparedStatement.setString(1, program.getName());
	preparedStatement.setObject(3, program.getPromo().toString());
	preparedStatement.setInt(7, program.getIdProgram());
	preparedStatement.executeUpdate();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	@Override
	public void delete(Program program) {
	String query = "DELETE FROM Program WHERE ID_program=?";
	try { PreparedStatement preparedStatement = connection.prepareStatement(query);
	preparedStatement.setInt(1,program.getIdProgram() );
	preparedStatement.executeUpdate();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	
	}
	@Override
	public ArrayList<Program> getAll() {
	ArrayList<Program> allProgram = new ArrayList<Program>();
	String query = "SELECT * FROM Program";
	try { PreparedStatement preparedStatement = connection.prepareStatement(query);
	ResultSet resultSet = preparedStatement.executeQuery();
	while (resultSet.next()) {
	int id = resultSet.getInt("ID_program");
	String name = resultSet.getString("name");
	Promo promo = Promo.valueOf(resultSet.getString("promotion"));
	allProgram.add(new Program(id, name, promo));
	
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return allProgram;
	}
	
	
}
