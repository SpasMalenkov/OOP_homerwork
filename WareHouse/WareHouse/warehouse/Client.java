package warehouse;

public class Client implements Runnable{
	
	private IShoppingCenter shop;
	
	Client(IShoppingCenter shop){
		this.shop = shop;
	}
	
	@Override
	public void run() {
		
	}

}
