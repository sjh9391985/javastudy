package chapter04;

public class StringTest02 {
	public static void main(String[] args) {

//		// imutability(불변성)
//		String s1 = "hello";
//
//		String s2 = s1.toUpperCase();
//		System.out.println(s2);

		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;

		s2 = s1.toUpperCase();
		String s4 = s2.concat("??");
		String s5 = "!".concat(s2).concat("@");

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		System.out.println("============================");

		/* equals 사용시 주의할 점 */
		System.out.println(equalsHello(null));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

	}

	private static boolean equalsHello(String s) {
		return "Hello".equals(s);
	}
}
