package threads_part_5_practice_koternik;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Kotarnik {
	
	private BlockingQueue<String> listOfCats = new ArrayBlockingQueue<String>(10);

	public void addCat(String cat) {
		try {
			listOfCats.put(cat);
			System.err.println(listOfCats.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getCat() throws InterruptedException {
		return listOfCats.take();
	}
	
}
