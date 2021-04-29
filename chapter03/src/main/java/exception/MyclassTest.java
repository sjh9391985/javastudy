package exception;

public class MyclassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			MyClass myClass = new MyClass();
			myClass.danger();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
