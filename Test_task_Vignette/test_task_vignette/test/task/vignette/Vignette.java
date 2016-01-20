package test.task.vignette;

import java.text.SimpleDateFormat;

public class Vignette {
	
	private static final int[] PRICE_FOR_WEEK = {5, 7, 9};
	private SimpleDateFormat dateOfIssue;
	private SimpleDateFormat expiryDate;
	private String color;
	private int validity;
	private int price;
	
	
	Vignette(String color){
		this.setColor(color);
	}
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice() {
		if(this.color.equalsIgnoreCase("car")){
			if(this.validity == 7){
				this.price = PRICE_FOR_WEEK[0];
			}else if(this.validity == 30){
				this.price = 10*PRICE_FOR_WEEK[0];
			}else if(this.validity == 365){
				this.price = 60*PRICE_FOR_WEEK[0];
			}
		}else if(this.color.equalsIgnoreCase("truck")){
			if(this.validity == 7){
				this.price = PRICE_FOR_WEEK[1];
			}else if(this.validity == 30){
				this.price = 10*PRICE_FOR_WEEK[1];
			}else if(this.validity == 365){
				this.price = 60*PRICE_FOR_WEEK[1];
			}
		}else if(this.color.equalsIgnoreCase("autobus")){
			if(this.validity == 7){
				this.price = PRICE_FOR_WEEK[2];
			}else if(this.validity == 30){
				this.price = 10*PRICE_FOR_WEEK[2];
			}else if(this.validity == 365){
				this.price = 60*PRICE_FOR_WEEK[2];
			}
		}
	}


	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		if(color.equalsIgnoreCase("car")){
			this.color = color;
		}else if(color.equalsIgnoreCase("truck")){
			this.color = color;
		}else if(color.contentEquals("autobus")){
			this.color = color;
		}
	}
	
	
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		if(validity == 7 || validity == 30 || validity == 365){
			this.validity = validity;
		}
	}
	
	
	public void setOnFrontGlass(Venchile venchile){
		if(venchile != null){
			Class<? extends Venchile> c = venchile.getClass();
			if(c.equals(Car.class)){
				System.out.println("Set on the glass for 5 seconds.");
			}else if(c.equals(Truck.class)){
				System.out.println("Set on the glass for 10 seconds.");
			}else if(c.equals(Autobus.class)){
				System.out.println("Set on the glass for 20 seconds.");
			}
		}	
	}
	
	public boolean setOnGlass(Venchile venchile){
		if(venchile != null){
			return true;
		}
		else{
			return false;
		}
	}
	
}