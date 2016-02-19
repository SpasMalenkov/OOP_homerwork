package warehouse;

import java.util.List;

public interface IShoppingCenter{

	void addProduct(Product product, int quantity) throws WareHouseException, ShopException;

	List<Product> getQuantityIsLow();

	void sellProduct(Product product, int quantity) throws WareHouseException, ShopException;

}