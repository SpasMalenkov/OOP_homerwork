package nested.classes;

public class Karuca {
	
	private Guma guma1;
	private Guma guma2;
	
	static class Guma extends Traktor.Guma{
		
		private int numberOfBolts;

		public Guma(int numberOfBolts, int diameter, int weight) {
			super(diameter, weight);
			this.numberOfBolts = numberOfBolts;
		}
		
		public int getNumberOfBolts(){
			return numberOfBolts;
		}
		
	}
	
	Karuca(){
		this.guma1 = new Guma(1, 1, 3);
		this.guma2 = new Guma(1, 1, 3);
		
		guma1.numberOfBolts = 2;
		guma2.numberOfBolts = 2;
	}
	
	public Guma getGuma1(){
		return guma1;
	}
	
	public Guma getGuma2(){
		return guma2;
	}
}
