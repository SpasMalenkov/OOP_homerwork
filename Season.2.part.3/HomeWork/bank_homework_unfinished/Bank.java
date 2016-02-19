package bank_homework_unfinished;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Bank implements IBank{
	
	private static final double MIN_PERCANTAGE_FOR_CREDIT = 50.0;
	private static final int NO_MORE_MONTHS_FOR_PAYMENT = 0;
	private static final int MIN_CLIENTS_CASH = 0;
	private static final int MIN_BANK_FUNDS = 1000000;
	private static final int MIN_PERCENTAGE_OF_RESERVE = 10;
	private String name;
	private String address;
	private long bankFunds;//nalichni pari v bankata
	private long minBankReserve;//reserv na bankata 10% ot depositite
	private Map<Client, HashSet<Product>> allAccounts;//akaunti
	
	Bank(String name, String address, long bankFunds){
		this.setName(name);
		this.setAddress(address);
		this.setBankFunds(bankFunds);
		this.minBankReserve = 0;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null && !name.equals("")){
			this.name = name;
		}
		else{
			this.name = "Bulgarian National Bank - BNB";
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
			this.address = "Sofia 1000, pl.\"Prince Alexander I\" ¹1";
		}
	}

	public long getBankFunds() {
		return bankFunds;
	}

	public void setBankFunds(long bankFunds) {
		if(bankFunds > MIN_BANK_FUNDS){
			this.bankFunds = bankFunds;
		}
		else{
			this.bankFunds = MIN_BANK_FUNDS;
		}
	}
	//uvelichavane na parite na bankata
	public void increaseFunds(int funds){
		this.setBankFunds(this.getBankFunds() + funds);
	}
	//namalqvane na partite na bankata
	public void decreaseFunds(int funds){
		this.setBankFunds(this.getBankFunds() - funds);
	}
	
	public long getMinBankReserve() {
		return minBankReserve;
	}
	//uvelichavane na reserva
	public void increaseBankReserve(int funds){
		this.minBankReserve += funds;
	}
	
	
	//dobavqne na akaunti v spisuka
		private void addAcountToBankRegistry(Client current, Product cluentProduct) {
			if(!allAccounts.containsKey(current)){
				allAccounts.put(current, new HashSet<Product>());
			}
			allAccounts.get(current).add(cluentProduct);
		}
		
		//premahvane na akaunt ot spisuka
		private void removeAccount(Map<Client, HashSet<Product>> removeAcc) {
			//ako podavania element ne e prazen
			if(removeAcc != null){
				//proverqvame dali nqkoi klient
				for(Client client : removeAcc.keySet()){
					//i product ne otgovarqt na podavania element
					for(Product product : removeAcc.get(client)){
						//izplashta se lihva ako klienta ima deposit
						if(product instanceof Deposit){
							client.setCash(client.getCash() + product.getBalanceOfAccaunt());
							this.minBankReserve -= ((Deposit) product).getBalanceOfAccaunt() / MIN_PERCENTAGE_OF_RESERVE;
						}
						//vzima se plashtane ako klienta ima kredit
						if(product instanceof Credit){
							client.setMonthlyPaymentForCredit(client.getMonthlyPaymentForCredit() - ((Credit) product).getMonthlyPayment());
						}
						//premahva se produkta na klienta
						allAccounts.get(client).remove(product);
					}
					//premahva se klienta i mu se trie bankata
					if(allAccounts.get(client).isEmpty()){
						allAccounts.remove(client);
						client.deleteBank(this);
					}
				}
			}
		}
		
		//printira vsichki vidove smetki na vseki klient
		@Override
		public void printClient(Client client){
			for(Product product : allAccounts.get(client)){
				System.out.println(product.toString());
			}
		}
		
		@Override
		public String toString() {
			return "Banks name: " + name + ", address: " + address + ", Banks funds:" + bankFunds + ", Banks reserve:"
					+ minBankReserve + ", all accounts in the bank: " + allAccounts;
		}
		
		//suzdavane na deposit v bankata chrez klient i deposit
		@Override
		public void createDeposit(Client client, Deposit deposit) throws Exception{
			int clientsCash = client.getCash();//suzdavane na promenliva s parite na klienta
			int balanceOfAcc = deposit.getBalanceOfAccaunt();//suzdavane s parite v depozita
			if(clientsCash > balanceOfAcc && clientsCash > MIN_CLIENTS_CASH){
				client.setCash(clientsCash - balanceOfAcc);//namalqvane na parite na klienta
				this.increaseFunds(deposit.getBalanceOfAccaunt());//uvelichavane na parite na bankata
				this.increaseBankReserve(deposit.getBalanceOfAccaunt() / MIN_PERCENTAGE_OF_RESERVE);//uvelichavane na reserva
				addAcountToBankRegistry(client, deposit);//dobavqne na akaunta v bankata
			}else{
				throw new Exception("The client does not have enough money to deposit them!");
			}
		}
		
		@Override
		//izplashtane na lihva
		public void payDivident() throws Exception{
			Map<Client, HashSet<Product>> removeAcc = new HashMap<Client, HashSet<Product>>();//na koi klienti trqbva da se izplati lihva
			//za vsichki klienti
			for(Client client : allAccounts.keySet()){
				//za vshichki produkti na posochenia klient ot gornia for-each
				for(Product product : allAccounts.get(client)){
					//ako producta e instancia na deposit
					if(product instanceof Deposit){
						Deposit deposit = (Deposit) product;
						int increaseDeposit = deposit.getMonthlyRate();
						//ako ot parite na bankata izvadim reserva i ostatuka e poveche ot lihvata za izplashtane pravim izplashtaneto
						if(bankFunds - minBankReserve > increaseDeposit){
							this.setBankFunds((long) (this.getBankFunds() - increaseDeposit));//izchislqvame parite na bankata
							this.minBankReserve -= deposit.getBalanceOfAccaunt() / MIN_PERCENTAGE_OF_RESERVE;//parite v rezerva
							deposit.setBalanceOfAccaunt(deposit.getBalanceOfAccaunt() + increaseDeposit);//balanca po deposita
							deposit.setMonthsPeriodLeft(deposit.getMonthsPeriodLeft() - 1);//namalqme mesecite za plashtane
							this.minBankReserve += deposit.getBalanceOfAccaunt() / MIN_PERCENTAGE_OF_RESERVE;
							if(deposit.getMonthsPeriodLeft() > NO_MORE_MONTHS_FOR_PAYMENT){
								deposit.calculateMonthlyRate();//izchilsqvame mesecite za plashtane ako sa ne sa ravni na nula
							}
							else{//premahvane na akaunta
								HashSet<Product> productForRemove = removeAcc.get(client);
								if(productForRemove == null){
									productForRemove = new HashSet<>();
								}
								productForRemove.add(deposit);//premahvane na produkta
								removeAcc.put(client, productForRemove);
							}
						}
						else{
							throw new Exception("The bank can not repay this payment right now!");//ako ne moje da se izplati v momenta
						}
					}
				}
			}
			removeAccount(removeAcc);//okonchatelno premahvane
		}
		
		@Override
		//suzdavane na krediten akaunt
		public void createCredit(Client client, Credit credit) throws Exception{
			int sallaryLeft = client.calculateRemainingSalary();//vzema se ostavashtata zaplata v procenti
			//ako e poveche ot minimalnia procent za otpuskane na kredit
			if(sallaryLeft > MIN_PERCANTAGE_FOR_CREDIT && 
					client.getSalary() - client.getMonthlyPaymentForCredit() > credit.getMonthlyPayment()){
				int balanceOfAcc = credit.getBalanceOfAccaunt();//vzima se vnoskata po kredita
				//ako bankata ima pari za otpusakne na kredita
				if(this.getBankFunds() > balanceOfAcc 
						&& this.getBankFunds() - balanceOfAcc > this.getMinBankReserve()){
					this.decreaseFunds(balanceOfAcc);//namalqvat se parite
					client.setMonthlyPaymentForCredit(client.getMonthlyPaymentForCredit() + credit.getMonthlyPayment());//postavq se vnoska za kredita
					client.calculateRemainingSalary();//izchislqva se ostavashtata zaplata
					addAcountToBankRegistry(client, credit);//dobavq se akaunta na klienta s kredita
					client.setCash(client.getCash() + balanceOfAcc);//uvelichavat mu se parite na klienta
					client.putInBanks(this);//postavq mu se nova banka
				}
				else{
					//ako bankata nqma parite
					throw new Exception("The bank can not grant such credit at the current moment!");
				}
			}
			else{
				//ako klienta ne moje da plashta
				throw new Exception("The client can not afford to pay such credit at the current moment!");
			}
		}
		
		//plashtane po kredit
		public void payCreditBill(Client client) throws Exception{
			//ako parite na klienta sa poveche ot mesechnata vnoska
			if(client.getCash() >= client.getMonthlyPaymentForCredit()){
				Map<Client, HashSet<Product>> removeAcc = new HashMap<Client, HashSet<Product>>();
				for(Product product : allAccounts.get(client)){
					//ako produkta e instancia na credit
					if(product instanceof Credit){
						Credit credit = (Credit) product;
						int payment = credit.getMonthlyPayment();//vzima se mesechnata vnoska
						client.setCash(client.getCash() - payment);//namalqvat se parite na klienta
						credit.setMonthsPeriodLeft(credit.getMonthsPeriodLeft() - 1);//namalqvat se mesecite do izplashtane na kredita
						//ako mesecite do izplashtane sa ravni na nula
						if(credit.getMonthsPeriodLeft() == 0){
							HashSet<Product> productForRemove = removeAcc.get(client);
							if(productForRemove == null){
								productForRemove = new HashSet<>();
							}
							productForRemove.add(credit);
							removeAcc.put(client, productForRemove);//premahva se produkta ot spisuka
						}
						this.increaseFunds(payment);//uvelichavat se parite na bankata
					}
				}
				removeAccount(removeAcc);//premahvame akaunta ot spisuka
			}else{
				//ne moje da si napravi plashtaneto po kredita sega
				throw new Exception("The client can not pay his credit payment at the current moment!");
			}
		}


	
}
