package review;

public class StringTest01 {

	public static void main(String[] args) {
		
		String s1 = "hello";
		String s2 = "hello";
		
		String s3 = new String("hello");
		String s4 = new String("hello");
		
		
		System.out.println(s1 == s2); //t
		System.out.println(s3 == s4); //f
		System.out.println(s2 == s4); //f
		
	}

}
