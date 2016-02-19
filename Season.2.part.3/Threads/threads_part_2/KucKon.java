package threads_part_2;

public class KucKon extends Kon {
	
	@Override
	public int getTimeToRunAMeter() {
		return 2*super.getTimeToRunAMeter();
	}
}
