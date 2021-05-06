package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost {

	public static void main(String[] args) {
		
		try {
			//InetAddress: 자바에서 ip주소를 표현할때 사용하는 클래스
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostName = inetAddress.getHostName(); //호스트 이름을 문자열로 담음
			String hostAddress = inetAddress.getHostAddress(); //IP주소를 문자열로 담음
			
			System.out.println(hostName); //호스트 이름
			System.out.println(hostAddress); //호스트 주소
			
			byte[] addresses = inetAddress.getAddress(); //InetAddress 객체의 IP주소를 반환
			for(byte address : addresses) {
				System.out.print(address & 0x000000ff);
				System.out.print(".");
				
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
