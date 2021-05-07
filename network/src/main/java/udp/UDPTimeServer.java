package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPTimeServer {

	public static final int PORT = 9000;

	public static void main(String[] args) {

		DatagramSocket dSocket = null;
		try {

			System.out.println("UDP TIME SERVER: " + PORT);

			// 1. 소켓 생성
			dSocket = new DatagramSocket(PORT);

			while (true) {
				// 2. 데이터수신
				byte[] receiveData = new byte[1000];
				byte[] sendData = new byte[1000];

				Date date = new Date();

				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				dSocket.receive(receivePacket); // blocking

				InetAddress iAddress = receivePacket.getAddress();
				int clientPort = receivePacket.getPort();
				//sendData = date.toString().getBytes();

				// 3. 데이터 송신
				String now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
				sendData = now.toString().getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, iAddress, clientPort);
				dSocket.send(sendPacket);
			}

		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (dSocket != null) {
				dSocket.close();
			}
		}

//		// 3. 데이터 송신
//		String now = new SimpleDataFormat("yyyy-MM-dd hh:mm:ss").format(new Data());

	}

}
