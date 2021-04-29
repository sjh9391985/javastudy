package paint;

public class PaintApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point point1 = new Point(10,20);	
		point1.show();

		Point point2 = new Point(100, 200);
		point2.show();

		point1.show(false);

		Point point3 = new ColorPoint(50, 100, "red");
		point3.setX(50);
		point3.setY(100);
		((ColorPoint) point3).setColor("red");
		// point3.show();

		point3.show(true);

//		drawPoint(point3);
//		
		Rect rect = new Rect();
		draw(rect);

		Traiangle triangle = new Traiangle();
		draw(triangle);

		Circle circle = new Circle();
		draw(circle);

	}

//	public static void draw(Shape sp) {
//		sp.show();
//	}

	public static void draw(Shape sp) {
		sp.draw();
	}

//
//	public static void drawTriangle(Traiangle triangle) {
//		triangle.draw();
//	}	

}
