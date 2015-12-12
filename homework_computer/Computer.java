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
			
			do{
				
				System.out.println("You can't use so old PC.");
				this.year = sc.nextInt();
				
			}while(this.year < 1990);
			
		}else{
			
			this.year = year;
			
		}
		
		if(price < 0){
			
			do{
				
				System.out.println("There is no such price.");
				this.price = sc.nextDouble();
			
			}while(this.price <= 0);
			
		}else{
			
			this.price = price;
			
		}
		
		this.hardDiskMemory = hardDiskMemory;
		this.freeMemory = freeMemory;
		
	}
	
	Computer(int year, double price, boolean isNotebook, double hardDiskMemory, double freeMemory, String operationSystem){
		
		this(year, price, hardDiskMemory, freeMemory);
		
		if(isNotebook == true){
			
			this.isNotebook = isNotebook;
			
		}
		
		if((operationSystem != null) && (operationSystem != "")){
			
			this.operationSystem = operationSystem;
			
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
