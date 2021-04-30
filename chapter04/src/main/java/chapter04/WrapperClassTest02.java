package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		
		// 문자열을 정수로
		String s = "123456";
		int i = Integer.parseInt(s);
		
		// cf. 반대로
		// 정수를 문자열으로
		String s1 = String.valueOf(i);

		// cf2 반대로
		String s3 = i + "";
		
		System.out.println(s +" : "+s1 +" : " +s3);
		
		
		int a = Character.getNumericValue('A');
		System.out.println(a);
		
		// 2진수 
		String s4 = Integer.toBinaryString(16);
		System.out.println(s4);
		
		//16진수
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
		
		//8진수
		String s6 = Integer.toOctalString(15);
		System.out.println(s6);
		
		
	}

}
