package carpartsshop;

public interface IBuySellMakeParts {
	
	default void buyParts(Company company, int quantity){
	}
	default void sellParts(int quantity){
	}
	default void addCarParts(CarParts carparts){
	}
	default void makeParts(int quantity, int priceSell){
	}
	
	
}
