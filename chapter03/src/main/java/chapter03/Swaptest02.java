package chapter03;

public class Swaptest02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10; // 지역 변수들은 jvm에 stack으로 저장
		int b = 20;

		System.out.println(a + " : " + b);
		swap(a, b);
		System.out.println(a + " : " + b);

	}

	public static void swap(int p, int q) {
		int temp = p;
		p = q;
		q = temp;
	}
}