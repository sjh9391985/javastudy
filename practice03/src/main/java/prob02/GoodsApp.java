package prob02;

import java.util.Scanner;

public class GoodsApp {

	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];
		
		System.out.println("실행결과: ");
		
		for(int i=0; i<goods.length; i++) {
			String beverage = scanner.next();
			int price = scanner.nextInt();
			int count = scanner.nextInt();
			
			goods[i] = new Goods(beverage, price, count);
		}
		
		for(int i=0; i< goods.length; i++) {
			System.out.println(goods[i].getBeverage()+"(가격:"+goods[i].getPrice() + "원)이 "+goods[i].getCount()+"개 입고 되었습니다.");
		}
		// 상품 입력

		// 상품 출
		
		// 자원정리
		scanner.close();
	}
}
