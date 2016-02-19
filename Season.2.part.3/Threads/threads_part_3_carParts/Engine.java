package threads_part_3_carParts;

public class Engine extends CarPart implements Runnable {
	
	public int getTimeToProduce() {
		return 7000;
	}

	public String getPartName() {
		return "dvigatel";
	}
}
