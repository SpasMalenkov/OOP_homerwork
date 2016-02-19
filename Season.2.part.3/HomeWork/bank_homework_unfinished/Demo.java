package bank_homework_unfinished;

import java.util.ArrayList;

import org.omg.Messaging.SyncScopeHelper;

public class Demo {

	public static void main(String[] args) {
		
		IBank unicredit = new Bank("Unicredit Bulgaria", "pl.\"St.Nedelya\" ¹7", 30000000);
		
		Deposit shortDeposit = new Deposit("3 months deposit", 0.15, 200 , 3);
		Deposit longDeposit = new Deposit("12 months deposit", 3.00, 5000, 12);
		
		Credit shortCredit = new Credit("12 months credit", 9.75, 4000, 12);
		Credit longCredit = new Credit("24 months credit", 10.50, 10000, 12);
		
		//demoto mi gurmi qko i ne iskah da precakvam rabotata shte se opitam da predam do petuk hubavo demo
		//preraboteno nanovo, grozna rabota kato cqlo
		
		Client[] clients = new Client[10];
		for (int i = 0; i < clients.length; i++) {
			int temp = (int) (Math.random() * 3 + 8);
			clients[i] = new Client("client" + (i + 1), "Address" + (i + 1), 20000, 10000);
			if (temp > 9) {// 9 is randomly chosen by me
				try {
					clients[i].createDeposit(unicredit, longDeposit.copyProduct());
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			} else {
				try {
					clients[i].createDeposit(unicredit, shortDeposit.copyProduct());
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		for (int i = 0; i < clients.length; i++) {
			int temp = (int) (Math.random() * 2);
			try {
				clients[i].createCredit(unicredit, shortCredit.copyProduct());

				if (temp == 0) {
					clients[i].createCredit(unicredit, longCredit.copyProduct());
				} else {
					clients[i].createCredit(unicredit, shortCredit.copyProduct());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println(unicredit.toString());
	}
}
