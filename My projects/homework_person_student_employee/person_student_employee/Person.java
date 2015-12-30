package person_student_employee;

public class Person {
	
	private String name;
	private int age;
	private boolean isMale;
	
	void setName(String name){
		if(!name.equalsIgnoreCase("") && !name.equalsIgnoreCase(null)){
			this.name = name;	
		}
	}
	
	public String getName(){
		return name;
	}
	
	void setAge(int age){
		if(age >= 0){
			this.age = age;
		}
	}
	
	public int getAge(){
		return age;
	}
	
	public Person(String name, int age, boolean isMale){
		
		setName(name);
		setAge(age);
		setIsMale(isMale);
		
	}
	
	void showPersonInfo(){
		System.out.println(this.name + " is " + this.age 
				+ " years old and is  male: " + this.isMale + ".");
	}

	public boolean getIsMale(){
		return isMale;
	}

	void setIsMale(boolean isMale) {
		this.isMale = isMale;
	}
	
	
}
