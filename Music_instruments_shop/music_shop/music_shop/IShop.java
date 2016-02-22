package music_shop;

public interface IShop {

	void sellInstrument(Instrument instrument, int quantity, int money) throws ShopException;

	void addInstrument(Instrument instrument, int quantity) throws ShopException;

	void sortedByType();

	void sortedByName();

	void sortedByPrice();

	void availableInstruments();

}