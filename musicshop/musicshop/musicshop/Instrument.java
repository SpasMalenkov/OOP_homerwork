package musicshop;

public class Instrument {
	
	private String name;
	private MusicInstrument type;
	private int price;
	
	Instrument(String name, MusicInstrument type, int price){
		this.type = type;
		this.name = name;
		this.setPrice(price);
	}

	public String getName() {
		return name;
	}


	public MusicInstrument getType() {
		return type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price <= 0){
			this.price = (int)(Math.random() * 10);
		}else{
			this.price = price;
		}
	}
	
}
