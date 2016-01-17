package carpartsshop;

public interface IRelationshipCarPartsShopCustomer {
	
	default void addCar(Car car){
	}
	default void addCarParts(CarParts carparts){
	}
	default boolean sellParts(CarParts carpart, int quantity){
		return false;
	}
	default void buyParts(CarPartsShop carpartshop, CarParts carpart, int quantity){
	}
}
