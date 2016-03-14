package smartCourier;

import java.util.List;

public class Transporter extends Citizen {

	private Office office;
	private List<Parcel> parcelForTransport;
	private MainOffice mainOffice;

	public Transporter(String name, String gsm, String personalNumber, Adress adress) {
		super(name, gsm, personalNumber, adress);
		Thread.currentThread().setDaemon(true);

	}

	public MainOffice getMainOffice() {
		return mainOffice;
	}

	@Override
	public void run() {

		while (true) {
			
			// while (getProtocols() < 0) {
			// synchronized (office) {
			// office.wait();
			// }
			//
			// }

			System.out.println("Abe are my gi dokaram teq pratki na teq ot veliko tarnovo da gi eba......");

			for (Office office : getOffices()) {
				parcelForTransport.addAll(office.getParcelForMainOffice());

			}

			try {
				System.out.println("Pochvam da si karam kam veliKOtyrnovo sybrah pratkite na teq potki");
				Thread.sleep(10000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			System.out.println("are shte im dam teq pratki be da gi ebaaa");

			for (Parcel p : parcelForTransport) {
				getMainOffice().addParcelToWorkerProtocol(p);
				try {
					getMainOffice().takeParcel(p);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

	}
}
