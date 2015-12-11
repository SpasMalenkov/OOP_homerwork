package homework_computer;

public class Computer {

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
}
