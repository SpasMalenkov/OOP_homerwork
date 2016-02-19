package bank_homework_unfinished;

public class Deposit extends Product{

	private int monthlyRate;
	//constructor
	public Deposit(String name, double dividend, int balanceOfAccaunt, int monthsPeriod){
		super(name, dividend, balanceOfAccaunt, monthsPeriod);
		this.calculateMonthlyRate();
	}
	//izchislqva kolko mu e lihvata
	public void calculateMonthlyRate(){
		monthlyRate = (int) (this.getBalanceOfAccaunt() * getDividend());
	}
	//vrushta kolko mu e lihvata
	public int getMonthlyRate(){
		return monthlyRate;
	}
	
	@Override
	public Deposit copyProduct() {
		return new Deposit(this.getName(), getDividend(), getBalanceOfAccaunt(), getMonthsPeriod());
	}
	
	
}
