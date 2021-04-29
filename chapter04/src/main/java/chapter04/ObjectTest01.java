package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {

		Point point = new Point(10, 10);

		System.out.println(point.getClass()); // reflection을 사용하면 class의 정보를 훝어볼수 있다.
		System.out.println(point.hashCode()); // address 기반의 해싱값
		System.out.println(point.toString()); // getClass()를 한번 호출 한 다음 + "@" + hashcode()로 구현
		System.out.println(point);
	}

}
