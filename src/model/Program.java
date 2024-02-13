package model;
import util.*;


public class Program {
	private int idProgram;
	private String name;
	private Promo promo;
	
	public Program(int id, String name, Promo p) {
		this.idProgram = id;
		this.name = name;
		this.promo = p;
	}
	
	public Program(String name) {
		
		this.name = name;
		
	}
	
	
	public int getIdProgram() {
		return idProgram;
	}
	
	public void setIdProgram(int id) {
		this.idProgram = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Promo getPromo() {
		return promo;
	}
	public void setPromo(Promo promo) {
		this.promo = promo;
	}
	
	@Override
	public String toString() {
	    return "Program : \n" +
	            "\n    Program ID : " + idProgram +
	            "\n    Name : " + name + '\'' +
	            "\n    Promotion : " + promo;
	}

	
}
