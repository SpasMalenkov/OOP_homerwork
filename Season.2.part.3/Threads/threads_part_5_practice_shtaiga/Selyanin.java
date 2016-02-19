package threads_part_5_practice_shtaiga;

public class Selyanin implements Runnable{
	
	private static final int KOLKO_DA_PROIZVEDE = 10;
	private IShtaiga myShtaiga;
	
	public Selyanin(IShtaiga shtaiga) {
		myShtaiga = shtaiga; 				
	}
	
	@Override
	public void run() {
		final String[] fruits = {"qbylki", "nar", "domati", 
				"djanki", "mango", "dyuli", "mushmuli", "galagunki", "slivki", "zarzali"}; 
		for (int count=1; count <= KOLKO_DA_PROIZVEDE && !Thread.currentThread().isInterrupted();) {
			while (myShtaiga.isFull()) {
				System.out.println(Thread.currentThread().getName() + " Az sym selyanin i shtaigata mi e pylna shte si pochakam!!!");
				try {
					synchronized (myShtaiga) {
						myShtaiga.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			}
			
			//shtaigata ne e pylna na tozi red
			for (int i=1; i<=KOLKO_DA_PROIZVEDE; i++) {
				try {
					String fruit = fruits[(int)(Math.random() * fruits.length)];
					myShtaiga.turiFruit(fruit);
					System.out.println(Thread.currentThread().getName() + " Az sym selyanin i shte turna tozi produkt :" + fruit);
					count++;
					
					synchronized (myShtaiga) {
						if (myShtaiga.daliSePonapylni()) {
							System.out.println(Thread.currentThread().getName() + " Az sym selyanin i shte go vikna onq da gi lapa tiq plodove!");
							myShtaiga.notifyAll();
						}
					}
					
				} catch (ShtaigaException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
