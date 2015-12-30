package homework_student;

import java.util.Scanner;

public class Student {
	
	
	Scanner sc = new Scanner(System.in);
	
	String name;
	String subject;
	double grade;
	int yearInCollege;
	int age;
	boolean isDegree;
	double money;
	
	//default constructor
	Student(){
		
		this.grade = 4.0;
		this.yearInCollege = 1;
		this.isDegree = false;
		this.money = 0;
		
	}
	
	//constructor s parametri
	Student(String name, String subject, int age){
		
		this();
		
		//proverka za imeto
		if(name == null && name == ""){
			
			do{
				
				System.out.println("Please enter a name :");
				this.name = sc.nextLine();
				
			}while(name == null && name == "");
			
		}else{
			
			this.name = name;
			
		}
		
		//proverka za specialnosta
		if(subject == null && subject == ""){
			
			do{
				
				System.out.println("Please enter a subject: ");
				this.subject = sc.nextLine();
				
			}while(subject == null && subject == "");
			
		}else{
			
			this.subject = subject;
			
		}
		
		//proverka na godinite
		if(age > 18){
			
			this.age = age;
			
		}else{
			
			this.age = 19;
		
		}
	}
	
	//uvelichavane na godinata v universiteta
	void upYear(){
		
		if(this.yearInCollege == 4){
			
			System.out.println("A student is graduatig college.");
			this.isDegree = true;
			
		}else{
			
			this.yearInCollege+=1;
			if(this.yearInCollege == 4){
				
				System.out.println("A student is graduatig college.");
				this.isDegree = true;
				
			}
			
		}
		
	}
	
	//proverka dali studenta shte poluchava stipendia
	double receiveScholarship(double min, double amount){
		
		if(this.grade >= min && this.age < 30){
			
			this.money += amount;
		
		}
		
		return this.money;
		
	}
	
	
}
