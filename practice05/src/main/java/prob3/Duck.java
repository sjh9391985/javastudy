package prob3;

public class Duck extends Bird {

	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("오리("+name+")는 날지 않습니다.");
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("오리("+name+")가 소리내어 웁니다.");		
	}

	
	
	
}
