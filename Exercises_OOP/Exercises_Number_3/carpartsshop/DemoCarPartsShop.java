package carpartsshop;

public class DemoCarPartsShop {

	public static void main(String[] args){
		
		Car bmw = new Car("BMW 316i", 1991, 2);
		Car audi = new Car("Audi A7", 2015, 3);
		Car mercedes = new Car("Mercedes Benz S63 AMG", 2015, 1);
		
		Car[] deucheAutos = {bmw, audi, mercedes};
		
		Country france = new Country("France");
		
		Company mishelin = new Company("Mishelin CO", 2000000, france, "Paris str.1 number 1", "0888777666", "02/777666");
		
		CarParts gumi = new CarParts("000001", "Mishelin", "Tires", deucheAutos, mishelin);
		
		CarParts gumi2 = new CarParts("000001", "Mishelin", "Tires", deucheAutos, mishelin);
		
		mishelin.setCarparts(gumi);
		
		mishelin.makeParts(100, 100);
				
		CarPartsShop magazinZaGumi = new CarPartsShop("Diana", 300000);
		
		magazinZaGumi.addCarParts(gumi2);
		
		magazinZaGumi.printCarparts();
		
		magazinZaGumi.buyParts(mishelin, 50);
		
		magazinZaGumi.printCarparts();
		
	}

}
