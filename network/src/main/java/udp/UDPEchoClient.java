package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import echo.EchoServer;

public class UDPEchoClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = UDPEchoServer.PORT;
	public static final int BUFFERSIZE = UDPEchoServer.BUFFERSIZE;

	public static void main(String[] args) {

		DatagramSocket socket = null;
		Scanner sc = null;

		try {

			// 1. scanner 생성
			sc = new Scanner(System.in);

			// 2. 소켓생성
			socket = new DatagramSocket();

			while (true) {

				// 3. 키보드 입력 받기
				System.out.println(">>");
				String line = sc.nextLine();

				if ("exit".equals(line)) {
					break;
				}

				// 4. 데이터 쓰기
				byte[] sendData = line.getBytes("UTF-8");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
						new InetSocketAddress(SERVER_IP, SERVER_PORT));

				socket.send(sendPacket);

				// 5. 데이터 읽기
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFERSIZE], BUFFERSIZE);
				socket.receive(receivePacket); // blocking

				byte[] receiveData = receivePacket.getData();
				int length = receivePacket.getLength();
				String message = new String(receiveData, 0, length, "utf-8");

				System.out.println(">" + message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
				if (sc != null) {
					sc.close();
				}
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			
		}

	}

}
