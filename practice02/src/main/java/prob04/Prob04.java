package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	
	
	
	public static char[] reverse(String str) {
		
		StringBuffer sb = new StringBuffer(str);
		String r = sb.reverse().toString();
		

		StringBuffer sb1 = new StringBuffer(str);
		String r1 = sb1.reverse().toString();
		

		
		
		
		/* 코드를 완성합니다 */
		return null;
	}

	
	
	
	public static void printCharArray(char[] array){
		
		
		
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
	
	
	
}