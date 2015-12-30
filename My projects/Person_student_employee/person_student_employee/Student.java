package person_student_employee;

public class Student extends Person{
	
	private double score;
	
	void setScore(double score){
		if(score >= 2){
			this.score = score;
		}
	}
	
	public double getScore(){
		return score;
	}
	
	public Student(String name, int age, boolean isMale, double score) {
		super(name, age, isMale);
		setScore(score);
	}
	
	void showStudentInfo(){
		System.out.println(this.getName() + " is " + this.getAge() 
				+ " years old and is  male: " + this.getIsMale() 
				+ " and has score of: " + this.getScore() + ".");
	}
	
}
