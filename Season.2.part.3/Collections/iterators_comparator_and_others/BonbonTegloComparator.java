package iterators_comparator_and_others;

import java.util.Comparator;

public class BonbonTegloComparator implements Comparator<Bonbon>{

	@Override
	public int compare(Bonbon o1, Bonbon o2) {
		if (o1.teglo > o2.teglo) {
			return 1;
		}
		if (o1.teglo < o2.teglo) {
			return -1;
		}

		return 0;
	}

}
