package prob02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[ 5 ];
		double sum = 0;
		
		System.out.println("5개의 숫자를 입력하세요.");
		Scanner sc = new Scanner(System.in);
	
		for(int i=0; i < intArray.length; i++) {
			intArray[i] = sc.nextInt();
			sum += intArray[i];
		}
		
		System.out.println("평균은 " + sum/5 +" 입니다.");
		
		scanner.close();
	}
}
