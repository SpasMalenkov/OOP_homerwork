package carpartsshop;

public class Customer implements IBuySellMakeParts{
	
	private static final int MAX_PLACES_FOR_PARTS = 5;
	private int freePlacesForParts = 0;
	private String name;
	private double money;
	private Car car;
	private CarParts[] carparts = new CarParts[MAX_PLACES_FOR_PARTS];
	
	
	public Customer(String name, double money, Car car, CarParts[] carparts) {
		this.name = name;
		this.money = money;
		this.car = car;
		this.carparts = carparts;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(!name.equalsIgnoreCase("") && !name.equalsIgnoreCase(null)){
			this.name = name;
		}
	}
	
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		if(money > 1000){
			this.money = money;
		}
	}
	
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	
	public CarParts[] getCarparts() {
		return carparts;
	}
	@Override
	public void addCarParts(CarParts carpart){
		int i = MAX_PLACES_FOR_PARTS - freePlacesForParts;
		if(freePlacesForParts > 0 && carparts[i] == null){
			carparts[i] = carpart;
			freePlacesForParts -= 1;
		}else{
			System.out.println("You can't buy more carparts.");
		}
	}
	
}
