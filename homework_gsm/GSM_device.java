package homework_gsm;

import java.util.Scanner;

public class GSM_device {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//suzdavane na otdelni gsm-i
		GSM gsmOfSpas = new GSM();
		GSM gsmOfVladi = new GSM();
		GSM gsmOfTodor = new GSM();
		
		//zadavane na harakteristikite
		gsmOfSpas.model = "iPhone 4S";
		gsmOfSpas.hasSimCard = false;
		gsmOfSpas.simMobileNumber = "";
		
		gsmOfVladi.model = "HTC";
		gsmOfVladi.hasSimCard = true;
		gsmOfVladi.simMobileNumber = "0898824109";
		
		gsmOfTodor.model = "Samsung";
		gsmOfTodor.hasSimCard = true;
		gsmOfTodor.simMobileNumber = "0887877077";
		
		//postavqne na sim karta i proverka za tova dali e postavqno predi tova
		if(gsmOfSpas.hasSimCard == false && gsmOfSpas.simMobileNumber == ""){
			
			String simMobileCard = sc.nextLine();
			gsmOfSpas.insertSimCard(simMobileCard);
			System.out.println(gsmOfSpas.hasSimCard);
			System.out.println(gsmOfSpas.simMobileNumber);
			
		}else{
			
			System.out.println(gsmOfSpas.model + " has inserted sim card.");
			System.out.println(gsmOfSpas.hasSimCard);
			System.out.println(gsmOfSpas.simMobileNumber);
			
		}
		
		if(gsmOfVladi.hasSimCard == false && gsmOfVladi.simMobileNumber == ""){
			
			String simMobileCard = sc.nextLine();
			gsmOfVladi.insertSimCard(simMobileCard);
			System.out.println(gsmOfVladi.hasSimCard);
			System.out.println(gsmOfVladi.simMobileNumber);
			
		}else{
			
			System.out.println(gsmOfVladi.model + " has inserted sim card.");
			System.out.println(gsmOfVladi.hasSimCard);
			System.out.println(gsmOfVladi.simMobileNumber);
			
		}
		
		if(gsmOfTodor.hasSimCard == false && gsmOfTodor.simMobileNumber == ""){
			
			String simMobileCard = sc.nextLine();
			gsmOfTodor.insertSimCard(simMobileCard);
			System.out.println(gsmOfTodor.hasSimCard);
			System.out.println(gsmOfTodor.simMobileNumber);
			
		}else{
			
			System.out.println(gsmOfTodor.model + " has inserted sim card.");
			System.out.println(gsmOfTodor.hasSimCard);
			System.out.println(gsmOfTodor.simMobileNumber);
			
		}
		
		//ne sum go vkluchil zashtoto za da sum siguren dali rabotqt drugite metodi
//		if(gsmOfSpas.hasSimCard == false && gsmOfSpas.simMobileNumber == ""){
//			
//			System.out.println("There is no sim card inserted.");
//			
//		}else{
//			
//			gsmOfSpas.removeSimCard();
//			System.out.println(gsmOfSpas.hasSimCard);
//			System.out.println(gsmOfSpas.simMobileNumber);
//			
//		}
		
		//suzdavane na obekti obajdania
		Call callerSpas = new Call();
		Call callerVladi = new Call();
		Call callerTodor = new Call();
		
		//koi se obajda i na kogo
		
		String makeACall;
		
		String receiveACall;
		int duration = 0;
		
		//proverka na obajdaniata(s malko promeni i ne raboti...)
		do{
			
			System.out.println("Who wants to make a call?");
			makeACall = sc.nextLine();
			System.out.println("Enter the legnth of the call.");
			duration = sc.nextInt();
			
			
			if(makeACall.equalsIgnoreCase("spas")){
				
				callerSpas.duration = duration;
				callerSpas.caller = gsmOfSpas;
				System.out.println("To who is calling?");
				receiveACall = sc.nextLine();
				if(receiveACall.equalsIgnoreCase("todor")){
					
					callerSpas.receiver = gsmOfTodor;
					
				}
				if(receiveACall.equalsIgnoreCase("vladi")){
					
					callerSpas.receiver = gsmOfVladi;
					
				}
				
				gsmOfSpas.call(callerSpas.receiver, callerSpas.duration);
				
			}
			
			if(makeACall.equalsIgnoreCase("vladi")){
				
				callerVladi.duration = duration;
				callerVladi.caller = gsmOfVladi;
				System.out.println("To who is calling?");
				receiveACall = sc.nextLine();
				if(receiveACall.equalsIgnoreCase("todor")){
					
					callerSpas.receiver = gsmOfTodor;
					
				}
				if(receiveACall.equalsIgnoreCase("spas")){
					
					callerSpas.receiver = gsmOfSpas;
					
				}
				
				gsmOfVladi.call(callerVladi.receiver, callerVladi.duration);
				
			}
			
			if(makeACall.equalsIgnoreCase("todor")){
				System.out.println("To who is calling?");
				receiveACall = sc.nextLine();
				callerTodor.duration = duration;
				callerTodor.caller = gsmOfTodor;
				
				if(receiveACall.equalsIgnoreCase("spas")){
					
					callerSpas.receiver = gsmOfSpas;
					
				}
				if(receiveACall.equalsIgnoreCase("vladi")){
					
					callerSpas.receiver = gsmOfVladi;
					
				}
				
				gsmOfTodor.call(callerTodor.receiver, callerTodor.duration);
				
			}
			
		}while(duration > 0);
		
		//printirane na razlichnite rezultati - suma ot vsichki obajdania(vse oshte ne raboti kakto trqbva), 
		//posledni obajdania(izhodqshti i vhodqshti)
		gsmOfSpas.getSumForCall();
		gsmOfVladi.getSumForCall();
		gsmOfTodor.getSumForCall();
		
		System.out.println();
		
		gsmOfSpas.printInfoForTheLastIncomingCall();
		gsmOfSpas.printInfoForTheLastOutgoingCall();
		
		System.out.println();
		
		gsmOfVladi.printInfoForTheLastIncomingCall();
		gsmOfVladi.printInfoForTheLastOutgoingCall();
		
		System.out.println();
		gsmOfTodor.printInfoForTheLastIncomingCall();
		gsmOfTodor.printInfoForTheLastOutgoingCall();
		
	}

}
