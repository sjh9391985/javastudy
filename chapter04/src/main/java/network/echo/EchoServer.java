package network.echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	private static final int PORT = 7000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();

			// 2. 주소 바인딩
			// socket에 inetSocketAddress(IPAddress + port)
			// IPAddress : 0.0.0.0 ( <- 모든 address를 받는것 : 모든 ip 연결허용 )
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT)); // ip주소:0.0.0.0, port번호: 5000
			log("stats...[port:" + PORT + "]");

			// 3. accept
			// 클라이언트의 연결 요청을 기다린다.
			Socket socket = serverSocket.accept();
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress(); // port 번호와
																												// 상대편
																												// ip주소가
																												// 들어있음

			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress(); // 주소
			int remoteHostPort = inetRemoteSocketAddress.getPort(); // port번호

			System.out.println("Connected!!");
			log("[server] connected by client[" + remoteHostAddress + " : " + remoteHostPort + "]");

			try {
				// 4. IO Stream 받아오기

				OutputStream os = socket.getOutputStream();

				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "utf-8"), true);
				while (true) {
					// 5. 데이터 읽기
					String data = br.readLine();

					if (data == null) {
						// 클라이언트가 정상적으로 종료함 ( close() 호출 )
						log("closed by client");
						break;

					}
					// 6. 데이터 쓰기
					log("received: " + data);
					pw.println(data);

				}

			} catch (SocketException e) {
				log("[server] sudden closed by client");
			} catch (IOException e) {
				e.printStackTrace();

			} finally {

				try {
					if (socket != null && socket.isClosed() == false) {
						socket.close();
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {

				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void log(String log) {
		System.out.println("[EchoServer]" + log);
	}

}
