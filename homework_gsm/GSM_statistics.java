package homework_gsm;

import java.util.Scanner;

public class GSM_statistics {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		GSM gsmOfSpas = new GSM();
		GSM gsmOfVladi = new GSM();
		
		gsmOfSpas.model = "iPhone 4S";
		gsmOfSpas.hasSimCard = false;
		gsmOfSpas.simMobileNumber = "";
		
		gsmOfVladi.model = "HTC";
		gsmOfVladi.hasSimCard = false;
		gsmOfVladi.simMobileNumber = "";
		
		if(gsmOfSpas.hasSimCard == false && gsmOfSpas.simMobileNumber == ""){
			
			String simMobileCard = sc.nextLine();
			gsmOfSpas.insertSimCard(simMobileCard);
			System.out.println(gsmOfSpas.hasSimCard);
			System.out.println(gsmOfSpas.simMobileNumber);
			
		}else{
			
			System.out.println("iPhone of Spas has inserted card.");
			System.out.println(gsmOfSpas.hasSimCard);
			System.out.println(gsmOfSpas.simMobileNumber);
			
		}
		
		if(gsmOfVladi.hasSimCard == false && gsmOfVladi.simMobileNumber == ""){
			
			String simMobileCard = sc.nextLine();
			gsmOfVladi.insertSimCard(simMobileCard);
			System.out.println(gsmOfVladi.hasSimCard);
			System.out.println(gsmOfVladi.simMobileNumber);
			
		}else{
			
			System.out.println("HTC of Vladi has inserted card.");
			System.out.println(gsmOfVladi.hasSimCard);
			System.out.println(gsmOfVladi.simMobileNumber);
			
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
		
		Call callerSpas = new Call();
		Call callerVladi = new Call();
		
		System.out.println("Who wants to make a call?");
		String makeACall;
		int duration = 0;
		
		do{
			
			makeACall = sc.nextLine();

			if(makeACall.equalsIgnoreCase("spas")){
				
				duration = sc.nextInt();
				callerSpas.duration = duration;
				callerSpas.caller = gsmOfSpas;
				callerSpas.receiver = gsmOfVladi;
				gsmOfSpas.call(callerSpas.receiver, callerSpas.duration);
				
			}
			
			if(makeACall.equalsIgnoreCase("vladi")){
				
				duration = sc.nextInt();
				callerVladi.duration = duration;
				callerVladi.caller = gsmOfVladi;
				callerVladi.receiver = gsmOfSpas;
				gsmOfVladi.call(callerVladi.receiver, callerVladi.duration);
				
			}
			
		}while(duration > 0);
		
		gsmOfSpas.getSumForCall();
		gsmOfVladi.getSumForCall();
		
		System.out.println();
		
		gsmOfSpas.printInfoForTheLastIncomingCall();
		gsmOfSpas.printInfoForTheLastOutgoingCall();
		
		System.out.println();
		
		gsmOfVladi.printInfoForTheLastIncomingCall();
		gsmOfVladi.printInfoForTheLastOutgoingCall();
		
	}

}
