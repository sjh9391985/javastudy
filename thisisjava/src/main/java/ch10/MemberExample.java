package ch10;

public class MemberExample {
	public static void main(String[] args) {
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");
		
		if(obj1.equals(obj2)) {
			System.out.println("obj1 과 obj2는 동등"); // check
		} else {
			System.out.println("obj1 과 obj2는 동등하지 않음");
		}
		
		if(obj1.equals(obj3)) {
			System.out.println("obj1 과 obj3는 동등");
		} else {
			System.out.println("obj1 과 obj3는 동등하지 않음"); // check
		}
		
		
	}
}
