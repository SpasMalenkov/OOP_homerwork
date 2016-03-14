package test3;

public class Client {
	
	private String name;
	private String gsm;
	private long number;
	private String address;
	private CityName city;
	
	public Client(String name, String gsm, long number, String address, CityName city) throws ClientException{
		this.setName(name);
		this.setGsm(gsm);
		this.setNumber(number);
		this.setAddress(address);
		this.city = city;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", " + ", city=" + city + "]";
	}

	public void setName(String name) throws ClientException {
		if(name != null && !name.equals("")){
			this.name = name;
		}else{
			throw new ClientException("Nevalidno Ime.");
		}
	}

	public String getGsm() {
		return gsm;
	}

	public void setGsm(String gsm) throws ClientException {
		if(gsm.startsWith("08") && gsm.length() == 10){
			this.gsm = gsm;
		}else{
			throw new ClientException("Nevaliden GSM.");
		}
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public CityName getCity() {
		return city;
	}

	public void setAddress(String address) throws ClientException {
		if(address != null && !address.equals("")){
			this.address = address;
		}else{
			throw new ClientException("Nevaliden adres.");
		}
	}
	
}
