package review;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "Point("+x + "," +y+ ")";
	}
	
	public boolean equals(Point p) {
		if(x == p.x && y == p.y) {
			return true;
		}else {
			return false;
		}
	}
}
