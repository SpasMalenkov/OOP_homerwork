package counting_letters_finished;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;


public class CountingLetters {
	
	//dve konstanti za da nqmam magicheski chisla
	private static final double MAX_NUMBER = 20;
	private static final int NUMBER_ONE = 1;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String sentence = sc.nextLine();
		
		String[] text = sentence.toString().trim().toUpperCase().replaceAll("[^A-Z]", "").split("");
		
		//suzdavam si hashmap
		Map<String, Integer> mapText = new HashMap<String, Integer>();
		
		//pulnq mapa
		for(String someString : text){
			if(!mapText.containsKey(someString)){
				mapText.put(someString, NUMBER_ONE);
			}else{
				mapText.put(someString, mapText.get(someString) + NUMBER_ONE);
			}
		}
		
		LinkedList<String> letters = new LinkedList<String>();
		
		letters.addAll(mapText.keySet());
		
		//sortiram lista, kolkoto i glupavo da izglejda
		//znam che linked list se sortira nai-burzo s merge sort
		//ama nqma da zadulbavam
		Collections.sort(letters, (l1, l2) -> (mapText.get(l2) - mapText.get(l1)));
		
		//vzimam maximalna stoinost ravna na nai-chestoto sreshtane na bukva
		double max = mapText.get(letters.getFirst());
		
		//printiram bukvite s tqhnata chestota na sreshtane
		for(String someString : letters){
			
			System.out.print(someString + ": "+ mapText.get(someString) + " ");
			mostCommonLetters(mapText.get(someString)/max);
			
		}
		
	}
	//metod za printirane na simvolite za chestota
	public static void mostCommonLetters(double coefficient){
		for(int index = 0; index < coefficient * MAX_NUMBER; index++){
			System.out.print('#');
		}
		System.out.println();
	}

}
