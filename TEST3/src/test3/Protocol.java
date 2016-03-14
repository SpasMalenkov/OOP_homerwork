package test3;

public class Protocol {
	
	private Client sender;
	private Client receiver;
	
	public Protocol(Client sender, Client receiver){
		this.sender = sender;
		this.receiver = receiver;
	}

	public Client getSender() {
		return sender;
	}

	public Client getReceiver() {
		return receiver;
	}
	
	
}
