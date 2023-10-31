package Util;

import java.time.LocalDate;

public abstract class Person {
	
	private static int idcount = 0;
	private int id = ++idcount;
	

	private String fullName;
	private LocalDate dateOfBirth;
	private String address;
	private Sex sex;
	private String email;
	
	
	protected Person() {
		
	}
	
	protected Person(String name, Sex s, String d, String addr, String email) {
		this.fullName = name;
		this.address = addr;
		this.dateOfBirth = LocalDate.parse(d);
		this.email = email;
		this.sex = s;
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

	public int getId() {
		return id;
	}
}
