package warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WareHouse implements IShoppingCenter {
	private static final int STARTING_QUANTITY = 15;
	private static final int MIN_QUANTITY = 10;
	
	private Map<Product, Integer> products = new ConcurrentHashMap<Product, Integer>();
	
	public WareHouse() {
		for(String productName : new String[]{"banan", "orange", "apple"}){
			products.put(new Product(productName, FoodProduct.FRUITS), STARTING_QUANTITY);
		}
		for(String productName : new String[]{"potato", "eggplant","cucumber"}){
			products.put(new Product(productName, FoodProduct.VEGETABLES), STARTING_QUANTITY);
		}
		
		for(String productName : new String[]{"pork", "beef","chicken"}){
			products.put(new Product(productName, FoodProduct.MEATS), STARTING_QUANTITY);
		}
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
	
//	public boolean needNewSupplies(){
//		return !getQuantityIsLow().isEmpty();
//	}
//	
//	public boolean doNotNeedNewSupplies(){
//		return getQuantityIsLow().isEmpty();
//	}

}
