package linkedList;

public class LinkedList {
	
	private static int counter;
	private Node head;
	
	//defaulten konstruktor
	public LinkedList(){
		
	}
	
	//dobavq posochenia element v kraq na tozi spisuk
	public void add(Object data){
		//inicializirane na nishka samo v sluchai na purvi element
		if(head == null){
			this.head = new Node(data);
		}
		Node temp = new Node(data);
		Node currentNode = head;
		//proverka predi da se obhodi nastoqshtata nishka(currentNode)
		if(currentNode != null){
			//zapochvaiki ot glavnia vuzel, pulzi kum kraq na spisyka i sled tova se dobavq element sled posledniq vyzel
			while(currentNode.getNext() != null){
				currentNode = currentNode.getNext();
			}
			//referenciata "next" na posledniq vuzel se nastroiva da sochi poslednia nov vuzel
			currentNode.setNext(temp);
		}
		//narastvane na broq na elementite
		incrementCounter();
	}
	
	private static int getCounter(){
		return counter;
	}
	private static void incrementCounter(){
		counter++;
	}
	private void decrementCounter(){
		counter--;
	}
	
	//vmukva opredelent element na suotvetnata pozicia v tozi spisuk
	public void add(Object data, int index){
		Node temp = new Node(data);
		Node currentNode = head;
		//proverka predi da se obhodi nastoqshtata nishka(currentNode)
		if(currentNode != null){
			//otiva do iskania indeks ili do poslednia element v spisuka
			for(int i = 1; i < index && currentNode.getNext() != null; i++){
				currentNode = currentNode.getNext();
			}
		}
		//zadavane na referencia kum novia vuzel na nastoqshtia element
		temp.setNext(currentNode.getNext());
		//zadavane na referencia na novia vuzel
		currentNode.setNext(temp);
		//narastvane na broq na elementite
		incrementCounter();
	}
	
	//vrushtane na element po zadadena pozicia
	public Object get(int index){
		//indeksa trqbva da bude 1 ili po golqm ot 1
		if(index <= 0){
			return null;
		}
		Node currentNode = null;
		if(head != null){
			currentNode = head.getNext();
			for(int i = 0; i < index; i++){
				if(currentNode.getNext() == null){
					return null;
				}
				currentNode = currentNode.getNext();
			}
			return currentNode.getData();
		}
		return currentNode;
	}
	
	//premahvane na element po zadadena pozicia v list-a
	public boolean remove(int index){
		//ako indeksa e izvun ot goleminata na spisuka
		if(index < 1 || index > size()){
			return false;
		}
		Node currentNode = head;
		if(head != null){
			for(int i = 0; i < index; i++){
				if(currentNode.getNext() == null){
					return false;
				}
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(currentNode.getNext().getNext());
			//namalqva broq na elementite v lista
			decrementCounter();
			return true;
		}
		return false;
	}
	
	//vrushta goleminata na spisuka
	public int size(){
		return getCounter();
	}
	
	public String toString(){
		String output = "";
		if(head != null){
			Node currentNode = head.getNext();
			while(currentNode != null){
				//dobavqm vseki element v string output
				output += "[" + currentNode.getData().toString() + "]";
				currentNode = currentNode.getNext();
			}
		}
		return output;
	}
	
	private class Node{
		Node next;//referencia kum sledvashtata nishka vuv verigata ili null ako nqma takava referencia
		Object data;//danni sudurjashte se v tazi nishka. moje da sa ot vsqkakuv tip
		//konstruktor
		public Node(Object dataValue) {
			next = null;
			data = dataValue;
		}
		public Object getData(){
			return data;
		}
		public void setData(Object dataValue){
			this.data = dataValue;
		}
		public Node getNext(){
			return next;
		}
		public void setNext(Node nextValue){
			this.next = nextValue;
		}
	}
}