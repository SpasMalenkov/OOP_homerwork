package supermarket;

public class Computer extends ElectronicsProduct{
	
	Computer(String name, double price, int quantity, int ageRestriction, int guaranteePeriod) {
		super(name, price, quantity, ageRestriction, guaranteePeriod);
	}
	
	@Override
	public void setGuaranteePeriod(int guaranteePeriod) {
		if(guaranteePeriod < 24){
			this.guaranteePeriod = 24;
		}else{
			this.guaranteePeriod = guaranteePeriod;
		}
	}
	
	@Override
	public void returnPrice(int quantity){
		if(this.getQuantity() > 1000){
			this.setPrice(this.getPrice() *0.95);
		}
	}
}
