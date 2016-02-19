package collections_part_1;

import java.util.Iterator;
import java.util.TreeSet;

public class Demo2 {
	public static void main(String[] args) {
		Rakia parcuca = new Rakia(20, 100, "slivi");
		System.out.println(parcuca.hashCode());
		
		System.out.println("kaisiq".hashCode());
		
		System.out.println(new Object().hashCode());
		
		TreeSet<String> ukazatel = new TreeSet<String>();
		
		ukazatel.add("Pesho");
		ukazatel.add("Gosho");
		ukazatel.add("Blagoy");
		ukazatel.add("Marko");
		ukazatel.add("Petrina");
		ukazatel.add("Papurka");
		ukazatel.add("Gertruda");
		ukazatel.add("Olga");
		ukazatel.add("Kirka");
		
		ukazatel.remove("Papurka");
		
//		ukazatel.add(null);
		
		System.out.println(ukazatel.contains("Blagoy"));
		
//		for (String name : ukazatel) {
//			System.out.println(name);
//		}
		
		for (Iterator<String> it = ukazatel.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
}	
