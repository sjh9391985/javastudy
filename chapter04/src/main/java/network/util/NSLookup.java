package network.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;


public class NSLookup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			try {

				System.out.print(">>");
				String line = sc.nextLine();

				if ("exit".equals(line)) {
					System.out.println("finish");
					break;
				}

				InetAddress[] inetAddress = InetAddress.getAllByName(line);
			
				for(InetAddress inetAddress1 : inetAddress){
					System.out.println(line +" : "+ inetAddress1.getHostAddress());
				}
			} catch (UnknownHostException ex) {
				System.out.println("unknown host");
			}

		}

		sc.close();
	}

}
