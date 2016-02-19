package threads_part_4_more_on_threads;

public class PeshoHackera implements Runnable {

	private static final int MONEY_TO_GET = 20;
	private IAccount account;

	public PeshoHackera(IAccount acc) {
		this.account = acc;
	}

	@Override
	public void run() {
		System.out.println("Sega shte probvam da izteglq edni pari.");
		account.withdraw(MONEY_TO_GET);
		System.out.println("Izteglih si gi.Cgao.");
	}

}
