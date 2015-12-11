package homework_computer;

import java.util.Scanner;

public class Computer_statistics {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Computer computerOfSpas = new Computer();
		Computer laptopOfAlex = new Computer();
		
		computerOfSpas.year = 2015;
		computerOfSpas.price = 1030;
		computerOfSpas.isNotebook = false;
		computerOfSpas.hardDiskMemory = 1000;
		computerOfSpas.freeMemory = 1000;
		computerOfSpas.operationSystem = "Windows 7";
		
		laptopOfAlex.year = 2014;
		laptopOfAlex.price = 1500;
		laptopOfAlex.isNotebook = true;
		laptopOfAlex.hardDiskMemory = 1500;
		laptopOfAlex.freeMemory = 1500;
		laptopOfAlex.operationSystem = "Windows 7";
		
		
		String operationSystem = sc.nextLine();
		int memory = sc.nextInt();
		
		laptopOfAlex.changeOperationSystem(operationSystem);
		computerOfSpas.useMemory(memory);
		
		System.out.println();
		System.out.println(computerOfSpas.year);
		System.out.println(computerOfSpas.price);
		System.out.println(computerOfSpas.isNotebook);
		System.out.println(computerOfSpas.hardDiskMemory);
		System.out.println(computerOfSpas.freeMemory);
		System.out.println(computerOfSpas.operationSystem);
		
		System.out.println();
		
		System.out.println(laptopOfAlex.year);
		System.out.println(laptopOfAlex.price);
		System.out.println(laptopOfAlex.isNotebook);
		System.out.println(laptopOfAlex.hardDiskMemory);
		System.out.println(laptopOfAlex.freeMemory);
		System.out.println(laptopOfAlex.operationSystem);
		
	}

}
