package warehouse;

public interface IShoppingCenter {

	void addProduct(Product product, int quantity) throws WareHouseException;

	void sellProduct(Product product, int quantity) throws WareHouseException;

}