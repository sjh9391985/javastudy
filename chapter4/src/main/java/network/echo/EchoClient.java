package network.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = EchoServer.PORT;

	public static void main(String[] args) {
	
		Socket socket = null;
		Scanner sc= null;
		
		try{
			
			//1. scanner 생성
			sc = new Scanner(System.in);
			
			//2. 소켓생성
			socket = new Socket();
			
			//3. 서버연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("connected");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"),true);
			
			while(true) {
				
				// 5. 키보드 입력 받기
				System.out.println(">>");
				String line = sc.nextLine();
				
				if("exit".equals(line)) {
					break;
				}
				
				// 6. 데이터 쓰기
				pw.println(line);
				
				// 7. 데이터 읽기
				String data = br.readLine();
				if(data == null) {
					log("closed by server");
					break;
				}
				
				System.out.println("<"+data);
			}
		}catch(SocketException e) {
			log("suddenly closed by server");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(sc != null) {
					sc.close();
				}
				if(socket != null && socket.isClosed() ==false) {
					socket.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private static void log(String log) {
		System.out.println("[EchoClient] " + log);
	}

}
