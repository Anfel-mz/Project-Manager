package util;

import java.time.LocalDate;

public abstract class Person {

	
	private int id;
	private String fullName;
	private LocalDate dateOfBirth;
	private String address;
	private Sex sex;
	private String email;
	
	protected Person() {
		
	}
	
	protected Person(int id, String name, LocalDate d, Sex s, String addr, String email) {
		this.fullName = name;
		this.address = addr;
		this.dateOfBirth = d; 
		this.email = email;
		this.sex = s;
		this.id = id;
	}
	
	protected Person(int id, String name, String d, String s, String addr, String email) {
		this.fullName = name;
		this.address = addr;
		this.dateOfBirth = LocalDate.parse(d); 
		this.email = email;
		this.sex = Sex.valueOf(s);
		this.id = id;
	}
	
	protected Person( String name, LocalDate d, Sex s, String addr, String email) {
		this.fullName = name;
		this.address = addr;
		this.dateOfBirth = d; 
		this.email = email;
		this.sex = s;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
