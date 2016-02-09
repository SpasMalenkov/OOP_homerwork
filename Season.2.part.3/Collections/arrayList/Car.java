package arrayList;

public class Car {
	
	private String brand;
	private String model;
	private int horsePower;
	private double maxSpeed;
	
	
	public Car(String brand, String model, int horsePower, double maxSpeed) {
		this.brand = brand;
		this.model = model;
		this.horsePower = horsePower;
		this.maxSpeed = maxSpeed;
	}

	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		if(!brand.equals(null) && !brand.equals(""))
			this.brand = brand;
	}

	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		if(!model.equals(null) && !model.equals(""))
			this.model = model;
	}

	
	public int getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(int horsePower) {
		if(horsePower > 0)
			this.horsePower = horsePower;
	}

	
	public double getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(double maxSpeed) {
		if(maxSpeed > 0)
			this.maxSpeed = maxSpeed;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Car)) return false;
		
		Car otherCar = (Car)obj;
		
		return otherCar.getBrand().equals(this.getBrand()) && otherCar.getModel().equals(this.getModel()) && 
				otherCar.getHorsePower()==this.getHorsePower() && otherCar.getMaxSpeed()==this.getMaxSpeed();
	}


	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + ", horsePower=" + horsePower + ", maxSpeed=" + maxSpeed
				+ "]";
	}
	
}
