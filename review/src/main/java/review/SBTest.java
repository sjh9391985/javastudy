package review;

public class SBTest {

	public static void main(String[] args) {
		
		
		/* 스트링 버퍼는 문자열을 추가하거나 변경 할 때 주로 사용하는 자료형 */
		StringBuffer sb = new StringBuffer(" This"); //스트링버퍼 생성
		System.out.println(sb);
		
		
		sb.append(" is pencil"); //문자열 덧붙이기
		System.out.println(sb);
		
		sb.insert(8, "my"); 
		System.out.println(sb);
		
		sb.setLength(5);
		System.out.println(sb);
		
		
	}

}
