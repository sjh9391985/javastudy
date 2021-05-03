package review;

public class LansClassTest {

	public static void main(String[] args) {
		
		Point p = new Point(2, 3);
		Point p1 = new Point(2, 3);
		
		Point p2 = p;
		
//		System.out.println(p.getClass().getName());
//		System.out.println(p.hashCode()); //객체를 유일하게 구분할 수 있는 정수id
//		System.out.println(p.toString());
//		System.out.println(p);
		
		System.out.println(p == p1);
		System.out.println(p == p2);
		System.out.println(p.equals(p1)); //새로운 객체를 생성, p와 p1은 서로 다른 객체.
		
		
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		System.out.println( s1 == s2 );
		System.out.println( s1.equals(s2));
		
		Point a = new Point(2,3);
		Point b = new Point(2,3);
		
		System.out.println(a==b);
		System.out.println(a.equals(b));
	}

}
