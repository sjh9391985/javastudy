package network.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println(">>");
				String line = sc.nextLine();
				
				if("exit".equals(line)) {
					break;
				}
				
				//IPv4 형식의 IP주소를 가져온다
				InetAddress[] inetAddresses = InetAddress.getAllByName(line);
				
				for(InetAddress inetAddress : inetAddresses ) {	  //ip주소를 반환
					System.out.println(line + " : " + inetAddress.getHostAddress());
				}
			}catch(UnknownHostException ex) {
				System.out.println("unknown host");
			}
		}
		
	}

}
