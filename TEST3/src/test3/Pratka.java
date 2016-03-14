package test3;

import java.time.LocalDateTime;

public class Pratka {
	
	private Client podatel;
	private Client poluchatel;
	private String sydyrjanie;
	private static int lastID = 1;
	private final int id;
	private LocalDateTime send;
	
	public Pratka(Client podatel, Client poluchatel, String sydyrjanie){
		this.podatel = podatel;
		this.poluchatel = poluchatel;
		this.sydyrjanie = sydyrjanie;
		this.id = lastID++;
		this.send = LocalDateTime.now();
	}

	public Client getPoluchatel() {
		return poluchatel;
	}

	public Client getPodatel() {
		return podatel;
	}

	@Override
	public String toString() {
		return "Pratka [podatel=" + podatel + ", poluchatel=" + poluchatel + ", sydyrjanie=" + sydyrjanie + ", id=" + id
				+ ", send=" + send + "]";
	}
	
}
