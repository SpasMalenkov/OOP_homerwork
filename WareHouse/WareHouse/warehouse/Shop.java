package warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Shop implements Runnable, IShoppingCenter{
	
	private static final int HOW_MUCH_TO_REFILL = 15;
	private static final int MIN_QUANTITY = 5;
	
	private Thread supplier;
	private IShoppingCenter warehouse;
	
	private Map<Product, Integer> products = new ConcurrentHashMap<Product, Integer>();
	
	Shop(IShoppingCenter warehouse, Thread supplier){
		this.warehouse = warehouse;
		this.supplier = supplier;
	}
	
	@Override
	public void addProduct(Product product, int quantity) throws WareHouseException{
		synchronized(product){
			if(product != null && quantity > 0 && products.containsKey(product)){
				int newQuantity = products.get(product);
				newQuantity += quantity;
				products.put(product, newQuantity);
			}else{
				throw new WareHouseException("Can't accept that product.");
			}
		}
	}
	
	@Override
	public void sellProduct(Product product, int quantity) throws WareHouseException{
		this.addProduct(product, -quantity);
	}
	
	@Override
	public List<Product> getQuantityIsLow(){
		List<Product> lowQuantityProducts = new ArrayList<Product>();
		for(Product product :products.keySet()){
			if(products.get(product) < MIN_QUANTITY){
				lowQuantityProducts.add(product);
			}
		}
		return lowQuantityProducts;
	}
	
	public boolean needNewSupplies(){
		return !getQuantityIsLow().isEmpty();
	}
	
	@Override
	public void run() {
		while(supplier.isAlive() || !this.needNewSupplies()){
			while(this.needNewSupplies()){
				System.out.println("Shte pochakam sklada da si zaredi produkti.");
				synchronized(warehouse){
					try{
						warehouse.wait();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
			
			try{
				Thread.sleep(100);
				
				synchronized(warehouse){
					List<Product> products = this.getQuantityIsLow();
					if(products.size() > 0){
						for(Product product : products){
							try{
								System.out.println("Shte zaredq produkti.");
								warehouse.sellProduct(product, HOW_MUCH_TO_REFILL);
								this.addProduct(product, HOW_MUCH_TO_REFILL);
								warehouse.notifyAll();
							}catch(WareHouseException e){
								e.printStackTrace();
							}
						}
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}	
}
