package smartCourier;

import java.time.LocalDateTime;

public class Parcel {
	private static int lastId = 1;
	private final int parcelId;
	private Citizen sender;
	private Citizen reciever;
	String content;
	LocalDateTime dateTime;

	public Parcel(Citizen sender, Citizen reciever, String content, LocalDateTime dateTime) {
		this.parcelId = lastId++;
		this.sender = sender;
		this.reciever = reciever;
		this.content = content;
		this.dateTime = dateTime;
	}

	public Citizen getSender() {
		return sender;
	}

	public void setSender(Citizen sender) {
		this.sender = sender;
	}

	public Citizen getReciever() {
		return reciever;
	}

	public void setReciever(Citizen reciever) {
		this.reciever = reciever;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
