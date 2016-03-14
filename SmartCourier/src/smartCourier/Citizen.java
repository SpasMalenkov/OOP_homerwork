package smartCourier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Citizen implements Runnable {

	private static final int NUMBER_OF_PARCELS = 35;
	private String name;
	private String gsm;
	private String personalNumber;
	private String Bulstat;
	private Adress adress;
	private Office office;
	private static List<Office> offices;

	public static List<Office> getOffices() {
		ArrayList<Office> office = new ArrayList<Office>();
		office.addAll(offices);
		return office;
	}

	public int getsize() {
		return getOffices().size();

	}

	static {

		offices.add(new Office(CitiesName.PLOVDIV));
		offices.add(new Office(CitiesName.RUSE));
		offices.add(new Office(CitiesName.SOFIA));
		offices.add(new Office(CitiesName.VARNA));

	}

	public Citizen(String name, String gsm, String personalNumber, Adress adress) {

		setName(name);
		setGsm(gsm);
		setPersonalNumber(personalNumber);
		setAdress(adress);
		
	}

	public Citizen(String name, String gsm, String personalNumber, String bulstat, Adress adress) {

		this.name = name;
		this.gsm = gsm;
		this.personalNumber = personalNumber;
		Bulstat = bulstat;
		this.adress = adress;
	}

	@Override
	public void run() {

		for (int index = 0; index < NUMBER_OF_PARCELS; index++) {

			Adress adress = new Adress(CitiesName.PLOVDIV, "maina 3");

			Citizen man = new Citizen("Pesho", "231321", "9625845585", adress);

			Parcel parcel = createParcel(man, man, "malki ku4ki", LocalDateTime.now());

			try {

				Office office = getOffices().get((int) (Math.random() * 4));

				office.takeParcel(parcel);
			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

	public Parcel createParcel(Citizen sender, Citizen reciever, String content, LocalDateTime dateTime) {
		return new Parcel(sender, reciever, content, dateTime);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name!=null){
			this.name = name;
		}
		
	}



	public void setGsm(String gsm) {
		if(gsm!=null){
			this.gsm = gsm;
		}
		
	}

	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}

	public String getBulstat() {
		return Bulstat;
	}


	public void setAdress(Adress adress) {
		if(adress!=null){
			this.adress = adress;
		}
	
	}

	public Office getOffice() {
		return office;
	}

	
}
