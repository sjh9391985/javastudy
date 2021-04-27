package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {

		System.out.println("수를 결정하였습니다. 맞추어 보세요.");
		Scanner scanner = new Scanner(System.in);

		/* 게임 작성 */

		// 정답 램덤하게 만들기
		Random random = new Random();
		int correctNumber = random.nextInt(100) + 1;
		System.out.println(correctNumber);

		while (true) {
			for(int i=1; i<10; i++) {
			System.out.println(" 범위설정부분 ");
			System.out.print(i+">>");
			int n = scanner.nextInt();
			if (n < correctNumber) {

				System.out.println("더 높게");
			}
			else if (n > correctNumber) {
				System.out.println("더 낮게");
			} 
			else if(n == correctNumber) {
				System.out.println("찾았습니다.");
				break;
			}
			}

			// 새 게임 여부 확인하기
			System.out.print("다시 하겠습니까(y/n)>>");
			String answer = scanner.next();
			if ("y".equals(answer) == false) {
				break;
			}

		}

		scanner.close();
	}

}