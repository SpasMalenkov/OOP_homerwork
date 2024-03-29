package school;

public class Teacher extends Human{
	
	private double salary;
	private String subject;
	private boolean isNewTeacher;
	
	public Teacher(String name, String surname, double salary, String subject) {
		super(name, surname);
		setSalary(salary);
		this.subject = subject;
	}

	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		if(salary > 500){
			this.salary = salary;
			this.isNewTeacher = false;
		}else{
			this.salary = salary;
			this.isNewTeacher = true;
		}
	}
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public int Teach(int teaching){
		System.out.println("The teacher " + this.getName() + " " + this.getSurname() + " is teaching " + this.subject + ".");
		if(teaching < 25 || teaching > 100){
			teaching = 25;
		}
		return teaching;
	}
	
	
	public void Test(){
		System.out.println("The teacher " + this.getName() + " held an exam in class.");
	}
	
	
}
