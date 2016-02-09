package nested.classes;

public class Demo {
	
	public static void main(String[] args) {
		
		Traktor lamborghini = new Traktor();
		
		Traktor.Guma guma = new Traktor.Guma(20, 100);
		
		Karuca.Guma guma2 = new Karuca.Guma(2, 1, 3);
		
		Karuca karuchka = new Karuca();
		
		
		System.out.println(karuchka.getGuma1().diameter);
		System.out.println(karuchka.getGuma1().weight);
		System.out.println(karuchka.getGuma1().getNumberOfBolts());
		
	}
	
}
