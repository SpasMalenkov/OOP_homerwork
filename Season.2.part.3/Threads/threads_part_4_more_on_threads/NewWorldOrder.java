package threads_part_4_more_on_threads;

import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class NewWorldOrder {
	static AtomicInteger x = new AtomicInteger(5);
	static StringBuffer b= new StringBuffer("");
	
	static AtomicInteger i = new AtomicInteger(0);
	static void changeMyX()  {
		try {
			Thread.sleep((long) (Math.random()*100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.append(x + " ");
		x.incrementAndGet();
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 1; i <= 30; i++)
			new Thread(() -> changeMyX()).start();
		
		for (int j=1; j<=100; j++)
			new Thread(() -> b.append("Vervai te mi " + (i.incrementAndGet()) + " \n ")).start();

		
//		System.out.println(b);
		Thread.currentThread().setPriority(1);
		VechnataStudentka ganaNikolova = new VechnataStudentka();
		Thread t  =new Thread(ganaNikolova);
		t.setPriority(10);
		t.start();
		ganaNikolova.jivaLiSym = false;
		Thread.sleep(3000);
		
		System.out.println(b);
	}
}
