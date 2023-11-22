package model;


public class Grade {
	
	private Student student1;
	private Student student2;
	private int idProject;
	private int gradeEssay;
	private int gradePresentation;
	private int finalGrade;
	
	public Grade (Student s1, Student s2, int idP, int ge, int gp, int fg) {
		this.student1 = s1;
		this.student2 = s2;
		this.idProject = idP;
		this.gradeEssay = ge;
		this.finalGrade = fg;
		this.gradePresentation = gp;
	}
	
	public Grade (Student s1, Student s2, int idP) {
		this.student1 = s1;
		this.student2 = s2;
		this.idProject = idP;
		
	}
	
	public Grade (Student s1, Student s2, int idP, int ge, int gp) {
		this.student1 = s1;
		this.student2 = s2;
		this.idProject = idP;
		this.gradeEssay = ge;
		this.gradePresentation = gp;
		
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

	public int getGradeEssay() {
		return gradeEssay;
	}

	public void setGradeEssay(int gradeEssay) {
		this.gradeEssay = gradeEssay;
	}

	public int getGradePresentation() {
		return gradePresentation;
	}

	public void setGradePresentation(int gradePresentation) {
		this.gradePresentation = gradePresentation;
	}

	public int getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(int finalGrade) {
		this.finalGrade = finalGrade;
	}
	

}
