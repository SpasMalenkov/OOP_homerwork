package threads_part_5_practice_shtaiga;
import java.util.Stack;

public class Shtaiga implements IShtaiga {
	private static final double FULLNESS_COEFFICIENT = 0.725;
	private static final double EMPTYNESS_COEFFICIENT = 0.1f;
	private static final int MAX_CAPACITY_OF_SHTAIGA = 10;
	
	private Stack<String> fruits = new Stack<String>();
	
	/* (non-Javadoc)
	 * @see IShtaiga#turiFruit(java.lang.String)
	 */
	@Override
	public void turiFruit(String fruit) throws ShtaigaException {
		if (fruit == null || fruit.equals(""))
			throw new ShtaigaException("Kyv e toq plod be galmak?");
		synchronized (fruits) {
			fruits.push(fruit);
		}
	}
	
	/* (non-Javadoc)
	 * @see IShtaiga#vzemiFruit()
	 */
	@Override
	public String vzemiFruit() throws ShtaigaException {
		synchronized (fruits) {
			if (fruits.isEmpty())
				throw new ShtaigaException("Mi to nqma nishto tuka ve prostak!");
			
			return fruits.pop();
		}
	}
	
	/* (non-Javadoc)
	 * @see IShtaiga#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return fruits.isEmpty();
	}
	
	/* (non-Javadoc)
	 * @see IShtaiga#isFull()
	 */
	@Override
	public boolean isFull() {
		return fruits.size() >= MAX_CAPACITY_OF_SHTAIGA;
	}
	
	
	public boolean daliSePonapylni() {
		return fruits.size() >= (int)(MAX_CAPACITY_OF_SHTAIGA * FULLNESS_COEFFICIENT);
	}
	
	public boolean daliSePoizprazni() {
		return fruits.size() <= (int)(MAX_CAPACITY_OF_SHTAIGA * EMPTYNESS_COEFFICIENT);
	}
	
}
