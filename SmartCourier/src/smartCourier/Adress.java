package smartCourier;

public class Adress {

	private CitiesName city;
	private String street;

	public Adress(CitiesName city, String street) {
		
		setStreet(street);
	}

	public CitiesName getCity() {
		return city;
	}

	public void setCity(CitiesName city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		if(street!=null){
			this.street = street;
		}
		else{
			try {
				throw new Exception("Ahdiasf maikati");
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		}
	}

}
