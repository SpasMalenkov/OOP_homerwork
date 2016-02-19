package warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ShoppingCenter implements IShoppingCenter{
	
	private static final int STARTING_CAPACITY = 15;
	private static final int MIN_CAPACITY = 10;
	
	private Map<Product, Integer> products = new ConcurrentHashMap<Product, Integer>();
	
	
	public ShoppingCenter() {
		
		for(String productName : new String[]{"Banan", "Orange", "Apple"}){
			products.put(new Product(productName, FoodProduct.FRUITS), STARTING_CAPACITY);
		}
		for(String productName : new String[]{"Potato", "Eggplant","Cucumber"}){
			products.put(new Product(productName, FoodProduct.VEGETABLES), STARTING_CAPACITY);
		}
		
		for(String productName : new String[]{"Pork", "Beef","Chicken"}){
			products.put(new Product(productName, FoodProduct.MEATS), STARTING_CAPACITY);
		}
	}

	@Override
	public void addProduct(Product product, int quantity) throws WareHouseException{
		
		if(product != null && quantity > 0 && products.containsKey(product)){
			int amount = products.get(product);
			amount += quantity;
			products.put(product, amount);
		}else{
			throw new WareHouseException("Can't axcept that product.");
		}
	}
	
	@Override
	public void sellProduct(Product product, int quantity) throws WareHouseException{
		this.addProduct(product, -quantity);
	}
	
	public List<Product> getIsQuantityLow(){
		
		List<Product> lowQuantityProducts = new ArrayList<Product>();
		
		for(Product product : products.keySet()){
			if(products.get(product) < MIN_CAPACITY){
				lowQuantityProducts.add(product);
			}
		}
		
		return lowQuantityProducts;
	}
}
