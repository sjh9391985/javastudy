package paint;

public class Traiangle extends Shape {
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y4;
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public int getX3() {
		return x3;
	}
	public void setX3(int x3) {
		this.x3 = x3;
	}
	public int getY4() {
		return y4;
	}
	public void setY4(int y4) {
		this.y4 = y4;
	}
	
	@Override
	public void draw() {
		System.out.println("삼각형을 그렸습니다.");
	}
	
}
