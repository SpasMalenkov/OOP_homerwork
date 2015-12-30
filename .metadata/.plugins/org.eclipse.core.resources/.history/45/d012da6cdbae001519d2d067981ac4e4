package homework_computer;

import java.util.Scanner;

import homework_computer.Computer;

public class Computer_statistics {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//suzdavane na obekti computri
		Computer computerOfSpas =  new Computer(2015, 1030, false, 1000, 1000, null);
		Computer laptopOfAlex = new Computer(2014, 1299.90, true, 2000, 2000, "Windows 8");
		Computer computerOfTodor = new Computer(2013, 1565, false, 2000, 2000, "Windows 7");
		Computer laptopOfVladi = new Computer(2012, 849.90, true, 500, 500, "Windows 7");
		
		//zadavane na operacionna sistema i izpolzvana pamet
		String operationSystem = sc.nextLine();
		int memory = sc.nextInt();
		
		//izpolzvane na metodite vurho opredeleni obekti
		laptopOfAlex.changeOperationSystem(operationSystem);
		computerOfSpas.useMemory(memory);
		
		//printirane na vsichki harakteristiki na computrite
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
		
		System.out.println();
		
		System.out.println(computerOfTodor.year);
		System.out.println(computerOfTodor.price);
		System.out.println(computerOfTodor.isNotebook);
		System.out.println(computerOfTodor.hardDiskMemory);
		System.out.println(computerOfTodor.freeMemory);
		System.out.println(computerOfTodor.operationSystem);
		
		System.out.println();
		
		System.out.println(laptopOfVladi.year);
		System.out.println(laptopOfVladi.price);
		System.out.println(laptopOfVladi.isNotebook);
		System.out.println(laptopOfVladi.hardDiskMemory);
		System.out.println(laptopOfVladi.freeMemory);
		System.out.println(laptopOfVladi.operationSystem);
		
		System.out.println();
		
		//sravnenie na cenite mejdu computrite
		System.out.println(computerOfSpas.comparePrice(laptopOfAlex));
		System.out.println(computerOfTodor.comparePrice(laptopOfVladi));
		System.out.println(computerOfTodor.comparePrice(laptopOfAlex));
		System.out.println(computerOfSpas.comparePrice(laptopOfVladi));
		System.out.println(computerOfSpas.comparePrice(computerOfTodor));
		System.out.println(laptopOfVladi.comparePrice(laptopOfAlex));
	}

}
