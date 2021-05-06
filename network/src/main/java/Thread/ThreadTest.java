package Thread;

public class ThreadTest extends Thread {

	@Override
	public void run() {
		try {
			for(int i = 0; i< 10; i++) {			
				Thread.sleep(500);
				System.out.println("Thread: "+ i);	
		}
		}catch (InterruptedException e) {
				// TODO Auto-generated catch block
			System.out.println(e);
			}
			
		}
		
	}


