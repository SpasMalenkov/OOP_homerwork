package bank_homework_unfinished;

public class Credit extends Product{
	
	private int monthlyPayment;
	//constructor
	public Credit(String name, double dividend, int balanceOfAccaunt, int monthsPeriod) {
		super(name, dividend, balanceOfAccaunt, monthsPeriod);
		monthlyPayment = (int) ((balanceOfAccaunt/monthsPeriod) * dividend + (balanceOfAccaunt/monthsPeriod));
	}
	//da izvede komlko plashta mesechno
	public int getMonthlyPayment(){
		return monthlyPayment;
	}
	
	@Override
	public Credit copyProduct(){
		return new Credit(this.getName(), getDividend(), getBalanceOfAccaunt(), getMonthsPeriod());
	}
}
