package Thread;

public class AlphabetThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(char c ='a'; c<='z'; c++) {
			System.out.print(c);
			try {
			Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}
