package threads_part_2;

public class DemoJoin {
	public static void main(String[] args) {
		Thread umirashtThread = new Thread(new Umirasht());
		Grobar bezimenenGrobar = new Grobar();
		bezimenenGrobar.setPytnik(umirashtThread);
		
		new Thread(bezimenenGrobar).start();
		umirashtThread.start();
		
	}
}
