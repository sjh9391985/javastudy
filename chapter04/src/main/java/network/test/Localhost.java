package network.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

//자기 자신의 host를 알아보는 코드

public class Localhost {
	public static void main(String[] args) {

		try {
			InetAddress inetAddress = InetAddress.getLocalHost();

			String hostname = inetAddress.getHostName();// 자신의 컴퓨터의 이름을 알려주는것
			System.out.println(hostname);

			String hostAddress = inetAddress.getHostAddress(); // 자신의 컴퓨터의 host 주소를 알려주는것
			System.out.println(hostAddress);
			
			byte[] addresses = inetAddress.getAddress();
			
			for(byte address: addresses) {
				//System.out.print(address+"."); //byte출력과 int출력이 동일하게 나옴 
				
				System.out.print(address & 0x000000ff); //ip주소를 int값으로 나오게 출력
				System.out.print(".");
			}
			
		} catch (UnknownHostException e) {

			e.printStackTrace();
		}

	}

}
