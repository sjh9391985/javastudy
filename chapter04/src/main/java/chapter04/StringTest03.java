package chapter04;

public class StringTest03 {

	public static void main(String[] args) {

		String s = "aBcABCabcABC";
		System.out.println(s.length());

		System.out.println(s.charAt(2));

		System.out.println(s.indexOf("abc"));
		System.out.println(s.indexOf("abc", 3));
		System.out.println(s.substring(3));
		System.out.println(s.substring(3, 5));

		String s2 = " 	ab		cd	";
		String s3 = "efg,hijk,lmn,opqr";

		String s4 = s2.concat(s3);
		System.out.println(s4);
		System.out.println(s2.trim());

		System.out.println(s2.replaceAll("		", ""));

		// 정규표현식 사용 예시
		String price = "1000ㅁ";

		// 양수만 표현한 정규표현식
		if (price.matches("\\d+")) {
			int price2 = Integer.parseInt(price);
			System.out.println(price2);

		} else {
			System.out.println("유효한 금액이 아닙니다.");
		}

		String[] tokens = s3.split(",");

		for (String k : tokens) {
			System.out.println(tokens);

		}

		for (int i = 0; i < tokens.length; i++) {
			System.out.println(tokens[i]);
		}

		StringBuffer sb = new StringBuffer("");

		sb.append("Hello ");
		sb.append("World ");
		sb.append("Java ");
		sb.append(1.8);

		String s12 = sb.toString();
		System.out.println(s12);
		
		
		//String s6 = "Hello "+ "World "+ "Java "+1.8;
		// method 를 연달아서 쓰는 method chainning
		String s6 = new StringBuffer("Hello ").append("World ").toString();
		System.out.println(s6);
		
		// 주의: + 문자열 + 연산을 하지 말아햐 알 때
//		String s7 = "";
//		for(int i=0; i<10000; i++) {
//			//s7 += i;
//			s7 = new StringBuffer(s7).append(i).toString();
//		}
		
		StringBuffer sb3 = new StringBuffer("");

		for(int i = 0; i< 100000; i++) {
			sb3.append(i);
		}
		
		String s7 = sb3.toString();
		
	}
}
