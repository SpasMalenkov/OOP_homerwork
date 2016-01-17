package carpartsshop;

public class Country {
	
	String name;
	
	
	public Country(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(!name.equalsIgnoreCase("") && !name.equalsIgnoreCase(null)){
			this.name = name;
		}
	}
	
}
