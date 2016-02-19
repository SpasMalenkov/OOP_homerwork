package threads_part_1;

public class Umirasht implements Runnable {

	@Override
	public void run() {
		System.out.println("Pochvam da umiram.");
		for (int procentKolkoEUmrql = 1; procentKolkoEUmrql <= 100; procentKolkoEUmrql++) {
			try {
				Thread.sleep(34);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("V momenta sym umrql na tolkova hp : " + (100-procentKolkoEUmrql));
		}
		System.out.println("Hvyrlih topa.Ae chao.");
	}

}
