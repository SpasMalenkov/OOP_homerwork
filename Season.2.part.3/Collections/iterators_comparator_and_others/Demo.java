package iterators_comparator_and_others;

import java.util.Comparator;
import java.util.TreeSet;


public class Demo {
	public static void main(String[] args) {
//		TreeSet<Bonbon> kutiqBonboniera = new TreeSet<Bonbon>(new BonbonTegloComparator());
//		TreeSet<Bonbon> kutiqBonboniera = new TreeSet<Bonbon>(new Comparator<Bonbon>() {
//
//			@Override
//			public int compare(Bonbon o1, Bonbon o2) {
//				return o1.color.compareTo(o2.color);
//			}
//		});

		TreeSet<Integer> set = new TreeSet<Integer>();
		
		set.add(5);
		set.add(1);
		set.add(4);
		set.add(6);
		
		Integer a  = 5;
		a++;
		Byte b = 45;
		
		set.forEach((x) -> System.out.print(x + " "));;
		
		Integer i = 5;
		int t = new Integer(5) + new Integer("4");
		
		Integer x = 900;
		Integer y = 900;
		
		System.out.println(x.equals(y));
		
		
		System.out.println(t);
		
		int prostInt = i.intValue();
		int j = Integer.parseInt("345");
//		System.out.println(j);
		
//		TreeSet<Bonbon> kutiqBonboniera = new TreeSet<Bonbon>( (o1,o2) -> o1.taste.compareTo(o2.taste));		
//		
//		kutiqBonboniera.add(new Bonbon("bql", "sladyk", 15));
//		kutiqBonboniera.add(new Bonbon("zelen", "chreven balans", 120));
//		kutiqBonboniera.add(new Bonbon("cherven", "diaria", 1));
//		kutiqBonboniera.add(new Bonbon("oranjev", "slivici gorchivi 35 grama", 15));
//		
//		System.out.println(String.format("%.2f %2d Ei ti nadpis", 2.33523, 4 ));
//		
//		for (Bonbon b : kutiqBonboniera) {
//			System.out.println(b);
//		}
		
	}
}
