package supermarket;

public class Appliance extends ElectronicsProduct{

	Appliance(String name, double price, int quantity, int ageRestriction, int guaranteePeriod) {
		super(name, price, quantity, ageRestriction, guaranteePeriod);
	}
	
	@Override
	public void setGuaranteePeriod(int guaranteePeriod) {
		if(guaranteePeriod < 6){
			this.guaranteePeriod = 6;
		}else{
			this.guaranteePeriod = guaranteePeriod;
		}
	}
	
	@Override
	public void returnPrice(int quantity){
		if(this.getQuantity() < 50){
			this.setPrice(this.getPrice() * 1.05);
		}
	}
}
