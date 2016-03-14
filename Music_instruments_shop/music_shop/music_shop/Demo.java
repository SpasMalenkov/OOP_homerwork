package music_shop;

public class Demo {

		public static void main(String[] args) {
			IShop shop = new Shop();
			
//			shop.sortedByType();
//			shop.sortedByName();
//			shop.sortedByPrice();
//			shop.availableInstruments();
			
			System.out.println(((Shop) shop).getMoney());
			
			for(int i = 1; i <= 10; i++){
				
				Thread customer = new Thread(new Customer(shop));
				customer.start();
			}
			
		}
}
