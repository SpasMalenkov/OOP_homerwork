package warehouse;

import java.util.List;

public class WareHouse extends ShoppingCenter{
	
	boolean needToRefill(){
		return !getIsQuantityLow().isEmpty();
	}
	
}
