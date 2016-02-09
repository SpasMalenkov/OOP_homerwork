package arrayList;

import java.util.ArrayList;
import java.util.Collections;

public class DemoArrayList {

	public static void main(String[] args) {
		
		
		ArrayList<Car> cars = new ArrayList<Car>();
		
		cars.add(new Car("Nissan", "GTR 2015", 540, 383));
		cars.add(new Car("Audi", "A6", 184, 343));
		cars.add(new Car("BMW", "X6", 340, 321));
		cars.add(new Car("Volkswagen", "Golf 4", 110, 240));
		cars.add(new Car("Opel", "Corsa", 60, 165));
		cars.add(new Car("Alfa", "Romeo", 109, 182));
		cars.add(new Car("Fiat", "Punto", 90, 170));
		
		Collections.sort(cars, (car1, car2)-> car1.getHorsePower() - car2.getHorsePower());
		
		for(Car car : cars){
			System.out.println(car);
		}
		
		System.out.println(cars.contains(new Car("Nissan", "Skyline", 420, 359)));
		
	}

}
