package library;

import java.util.Comparator;

public class TextBook extends ReadingMaterial {
	
	private static final double TAX_TO_PAY = 3.0;
	private static final int TIME_TO_BE_TAKEN = 1500;
	private String author;
	
	public TextBook(String name, String publisher, String author) {
		super(name, publisher);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "TextBook [author=" + author + ", getName()=" + getName() + ", getPublisher()=" + getPublisher() + "]";
	}
	
	@Override
	public int getSecondsForTake(){
		return TIME_TO_BE_TAKEN;
	}
	
	@Override
	public Comparator getComparator(){
		return new TextBookComparator();
	}

	@Override
	public Double getPrice() {
		return TAX_TO_PAY;
	}
}
