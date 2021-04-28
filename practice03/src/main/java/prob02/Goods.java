package prob02;

public class Goods {
	private String beverage;
	private int price;
	private int count;
	
	public Goods(String beverage, int price, int count) {
		this.beverage = beverage;
		this.price = price;
		this.count = count;
	}

	public String getBeverage() {
		return beverage;
	}

	public void setBeverage(String beverage) {
		this.beverage = beverage;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
