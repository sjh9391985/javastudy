package Thread;

public class Thread1 {

	public static void main(String[] args) {
		
		Thread t1 = new ThreadTest();
		Thread t2 = new ThreadTest();

		t1.start();
		t2.start();
//		t1.run();
//		t2.run();
	}

}
