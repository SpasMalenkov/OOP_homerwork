package test3;

import java.util.List;

public class CourierFromMainOffice extends CourierToMainOffice {
	
	public CourierFromMainOffice(String name, String gsm, long number, String address, CityOffice cityOffice, MainOffice mainOffice) throws ClientException {
		super(name, gsm, number, address, cityOffice, mainOffice);
	}
	
	@Override
	public void run(){
//		while(true){
			while(getMainOffice().returnNumberOfPackages(this.getCity()) < NUMBER_OF_MIN_PACKAGES){
				synchronized(getMainOffice()){
					try{
						System.out.println("Chakam za pratki ot glavnia ofis v Turnovo.");
						getMainOffice().wait();
					}catch(InterruptedException e){
						e.printStackTrace();
						return;
					}
				}
			}
			
			System.out.println("Vzemam pratki za ofisa mi");
			
			try{
				this.getCityOffice().addPratki(getMainOffice().sendPratki(this.getCity()));
				Thread.sleep(1000);
				System.out.println("Karam pratkite kum " + this.getCity());
				synchronized(getMainOffice()){
					getMainOffice().notifyAll();
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
//		}
	}
}
