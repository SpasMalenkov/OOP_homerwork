package warehouse;

public class Product {
	
	private final String name;
	private final FoodProduct type;
	
	public Product(String name, FoodProduct type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}
	
}