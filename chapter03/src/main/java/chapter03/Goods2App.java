package chapter03;

public class Goods2App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Goods2 good2 = new Goods2();
		good2.setName("Nikon");
		good2.setPrice(10000);
		good2.setCountSold(20);
		good2.setCountStock(30);

		good2.setPrice(-1);
		good2.showInfo();
	}

}
