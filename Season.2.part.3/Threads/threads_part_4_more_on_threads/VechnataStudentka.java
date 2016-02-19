package threads_part_4_more_on_threads;

public class VechnataStudentka implements Runnable{

	volatile boolean jivaLiSym = true;
	
	@Override
	public void run() {
		while (jivaLiSym) {
			System.out.println("Shte piq i ne shte ucha i hvyrlqm salfekti i sveta ");
		}
	}

	
}
