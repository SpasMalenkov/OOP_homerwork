package homework_computer;

import java.util.Scanner;

public class Computer {

	
	Scanner sc = new Scanner(System.in);
	
	int year;
	double price;
	boolean isNotebook;
	double hardDiskMemory;
	double freeMemory;
	String operationSystem;
	
	void changeOperationSystem(String newOperationSystem){
		
		this.operationSystem = newOperationSystem;
		
	}
	
	void useMemory(int memory){
		
		if(memory > this.freeMemory){
			
			System.out.println("Not enough free memory!");
			
		}else{
			
			freeMemory = this.freeMemory - memory;
			
		}
		
	}
	
	Computer(){
		
		this.isNotebook = false;
		this.operationSystem = "Win 7";
		
	}
	
	Computer(int year, double price, double hardDiskMemory, double freeMemory){
		
		this();
		if(year < 1990){
			
			System.out.println("This is very old PC. Buy new.");
			year = sc.nextInt();
			
		}else{
			
			this.year = year;
			
		}
		
		if(price < 0){
			
			System.out.println("There is no such price.");
			price = sc.nextDouble();
			
		}else{
			
			this.price = price;
			
		}
		
		this.hardDiskMemory = hardDiskMemory;
		this.freeMemory = freeMemory;
		
	}
	
	Computer(int year, double price, boolean isNotebook, double hardDiskMemory, double freeMemory, String operationSystem){
		
		this(year, price, hardDiskMemory, freeMemory);
		
		this.isNotebook = isNotebook;
		
		if((operationSystem != null) && (operationSystem != "")){
			
			this.operationSystem = operationSystem;
			
		}else{
			
			this.operationSystem = "It doesn't have operation system!";
			
		}
		
	}
	
	String comparePrice(Computer c){
		
		if(this.price > c.price){
			
			return this.price + " is more expensive than " + c.price + ".";
			
		}
		else if(this.price < c.price){
			
			return this.price + " is cheaper than " + c.price + ".";
			
		}
		else{
			
			return c.price + " is equal to " + this.price + ".";
			
		}
	}
}
