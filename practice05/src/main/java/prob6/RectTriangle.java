package prob6;

public class RectTriangle extends Shape {

	private int width;
	private int height;

	public RectTriangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width * height * 0.5  ;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return width+height+ Math.sqrt((width*width)+(height*height));
	}

}