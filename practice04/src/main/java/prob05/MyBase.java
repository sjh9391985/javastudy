package prob05;

public class MyBase extends Base {

	
	@Override
	public void service(String state) {
		if( state.equals( "낮" ) ) {
			day();
			
		} else if() {
			night();
		}
	}
	public void launch() {
		System.out.println("오후에도 일 해야 합니다.");
	}
	
	@Override
	public void day() {
		// TODO Auto-generated method stub
		
		System.out.println("낮에는 열심히 일하자!");
		
	}
	@Override
	public void night() {
		// TODO Auto-generated method stub
		super.night();
		System.out.println("밤에는 일해야 합니다.");
	}
	
	
	

}