package supermarket;

public abstract class Product implements Buyable{
	
	private String name;
	private double price;
	private int quantity;
	private int ageRestriction;
	
	Product(String name, double price, int quantity, int ageRestriction){
		setName(name);
		setPrice(price);
		setQuantity(quantity);
		setAgeRestriction(ageRestriction);
	}
	
	@Override
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		if(price > 0){
			this.price = price;
		}
	}
	
	
	public int getAgeRestriction() {
		return ageRestriction;
	}
	public void setAgeRestriction(int ageRestriction){
		if(ageRestriction > 0){
			this.ageRestriction = ageRestriction;
		}
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(!name.equalsIgnoreCase("") && !name.equalsIgnoreCase(null)){
			this.name = name;
		}
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		if(quantity > 0){
			this.quantity = quantity;
		}else{
			this.quantity = 0;
		}
	}
	
	
}
