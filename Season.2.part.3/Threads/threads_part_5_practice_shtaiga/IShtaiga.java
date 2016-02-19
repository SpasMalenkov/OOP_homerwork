package threads_part_5_practice_shtaiga;

public interface IShtaiga {

	void turiFruit(String fruit) throws ShtaigaException;

	String vzemiFruit() throws ShtaigaException;

	boolean isEmpty();

	boolean isFull();
	

	public boolean daliSePonapylni();
	
	public boolean daliSePoizprazni();

}