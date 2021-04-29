package prob06;

public class Mul extends Arth {
	private int a;
	private int b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public int calculate() {
		// TODO Auto-generated method stub
		return a * b;
	}
	
	
}
