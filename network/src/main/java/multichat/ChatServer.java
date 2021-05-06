package multichat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ChatServer {
	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		try {

			// 1. 서버소켓 생성
			serverSocket = new ServerSocket(8080);
			HashMap<String, Object> hm = new HashMap<String, Object>();
			while (true) {
				System.out.println("접속 기다리는중");
				Socket socket = serverSocket.accept();
				ChatServerThread chatServerThread = new ChatServerThread(socket, hm);
				chatServerThread.start();
			}

		} catch (Exception e) {
			System.out.println("[Error] : " + e + "입니다.");
		}

	}

}
