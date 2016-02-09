package test.task.vignette;

public class Venchile {
	
	private String model;
	private Vignette vignette;
	private int year;
	private Driver driver;
	
	//konstruktor s parametri
	public Venchile(String model, int year) {
		this.setModel(model);
		this.setYear(year);
	}
	
	//zadavane na modela
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		if(!model.equals(null) && !model.equals("")){
			this.model = model;
		}
	}
	
	//zadavane na godinata
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if(year >= 1970 && year <= 2015){
			this.year = year;
		}
	}
	
	//zadavane na vinetkata
	public void setVignette(Vignette vignette){
		this.vignette = vignette;
	}
	public Vignette getVignette(){
		return vignette;
	}
	
	public void setDriver(Driver driver){
		this.driver = driver;
	}
	
}
