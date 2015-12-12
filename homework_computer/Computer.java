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
	
	//metod za smqna na operacianata sistema
	void changeOperationSystem(String newOperationSystem){
		
		this.operationSystem = newOperationSystem;
		
	}
	
	//metod za proverka kolko pamet se polzva
	void useMemory(int memory){
		
		if(memory > this.freeMemory){
			
			System.out.println("Not enough free memory!");
			
		}else{
			
			freeMemory = this.freeMemory - memory;
			
		}
		
	}
	
	//default constructor za Computer
	Computer(){
		
		this.isNotebook = false;
		this.operationSystem = "Win 7";
		
	}
	
	//constructor s parametri
	Computer(int year, double price, double hardDiskMemory, double freeMemory){
		
		this();
		
		//proverka za godinata na proizvodstvo?
		if(year < 1990){
			
			do{
				
				System.out.println("You can't use so old PC.");
				this.year = sc.nextInt();
				
			}while(this.year < 1990);
			
		}else{
			
			this.year = year;
			
		}
		
		//proverka za cenata
		if(price < 0){
			
			do{
				
				System.out.println("There is no such price.");
				this.price = sc.nextDouble();
			
			}while(this.price <= 0);
			
		}else{
			
			this.price = price;
			
		}
		
		//zadavane na pametta i svobodnata pamet
		this.hardDiskMemory = hardDiskMemory;
		this.freeMemory = freeMemory;
		
	}
	
	//constructor s inicializacia na vsichki parametri
	Computer(int year, double price, boolean isNotebook, double hardDiskMemory, double freeMemory, String operationSystem){
		
		this(year, price, hardDiskMemory, freeMemory);
		
		//proverka dali e laptop ili pc
		if(isNotebook == true){
			
			this.isNotebook = isNotebook;
			
		}
		
		//proverka dali ima operacionna sistema
		if((operationSystem != null) && (operationSystem != "")){
			
			this.operationSystem = operationSystem;
			
		}
		
	}
	
	//sravnenie na cenite
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
