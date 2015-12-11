package homework_gsm;

public class GSM {
	
	String model;
	boolean hasSimCard;
	String simMobileNumber;
	int outgoingCallsDuration;
	String lastIncomingCall;
	String lastOutgoingCall;
	
	
	void insertSimCard(String simMobileNumber){
		
		if(simMobileNumber.charAt(0) == '0' && simMobileNumber.charAt(1) == '8' && simMobileNumber.length() == 10){
			
			for(int i = 2; i < simMobileNumber.length(); i++){
				
				if(simMobileNumber.charAt(i) > '0' || simMobileNumber.charAt(i) < '9'){
					
					this.hasSimCard = true;
					this.simMobileNumber = simMobileNumber;
					
				}else{
					
					this.hasSimCard = false;
					System.out.println("There is no sim card inserted.");
					
				}
			}
			
		}else{
			
			this.hasSimCard = false;
			System.out.println("There is no sim card inserted.");
			
		}
	}
	
	void removeSimCard(){
		
		if(this.hasSimCard == true && this.simMobileNumber != ""){
			
			this.hasSimCard = false;
			this.simMobileNumber = "";
			
		}
		
	}
	
	void call(GSM receiver, int duration){
		
		if((duration <= 0) && (this.simMobileNumber == receiver.simMobileNumber) && (this.hasSimCard == false || receiver.hasSimCard == false)){
			
			System.out.println("You didn't make the call!");
			
		}else{
					
			this.lastOutgoingCall = receiver.simMobileNumber; 
			receiver.lastIncomingCall = this.simMobileNumber;
			this.outgoingCallsDuration += duration;
			
		}
	}
	
	void getSumForCall(){
		
		double sumForCall = this.outgoingCallsDuration * Call.priceForAMinute;
		System.out.println(sumForCall);
		
	}
	
	//tuk ima oshte kakv da se izdokusorqva
	void printInfoForTheLastOutgoingCall(){
		
		if(this.lastOutgoingCall != null){
			
			System.out.println("The last outgoing call was to " + lastOutgoingCall);
			
		}else{
			
			System.out.println("There are no outcoming calls.");
			
		}
	}
	
	void printInfoForTheLastIncomingCall(){
		
		if(this.lastIncomingCall != null){
			
			System.out.println("The last incoming call was from " + lastIncomingCall);
			
		}else{
			
			System.out.println("There are no incoming calls.");
			
		}
	}
	
}
