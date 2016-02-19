package iterators_comparator_and_others;

public class Bonbon {
	String color;
	String taste;
	double teglo;
	
	public Bonbon(String color, String taste, double teglo) {
		this.color = color;
		this.taste = taste;
		this.teglo = teglo;
	}
	

	@Override
	public String toString() {
		return "Bonbon [color=" + color + ", taste=" + taste + ", teglo=" + teglo + "]";
	}


//	@Override
//	public int compareTo(Bonbon otherBonbon) {
//		if (teglo > otherBonbon.teglo) {
//			return 1;
//		}
//		if (teglo < otherBonbon.teglo) {
//			return -1;
//		}
//		
//		return this.color.compareTo(otherBonbon.color);
//	}
	
	
}
