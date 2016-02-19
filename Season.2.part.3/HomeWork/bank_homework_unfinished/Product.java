package bank_homework_unfinished;

public abstract class Product {
	
	private String name;
	private double dividend;//lihva
	private int balanceOfAccaunt;//balance po smetkata
	private int monthsPeriod;//period za koito shte se izvurshvat plashtania
	private int monthsPeriodLeft;//ostavasht period za plashtania
	
	public Product(String name, double dividend, int balanceOfAccaunt, 
			int monthsPeriod) {
		this.name = name;
		this.dividend = dividend;
		this.setBalanceOfAccaunt(balanceOfAccaunt);
		this.setMonthsPeriodLeft(monthsPeriod);
		this.monthsPeriod = monthsPeriod;
		
	}

	public String getName() {
		return name;
	}

	public double getDividend() {
		return dividend;
	}

	public int getBalanceOfAccaunt() {
		return balanceOfAccaunt;
	}

	public void setBalanceOfAccaunt(int balanceOfAccaunt) {
		this.balanceOfAccaunt = balanceOfAccaunt;
	}

	public int getMonthsPeriod() {
		return monthsPeriod;
	}
	//vrushta kolko meseca mu ostavat da plashta
	public int getMonthsPeriodLeft() {
		return monthsPeriodLeft;
	}
	//zadava kolko meseca mu ostavat da plashta
	public void setMonthsPeriodLeft(int monthsPeriodLeft) {
		if(monthsPeriodLeft >= 0){
			this.monthsPeriodLeft = monthsPeriodLeft;
		}
	}
	//kopira producta
	protected abstract Product copyProduct();
	
	@Override
	public String toString() {
		return "\n Product: " + name + ", dividend: " + dividend * 100 + "%, balanceOfAccaunt: " + balanceOfAccaunt
				+ ", monthsPeriod: " + monthsPeriod + ", monthsPeriodLeft: " + monthsPeriodLeft;
	}
	
}
