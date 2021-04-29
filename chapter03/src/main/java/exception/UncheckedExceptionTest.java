package exception;
/**
 * 
 * @author BIT
 * unchecked Exception은 try-catch-finally 를 사용하는것이 아니라 에러를 그냥 고쳐야 한다.
 */
public class UncheckedExceptionTest {

	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5};
		
		for(int i =0; i<= a.length; i++) {
			System.out.println(a[i]);
		}
		
	}

}
