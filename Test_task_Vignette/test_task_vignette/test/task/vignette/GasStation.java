package test.task.vignette;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class GasStation {
	
	private String name;
	private int MAX_SELLING_VIGNETTES = 400;
	double turnoverForToday;
	Vignette[] vignettes = new Vignette[MAX_SELLING_VIGNETTES];
	
	//construktor za benzinostancia
	GasStation(String name){
		this.turnoverForToday = 0;
		this.name = name;
		this.createVignettes();
	}
	
	//prdovane na vinetka
	public Vignette sellVignette(Venchile venchile, int days){
		Vignette vignette = null;
		String color;
		Class<? extends Venchile> c = venchile.getClass();
		if(c.equals(Car.class)){
			color = "car";
			vignette = findVignette(color, days, vignette);
		}else if(c.equals(Truck.class)){
			color = "truck";
			vignette = findVignette(color, days, vignette);
		}else if(c.equals(Autobus.class)){
			color = "autobus";
			vignette = findVignette(color, days, vignette);
		}
		return vignette;
	}
	
	//namirane na tochnata vinetka
	private Vignette findVignette(String color, int days, Vignette vignette) {
		int index = 0;
		for(int i = 0; i < MAX_SELLING_VIGNETTES; i++){
			if(this.vignettes[i].getColor().equalsIgnoreCase(color) && this.vignettes[i].getValidity() == days){
				vignettes[i].setDateOfIssue(setDateOfIssue());
				vignette =  vignettes[i];
				this.setTurnoverForToday(this.getTurnoverForToday() + vignettes[i].getPrice());
				index = i;
				break;
			}
		}
		Vignette temp = vignettes[index];
		this.vignettes[index] = vignettes[MAX_SELLING_VIGNETTES - 1];
		this.vignettes[MAX_SELLING_VIGNETTES - 1] = temp;
		this.vignettes[MAX_SELLING_VIGNETTES - 1] = null;
		MAX_SELLING_VIGNETTES -= 1;
		sortVignettes(vignettes, MAX_SELLING_VIGNETTES);
		return vignette;
	}
	
	//zadavane i printirane na oborota
	public double getTurnoverForToday() {
		return turnoverForToday;
	}
	public void setTurnoverForToday(double turnoverForToday) {
		if(turnoverForToday > 0){
			this.turnoverForToday = turnoverForToday;
		}
	}
	
	//printira imeto
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(!name.equals(null) && !name.equals("")){
			this.name = name;
		}
	}
	
	//suzdavane na vinetki
	private void createVignettes(){
		int count = 0;
		int index = 0;
		for(int i = 0; i < MAX_SELLING_VIGNETTES; i++){
			if(i % 3 == 0){
				index = i;
			}
			if(i - index == 0){
				vignettes[i] = new Vignette("car");
			}else if(i - index == 1){
				vignettes[i] = new Vignette("truck");
			}else if(i - index == 2){
				vignettes[i] = new Vignette("autobus");
			}
		}
		for(int i = 0; i < MAX_SELLING_VIGNETTES; i++){
			if(count == 0){
				vignettes[i].setValidity(7);
			}else if(count == 1){
				vignettes[i].setValidity(30);
			}else if(count == 2){
				vignettes[i].setValidity(365);
			}else if(count == 3){
				vignettes[i].setValidity(365);
			}else if(count == 4){
				vignettes[i].setValidity(7);
			}else if(count == 5){
				vignettes[i].setValidity(30);
			}else if(count == 6){
				vignettes[i].setValidity(30);
			}else if(count == 7){
				vignettes[i].setValidity(365);
			}else if(count == 8){
				vignettes[i].setValidity(7);
			}
			count++;
			if(count == 9){
				count = 0;
			}
		}
		for(int i = 0; i < MAX_SELLING_VIGNETTES; i++){
			this.vignettes[i].setPrice();
		}
		sortVignettes(vignettes, MAX_SELLING_VIGNETTES);
	}
	
	//sortirane na vinetkite s bubble sort
	public Vignette[] sortVignettes(Vignette[] vignettes, int length){
		Vignette temp;
		for(int i = 0; i < length; i++){
			for(int j = 1; j < length - i; j++){
				if(vignettes[j].getPrice() < vignettes[j-1].getPrice()){
					temp = vignettes[j];
					vignettes[j] = vignettes[j-1];
					vignettes[j-1] = temp;
				}
			}
		}
		return vignettes;
	}
	
	//printirane na vinetkite
	public void printVignette(){
		for(int i = 0; i < MAX_SELLING_VIGNETTES; i++){
			if(!vignettes[i].equals(null)){
				System.out.println(i + " " + this.vignettes[i].getColor() + " " 
						+ this.vignettes[i].getValidity() + " " + this.vignettes[i].getPrice());
			}
		}
	}
	
	public LocalDate setDateOfIssue(){
		Random random = new Random();
		int minDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2016, 1, 20).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
		return randomBirthDate;
	}
}
