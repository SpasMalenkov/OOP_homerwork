package threads_part_5_practice_koternik;

public class Demo {
	static int i=0;
	
	public static void main(String[] args) {
		Kotarnik cotton = new Kotarnik();
		
		for ( i = 1; i <= 100; i++) {
			new Thread(() -> {
				cotton.addCat("Kotka nomer " + i);
				System.out.println(Thread.currentThread().getName() + " Vmykanh si kote");
			}).start();
		}
		for ( i = 1; i <= 100; i++) {
			new Thread(() -> {
				try {
					System.out.println(Thread.currentThread().getName() + " Shte si izkaram slednoto : " + cotton.getCat());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		}
		
	}
}
