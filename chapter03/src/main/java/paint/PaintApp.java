package paint;

public class PaintApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point point1 = new Point(10, 20);
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
		// drawRect(rect)
		// drawShape(rect)
		draw(rect);

		Traiangle triangle = new Traiangle();
		draw(triangle);

		Circle circle = new Circle();
		draw(circle);

		draw(new GraphicText("hello~"));
		
		//instanceof text <= 이항연산자
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		
		//오류: class는 hierachy 상위와 하위만 instanceof 연산자를 사용할 수 있다.
		//System.out.println(circle instanceof Rect);
		//System.out.println(circle instanceof Traiangle);
		
		Shape s = new Circle();
		System.out.println(s instanceof Object);
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Rect);
		
		//interface는 hierachy와 상관없이 instanceof 연산자를 사용할 수 있다.
		System.out.println(s instanceof Drawable);
		System.out.println(s instanceof Runnable);

	}

	public static void draw(Drawable drawable) {
		drawable.draw();
	}
}
