package paint;

public class PaintApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point point1 = new Point(10,20);	
		draw(point1);

		Point point2 = new Point(100, 200);
//		point2.show();
//		point1.show(false);
		draw(point2);
		
		Point point3 = new ColorPoint(50, 100, "red");
		// point3.show();
		draw(point3);
		
		
//		drawPoint(point3);
//		
		Rect rect = new Rect();
		//drawRect(rect)
		//drawShape(rect)
		draw(rect);

		Traiangle triangle = new Traiangle();
		draw(triangle);

		Circle circle = new Circle();
		draw(circle);
		
		draw(new GraphicText("hello~"));

	}


	public static void draw(Drawable drawable) {
		drawable.draw();
	}
}
