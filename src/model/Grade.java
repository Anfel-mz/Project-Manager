package model;


public class Grade {
	
	private Student student1;
	private Student student2;
	private int idProject;
	private float gradeEssay;
	private float gradePresentation1;
	private float gradePresentation2;

	private float finalGrade1;
	private float finalGrade2;
	
	public Grade (Student s1, Student s2, int idP, float ge, float gp1, float gp2, float fg1, float fg2) {
		this.student1 = s1;
		this.student2 = s2;
		this.idProject = idP;
		this.gradeEssay = ge;
		this.finalGrade1 = fg1;
		this.gradePresentation1 = gp1;
		this.gradePresentation2 = gp2;
		this.finalGrade2 = fg2;
	}
	
	public Grade (Student s1, Student s2, int idP) {
		this.student1 = s1;
		this.student2 = s2;
		this.idProject = idP;
		
	}
	
	public Grade (Student s1, Student s2, int idP, float ge, float gp1, float gp2) {
		this.student1 = s1;
		this.student2 = s2;
		this.idProject = idP;
		this.gradeEssay = ge;
		this.gradePresentation1 = gp1;
		this.gradePresentation2 = gp2;
		
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

	public float getGradeEssay() {
		return gradeEssay;
	}

	public void setGradeEssay(float gradeEssay) {
		this.gradeEssay = gradeEssay;
	}


	
		public float getGradePresentation1() {
		return gradePresentation1;
	}
	
	public void setGradePresentation1(float gradePresentation1) {
		this.gradePresentation1 = gradePresentation1;
	}
	
	public float getGradePresentation2() {
		return gradePresentation2;
	}
	
	public void setGradePresentation2(float gradePresentation2) {
		this.gradePresentation2 = gradePresentation2;
	}
	
	public float getFinalGrade1() {
		return finalGrade1;
	}
	
	public void setFinalGrade1(float finalGrade1) {
		this.finalGrade1 = finalGrade1;
	}
	
	public float getFinalGrade2() {
		return finalGrade2;
	}
	
	public void setFinalGrade2(float finalGrade2) {
		this.finalGrade2 = finalGrade2;
	}

	@Override
    public String toString() {
        return "Grade : \n \n" +
                "Essay Grade : " + gradeEssay +
                "\n"
                + "Grade Presentation : \n \n  Student 1 : " + gradePresentation1 +
                "\n"
                + "  Student 2 : " + gradePresentation2 +
                "\n"
                + "Final Grade : \n \n  Student 1 : " + finalGrade1 +
                 "\n"
                + "  Student 2 : " + finalGrade2;
    }
	

}
