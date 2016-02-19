package warehouse;

public abstract class Product implements Runnable{
	
	protected String name;
	protected IWareHouse sklad;
	
	Product(String name, IWareHouse sklad) throws ProductException{
		this.setProductName(name);
		this.sklad = sklad;
	}
	
	public String getProductName(){
		return this.name;
	}
	
	public int getTimeToProduce() {
		return 100;
	}
	
	public void setProductName(String name) throws ProductException{
		if(name == null && name.equals("")){
			throw new ProductException("Nqma takuv product.");
		}else{
			this.name = name;
		}
	}
	
	
}
