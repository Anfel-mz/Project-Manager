package model;

import java.time.LocalDate;

public class Project {
	
	private int idProject;
	private String course;
	private String subject;
	private LocalDate deadline;
	
	public Project (int idP, String course, String subj, LocalDate d) {
		this.idProject = idP;
		this.course = course;
		this.subject = subj;
		this.deadline = d;
	}
	
	public Project (String course, String subj, LocalDate d) {
		this.course = course;
		this.subject = subj;
		this.deadline = d;
	}
	
	public Project (int idP, String course, String subj, String d) {
		this.idProject = idP;
		this.course = course;
		this.subject = subj;
		this.deadline = LocalDate.parse(d);
	}

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	 public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	 
	 @Override
	    public String toString() {
	        return "Project : \n \n" +
	                "Project ID : " + idProject +
	                "\n"
	                + "Course : " + course + '\'' +
	                "\n"
	                + "Subject : '" + subject + '\'' +
	                "\n"
	                + "Deadline : " + deadline.toString() ;
	    }
	

}
