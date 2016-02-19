package warehouse;

import java.util.List;

public class Shop  extends ShoppingCenter implements Runnable{
	
	private static final int HOW_MUCH_TO_REFILL = 15;
	private WareHouse warehouse;
	
	public Shop(WareHouse warehouse) {
		super();
		this.warehouse = warehouse;
	}
	
	@Override
	public void run() {
		
		while(true){
			List<Product> products = getIsQuantityLow();
			if(products.size() > 0){
				for(Product product : products){
					try {
						warehouse.sellProduct(product, HOW_MUCH_TO_REFILL);
						this.addProduct(product, HOW_MUCH_TO_REFILL);
					} catch (WareHouseException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	
}
