package exception;


/**
 * 
 * @author BIT
 * try~catch~finally 구문 만들기 연습
 */
public class ExceptionTest {

	public static void main(String[] args) {

		int a = 10;
		int b = 10 - a;

		System.out.println("some codes...1");

		try {
			System.out.println("some codes...2");

			int result = (1 + 2 + 3) / b;

			/* 위의 코드로 예외가 발생한 시점. */
			System.out.println("some codes...3");

		} catch (ArithmeticException e) {
			/* 예외 처리 */

			// 1. 프로그램을 쓰는 사용자에게 사과를 해야한다. (프로그램 에러의 사유)
			System.out.println("미안합니다...");

			// 2. 로깅
			System.out.println("Error 는 [ " + e +" ] 입니다.");

			// 3. 정상 종료
			// System.exit(0);
			return;
		} finally {
			// finally는 예외가 발생해도 실행, 발생하지 않아도 실행.
			// 자원 정리를 하는데 사용
			System.out.println("some codes...final(자원정리)");

		}

		System.out.println("some codes...5");
	}

}
