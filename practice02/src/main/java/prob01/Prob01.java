package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		
		System.out.print("금액: ");
		
		int change = scanner.nextInt();

	
		
		
		
		int c50000,c10000,c5000,c1000,c500,c100,c50,c10,c5,c1;
		
		c50000=change/50000;
		change=change%50000;
		c10000=change/10000;
		change=change%10000;
		c5000=change/5000;
		change=change%5000;
		c1000=change/1000;
		change=change%1000;
		c500=change/500;
		change=change%500;
		c100=change/100;
		change=change%100;
		c50=change/50;
		change=change%50;
		c10=change/10;
		change=change%10;
		c5=change/5;
		change=change%5;
		c1=change/1;
		change=change%1;
		
		System.out.println();
		System.out.printf("50000원 짜리 %d개\n",c50000);
		System.out.printf("10000원 짜리 %d개\n",c10000);
		System.out.printf("5000원 짜리 %d개\n",c5000);
		System.out.printf("1000원 짜리 %d개\n",c1000);
		System.out.printf("500원 짜리 %d개\n",c500);
		System.out.printf("100원 짜리 %d개\n",c100);
		System.out.printf("50원 짜리 %d개\n",c50);
		System.out.printf("10원 짜리 %d개\n",c10);
		System.out.printf("5원 짜리 %d개\n",c5);
		System.out.printf("1원 짜리 %d개\n",c1);
		
		
		
		scanner.close();
 	}
}