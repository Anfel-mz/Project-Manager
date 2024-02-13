package model;
import java.time.LocalDate;

import util.*;

public class Student extends Person {
	
	private int idProgram;
	
	public Student (int id, String name, LocalDate d, Sex s, String addr, String email, int idP) {
		super(id,name, d, s, addr, email);
		this.idProgram = idP;
	}

	
	public Student (int id, String name, String d, String s, String addr, String email, int idP) {
		super(id,name, d, s, addr, email);
		this.idProgram = idP;
	}

	public Student (String name, LocalDate d, Sex s, String addr, String email, int idP) {
		super(name, d, s, addr, email);
		this.idProgram = idP;
	}

	public int getIdProgram() {
		return idProgram;
	}


	public void setIdProgram(int idProgram) {
		this.idProgram = idProgram;
	}
	
	
	@Override
	public String toString() {
	    return "Student : \n" +
	            "\n    ID : " + getId() +
	            "\n    Full Name : '" + getFullName() + '\'' +
	            "\n    Date Of Birth : " + getDateOfBirth() +
	            "\n    Address : '" + getAddress() + '\'' +
	            "\n    Sex : " + getSex() +
	            "\n    Email : " + getEmail();
	}

}
