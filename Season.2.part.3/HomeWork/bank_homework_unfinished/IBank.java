package bank_homework_unfinished;

public interface IBank {
	
	void createDeposit(Client client, Deposit clientDeposit) throws Exception;
	
	void payDivident() throws Exception;
	
	void createCredit(Client client,Credit clientCredit) throws Exception;
	
	void payCreditBill(Client client) throws Exception;
	
	void printClient(Client client);
	
}
