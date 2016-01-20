package test.task.vignette;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Driver {
	
	private final int MAX_VENCHILES_OWNED = 10;
	private int freePlacesForTasks = 10;
	private String name;
	private double money;
	private Venchile[] venchiles = new Venchile[MAX_VENCHILES_OWNED];
	private GasStation gasStation;
	
	//defaulten konstruktor
	Driver(){
	}
	
	//konstruktor s parametri
	Driver(String name, double money, GasStation gasStation){
		this();
		this.setName(name);
		this.setMoney(money);
		this.gasStation = gasStation;
	}
	
	//kupuvane na edna vinetka
	public void buyVignette(int index, int days) throws ParseException{
		Vignette vignetteForVenchile = this.gasStation.sellVignette(venchiles[index], days);
		if(vignetteForVenchile.getPrice() < this.getMoney()){
			this.setMoney(this.getMoney() - vignetteForVenchile.getPrice());
			this.venchiles[index].setVignette(vignetteForVenchile);
			this.venchiles[index].getVignette().setOnWindshield(venchiles[index]);
		}
	}
	
	//printirane na vsichki koli
	public void printVenchiles(){
		for(int i = 0; i < MAX_VENCHILES_OWNED; i++){
			System.out.println(this.venchiles[i]);
		}
	}
	
	//zadavane i printirane na imeto
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(!name.equals(null) && !name.equals("")){
			this.name = name;
		}
	}
	
	//zadavane i printirane na parite
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		if(money > 5){
			this.money = money;
		}
	}
	
	//dobavqne na prevozno sredstvo
	public void addVenchiles(Venchile venchile){
		int i = MAX_VENCHILES_OWNED - freePlacesForTasks;
		if(freePlacesForTasks > 0 && venchiles[i] == null){
			venchiles[i] = venchile;
			freePlacesForTasks -= 1;
		}else{
			System.out.println("There is no free places for venchiles.");
		}
	}
	
	
	public Venchile[] getVenchiles() {
		return venchiles;
	}
	
	
	//printirane na prevoznite sredstva
	public void displayVenchiles(){
		int count = 0;
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		for(int i = 0; i < MAX_VENCHILES_OWNED; i++){
			if(!this.venchiles[i].equals(null)){
				count++;
			}
		}
		int index = (int)(Math.random()*(9 - 0) + 0);
		this.venchiles[index].setDriver(this);
		System.out.println(this.getName() + " has " + count + " venchiles right now, has " + this.getMoney() 
			+ " money left and is driving at the moment " + this.venchiles[index].getModel() + ".");
		for(int i = 0; i < MAX_VENCHILES_OWNED; i++){
			if(this.venchiles[i].getVignette() != null){
				if(this.venchiles[i].getVignette().getExpiryDate().before(now)){
					System.out.println(this.getName() + " has venchile model " + this.venchiles[i].getModel() + " with year of manifacturing "
							+ this.venchiles[i].getYear() + " which has vignette " + this.venchiles[i].getVignette().getColor() 
							+ " for " + this.venchiles[i].getVignette().getValidity() + " days for price " 
							+ this.venchiles[i].getVignette().getPrice() + " and has expiration date " + this.venchiles[i].getVignette().getExpiryDate() + ".");
				}
			}//else{
//				System.out.println(this.getName() + " has venchile model "
//						+ this.venchiles[i].getModel()  + " with year of manifacturing " + this.venchiles[i].getYear() + " without vignette.");
//			}
		}
	}
	
	//printirane na kanionite s iztekli vinetki
	//tuk ne mojah da se opravq...
//	public void printTrucksWithExpiredVignettes(){
//		Calendar calendar = Calendar.getInstance();
//		Date now = calendar.getTime();
//		
//			for(Venchile v : this.getVenchiles()){
//				if(v != null){
//					Class<? extends Venchile> c = v.getClass();
//					if(c.equals(Truck.class)){
//						for(int i = 0; i < MAX_VENCHILES_OWNED; i++){
//						if(this.venchiles[i].getVignette().getExpiryDate().before(now)){
//							System.out.println(v.getModel() + " " + this.venchiles[i].getVignette().getExpiryDate());
//						}
//					}
//				}
//			}
//		}
//	}
	
}
