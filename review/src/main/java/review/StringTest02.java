package review;

public class StringTest02 {

	public static void main(String[] args) {
		
		String a = new String("  abcd");
		String b = new String("  ,efg ");
		
		a = a.concat(b); //문자열 연결
		System.out.println(a);
		
		a = a.trim();
		System.out.println( "--" + a + "--" );
		
		a = a.replaceAll("ab", "12");
		System.out.println(a);
		
		String[] s =  a.split(","); //문자열 분리
		for(int i=0;i<s.length; i++) {
			System.out.println(s[i]);
		}
		
		a = a.substring(3); //n번부터 끝까지 가져오기
		System.out.println(a);
		
		char c = a.charAt(4); //n번 가져오기
		System.out.println(c);
		
		
	}

}
