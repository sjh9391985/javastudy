package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			// 1. 소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩(binding)
			// socket에 InetSocketAddress(IPAddress + port) 클래스를 구현
			// IPAddress : 0.0.0.0 <- 모든 IP 연결 허용
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000));

			// 3. accept
			// 클라이언트의 연결 요청을 기다림
			Socket socket = serverSocket.accept(); // blocking //accep()가 호출되면 프로그램은 여기서 실행을 멈추고 클라이언트 포트가 5000번으로 연결할
													// 때까지 무한 대기

			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress(); // 연결된 시스템에
																												// 대한
																												// 주소를
																												// 반환

			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort(); // 소켓이 연결된 포트를 알려줌

			System.out.println("[server] connected by client[" + remoteHostAddress + " : " + remoteHostPort + "]");
			// -> 명령창에서 해당 포트번호로 접속을 하면 hostaddress 와 port number을 출력

			try {

				InputStream is = socket.getInputStream(); // 입력 스트림 얻기
				OutputStream os = socket.getOutputStream(); // 출력 스트림 얻기

				while (true) {
					byte[] buffer = new byte[256];
					// 데이터 읽기
					int readBytecount = is.read(buffer); // read의 개념
					if (readBytecount == -1) {
						System.out.println("[server] closed by client");
						break;
					}

					//
					String data = new String(buffer, 0, readBytecount, "utf-8");
					System.out.println("[server] received: " + data);
					
					// 5. 데이터 쓰기
					os.write(data.getBytes("utf-8"));
				}

			} catch (SocketException e) {
				System.out.println("[server] suddenly closed by client");
			} catch (IOException e) {
				// TODO Auto-generated catch block
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

}
