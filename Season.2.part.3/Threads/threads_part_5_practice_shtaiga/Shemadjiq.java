package threads_part_5_practice_shtaiga;

public class Shemadjiq implements Runnable {

	private IShtaiga myShtaiga;
	private Thread mySelyanin;
	
	public Shemadjiq(IShtaiga shtaiga, Thread selyanin) {
		myShtaiga = shtaiga;
		mySelyanin = selyanin;
	}
	
	@Override
	public void run() {
		while (mySelyanin.isAlive() || !myShtaiga.isEmpty()) {
			while (myShtaiga.isEmpty()) {
				System.out.println(Thread.currentThread().getName() + " Az sym shemadjiq i shte si pochakam!");
				synchronized (myShtaiga) {
					try {
						myShtaiga.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			try {
				Thread.sleep(10);
				
				synchronized (myShtaiga) {
					if (!myShtaiga.isEmpty())
						System.out.println(Thread.currentThread().getName() + " Ei sega izlapah ei tova : " + myShtaiga.vzemiFruit());
					if (myShtaiga.daliSePoizprazni()) {
						System.out.println(Thread.currentThread().getName() + " Az sym shemadjiq i shte go vikna onq selqk da proizvede neshto!");
						myShtaiga.notifyAll();
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
