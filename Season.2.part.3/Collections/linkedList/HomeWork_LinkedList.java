package linkedList;

public class HomeWork_LinkedList {
	
	public static void main(String[] args) {
		
		LinkedList linkedList = new LinkedList();
		
		linkedList.add("1");
		linkedList.add("2");
		linkedList.add("3");
		linkedList.add("4");
		linkedList.add("5");
		
		System.out.println("Printirame linkedList: " + linkedList.toString());
		System.out.println("Golemina: " + linkedList.size());
		System.out.println("Element nomer 3: " + linkedList.get(3));
		System.out.println("Premahvame element nomer 2: " + linkedList.remove(2));
		System.out.println("Element nomer 3: " + linkedList.get(3));
		System.out.println("Golemina: " + linkedList.size());
		System.out.println("Pirntirame otnovo linkedList: " + linkedList.toString());
		
	}
	
}