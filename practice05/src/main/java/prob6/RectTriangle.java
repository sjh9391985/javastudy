package prob6;

public class RectTriangle extends Shape  {

	private double width;
	private double height;

	public RectTriangle(double width, double height) {
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