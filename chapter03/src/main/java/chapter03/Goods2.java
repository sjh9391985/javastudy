package chapter03;

public class Goods2 {

	private int price;
	private String name;
	private int countSold;
	private int countStock;
	
	public Goods2(String name, int price, int countSold, int countStock) {
		this.name = name;
		this.price = price;
		this.countSold = countSold;
		this.countStock = countStock;
	}
	
	public Goods2() {
		
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {

		if (price < 0) {
			// this.price 로 작성해도 상관없음.
			price = 0;
			System.out.println("price를 다시 입력하십시오.");
		}
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public void showInfo() {
		System.out.println("name: " + name + "," + "price: " + price + "," + " countSold: " + countSold + ","
				+ "countStock: " + countStock);
	}
	
	
	
	public int calcDiscount(double rate) {	
		int discountPrice = (int)(price * rate);
		return discountPrice;
	}

}
