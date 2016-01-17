package supermarket;

public class ElectronicsProduct extends Product{
	
	int guaranteePeriod;
	
	ElectronicsProduct(String name, double price, int quantity, int ageRestriction, int guaranteePeriod) {
		super(name, price, quantity, ageRestriction);
		setGuaranteePeriod(guaranteePeriod);
	}

	public int getGuaranteePeriod() {
		return guaranteePeriod;
	}
	
	
	public void setGuaranteePeriod(int guaranteePeriod) {
		if(guaranteePeriod < 0){
			this.guaranteePeriod = 0;
		}else{
			this.guaranteePeriod = guaranteePeriod;
		}
	}
	
	public void returnPrice(int quantity){
		
	}
}
