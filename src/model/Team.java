package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Team {
	
	private Student student1;
	private Student student2;
	private int idProject;
	private LocalDate dateOfSubmit;
	
	public Team (Student s1, Student s2, int idP) {
		this.student1 = s1;
		this.student2 = s2;
		this.idProject = idP;
		this.dateOfSubmit = LocalDate.parse("1111-11-11");
		
	}
	
	public Team (Student s1, Student s2, int idP, LocalDate d) {
		this.student1 = s1;
		this.student2 = s2;
		this.idProject = idP;
		this.dateOfSubmit = d;
	}
	
	public Team (Student s1, Student s2, int idP, String d) {
		this.student1 = s1;
		this.student2 = s2;
		this.idProject = idP;
		this.dateOfSubmit = LocalDate.parse(d);
	}

	public Student getStudent1() {
		return student1;
	}

	public void setStudent1(Student student1) {
		this.student1 = student1;
	}

	public Student getStudent2() {
		return student2;
	}

	public void setStudent2(Student student2) {
		this.student2 = student2;
	}

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public LocalDate getDateOfSubmit() {
		return dateOfSubmit;
	}

	public void setDateOfSubmit(LocalDate dateOfSubmit) {
		this.dateOfSubmit = dateOfSubmit;
		}
	
	@Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return "Team : \n \n" +
                "Student 1 : " + student1.getFullName() +
                "\n"
                + "Student 2 : " + student2.getFullName() +
                "\n"
                + "Project ID : " + idProject +
                "\n"
                + "Date Of Submission : " + dateOfSubmit.format(formatter)	;
    }
	
	
	
}
