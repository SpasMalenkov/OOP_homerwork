package postOffice;

public abstract class MailObject {
	
	private Citizen sender;
	private Citizen receiver;
	
	public MailObject(Citizen sender, Citizen receiver) {
		this.setSender(sender);
		this.setReceiver(receiver);
	}
	
	public abstract float getTax();

	public abstract int getTimeToDeliver();
	
	public Citizen getSender() {
		return sender;
	}

	public void setSender(Citizen sender) {
		this.sender = sender;
	}

	public Citizen getReceiver() {
		return receiver;
	}

	public void setReceiver(Citizen receiver) {
		this.receiver = receiver;
	}
	
}