package carpartsshop;

public class Company implements IBuySellMakeParts{
	
	private static final double PRICE_FOR_MAKING_PARTS = 0.3;
	private String name;
	private double money;
	private Country country;
	private String address;
	private String phoneNumber;
	private String fax;
	private CarParts carparts;
	
	
	public Company(String name, double money, Country country, String address, String phoneNumber, String fax) {
		this.setName(name);
		this.setMoney(money);
		this.setCountry(country);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
		this.setFax(fax);
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
		if(money > 1000000){
			this.money = money;
		}
	}
	
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		if(!country.equals(null)){
			this.country = country;
		}
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(!address.equalsIgnoreCase("") && !address.equalsIgnoreCase(null)){
			this.address = address;
		}
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		if(!phoneNumber.equalsIgnoreCase("") && !phoneNumber.equalsIgnoreCase(null)){
			if(phoneNumber.length() == 10 && phoneNumber.startsWith("08")){
				this.phoneNumber = phoneNumber;
			}
		}
	}
	
	
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		if(!fax.equalsIgnoreCase("") && !fax.equalsIgnoreCase(null)){
			if(fax.length() == 9 && fax.startsWith("02/")){
				this.fax = fax;
			}
		}
	}
	
	
	public CarParts getCarparts() {
		return carparts;
	}
	public void setCarparts(CarParts carparts) {
		if(!carparts.equals(null)){
			this.carparts = carparts;
		}
	}
	
	
	public void makeParts(int quantity, int priceSell){
		this.carparts.setQuantity(quantity);
		this.carparts.setPriceSell(priceSell);
		this.setMoney(getMoney() - (PRICE_FOR_MAKING_PARTS * quantity)); 
	}
	
	@Override
	public void sellParts(int quantity){
		this.carparts.setQuantity(this.carparts.getQuantity() - quantity);
		this.setMoney(this.getMoney() + this.carparts.getPriceSell()*quantity);
	}
	
}
