package bank_homework_unfinished;

import java.util.Set;

public class Client {
	
	private static int count = 0;
	private String name;
	private String address;
	private int cash;//nalichni pari
	private int salary;//zaplata
	private int monthlyPaymentForCredit;//mesechni plashtania po credit
	private Set<IBank> banks;//suzdavane na spisuk ot banki, ne sum siguren che e taka
	
	public Client(String name, String address, int cash, int salary) {
		this.setName(name);
		this.setAddress(address);
		this.setCash(cash);
		this.setSalary(salary);
		count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null && !name.equals("")){
			this.name = name;
		}
		else{
			this.name = "Client" + count;
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if(address!=null && !address.equals("")){
			this.address = address;
		}
		else{
			this.address = "Velichkovo, str." + count + ", number " + count;
		}
		
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		if(cash > 100){
			this.cash = cash;
		}
		else{
			this.cash = 100;
		}
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		if(salary > 420){
			this.salary = salary;
		}
		else{
			this.salary = 420;
		}
	}
	
	public int calculateRemainingSalary() {
		return (((salary - monthlyPaymentForCredit) / salary) * 100);
	}
	
	//suzdava deposit v izbrana banka
	public void createDeposit(IBank bank, Deposit deposit) throws Exception{
		if(deposit != null){
			bank.createDeposit(this, deposit);
		}
	}
	//suzdava credit v izbrana banka
	public void createCredit(IBank bank, Credit credit) throws Exception{
		if(credit != null){
			bank.createCredit(this, credit);
		}
	}
	//plashta creditnata si smetka
	public void payCreditBills() throws Exception {
		for (IBank bank : banks) {
			bank.payCreditBill(this);
		}
	}
	//vrushta kolko plashta na mesec za credita
	public int getMonthlyPaymentForCredit(){
		return monthlyPaymentForCredit;
	}
	//izchislqva kolko plashta na mesec za credita
	public void setMonthlyPaymentForCredit(int monthlyPaymentForCredit){
		this.monthlyPaymentForCredit = monthlyPaymentForCredit;
	}
	//vkarva banki v spisuka
	public void putInBanks(IBank bank){
		if(!banks.contains(bank)){
			banks.add(bank);
		}
	}
	//iztriva banka v spisuka
	public void deleteBank(IBank bank){
		if(banks.contains(bank)){
			banks.remove(bank);
		}
	}
	//printira v koi banki kakvi smetki ima
	public void printAccountsInBanks(){
		for(IBank bank : banks){
			bank.printClient(this);
		}
	}

	@Override
	public String toString() {
		return "\n Client: " + name + ", address: " + address + ", cash: " + cash;
	}
	
	
}
