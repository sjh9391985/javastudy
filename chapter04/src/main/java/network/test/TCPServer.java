/* TCP SERVER */

package network.test;

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
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();

			// 2. 주소 바인딩
			// socket에 inetSocketAddress(IPAddress + port)
			// IPAddress : 0.0.0.0 ( <- 모든 address를 받는것 : 모든 ip 연결허용 )
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000)); // ip주소:0.0.0.0, port번호: 5000

			// 3. accept
			// 클라이언트의 연결 요청을 기다린다.
			Socket socket = serverSocket.accept(); // blocking

			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress(); // port 번호와
																												// 상대편
																												// ip주소가
																												// 들어있음

			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress(); // 주소
			int remoteHostPort = inetRemoteSocketAddress.getPort(); // port번호

			System.out.println("Connected!!");
			System.out.println("[server] connected by client[" + remoteHostAddress + " : " + remoteHostPort + "]");

			try {
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while(true) {
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); // blocking
					
					if(readByteCount == -1) {
						// 클라이언트가 정상적으로 종료함 ( close() 호출 )
						System.out.println("[server] closed by client");
						break;
						
					}
					String data = new String(buffer, 0, readByteCount, "utf-8");
					System.out.println("[server] received: "+ data);
					
					//5. 데이터 쓰기
					os.write(data.getBytes("utf-8"));
					
				}
				
			}catch(SocketException e) {
				System.out.println("[server] sudden closed by client");
			}
			catch (IOException e) {
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
