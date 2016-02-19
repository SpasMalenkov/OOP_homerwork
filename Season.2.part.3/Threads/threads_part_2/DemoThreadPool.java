package threads_part_2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoThreadPool {
	
	static class MyTask implements Callable<String> {

		@Override
		public String call()  {
			System.out.println("Eto rabotq.");
			return "Shte spq i shte appendvam.";
		}
		
	}
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(5);
		
		for (int zadacha=1; zadacha <= 10; zadacha++) {
			pool.submit(new MyTask());
		}
		
		//don't forget that
		pool.shutdown();
	}
}
