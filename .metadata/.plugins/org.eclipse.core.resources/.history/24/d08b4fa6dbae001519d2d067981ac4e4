package homework_gsm;

import java.util.Scanner;

public class GSM_Calls {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		GSM iPhone = new GSM();
		GSM htc = new GSM();
		GSM samsung = new GSM();
		
		iPhone.model = "iPhone";
		htc.model = "HTC";
		samsung.model = "Samsung";
		
		iPhone.insertSimCard("0897505065");
		htc.insertSimCard("0887707070");
		samsung.insertSimCard("0888080808");
		
		iPhone.call(htc, 2);
		iPhone.call(samsung, 7);
		
		samsung.call(iPhone, 1);
		samsung.call(htc, 4);
		samsung.call(iPhone, 6);
		
		htc.call(samsung, 3);
		htc.call(samsung, 5);
		htc.call(iPhone, 8);
		
		iPhone.printInfoForTheLastOutgoingCall();
		iPhone.printInfoForTheLastIncomingCall();
		
		htc.printInfoForTheLastOutgoingCall();
		htc.printInfoForTheLastIncomingCall();
		
		samsung.printInfoForTheLastOutgoingCall();
		samsung.printInfoForTheLastIncomingCall();
		
		System.out.println(iPhone.getSumForCall());
		System.out.println(htc.getSumForCall());
		System.out.println(samsung.getSumForCall());
		
	}

}
