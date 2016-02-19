package threads_part_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoKone {
	private static final int NUMBER_OF_HORSES = 10;

	public static void main(String[] args) {
		List<Thread> kone = new ArrayList<Thread>();
		ThreadGroup koneGroup = new ThreadGroup("Chiftokopitni bozainici i ne sa kuci.");
		
		NqkvaOtrepkaBookmaker b = new NqkvaOtrepkaBookmaker();
		NqkvaOtrepkaBookmaker.grupaNaKone = koneGroup;
		
		

		for (int kon = 1; kon <= NUMBER_OF_HORSES; kon++) {
			
			kone.add(new Thread(koneGroup, new Kon(), "Kon nomer " + kon));
			if (kon % 2 == 0)
				kone.add(new Thread(new KucKon(), "Kuc kon nomer " + kon));
		}
		
		Thread otrepkaNishka = new Thread(b);
		otrepkaNishka.setDaemon(true);
		otrepkaNishka.start();

		Collections.shuffle(kone);

		kone.forEach(kon -> kon.start());
	}
}
