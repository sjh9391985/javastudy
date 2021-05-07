package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPTimeClient {

	private static final String MSG = "What is the time?";
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 9000;

	public static void main(String[] args) {

		DatagramSocket dSocket = null;

		try {

			// 1. 소켓 생성
			dSocket = new DatagramSocket();

			InetAddress iAddress = InetAddress.getByName(SERVER_IP);

			// 2. 데이터 쓰기
			byte[] sendData = MSG.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, iAddress, SERVER_PORT);

			dSocket.send(sendPacket);

			// 3. 데이터 읽기
			byte[] receiveData = new byte[1000];
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			dSocket.receive(receivePacket); // blocking

			System.out.println("receivePacket: " + new String(receivePacket.getData()));

		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (dSocket != null && dSocket.isClosed() == false) {
				dSocket.close();
			}
		}

	}

}
