package multichat.client;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import multichat.ChatClientThread;
//import practice.ServerThread;

public class ChatClientApp {

	/* 필요 field 선언 */
	ServerSocket serverSocket;
	Socket socket;
	ArrayList<ServerThread> list = new ArrayList<ServerThread>();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String name = null;
		while (true) {

			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();

			if (name.isEmpty() == false) {
				break;
			}

			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}

		scanner.close();

		// 1. create socket
		// 2. connect to server
		// 3. create iostream
		// 4. join

		String line = "JOIN:OK";
		if ("JOIN:OK".equals(line)) {
			new ChatWindow(name).show();

		}
		new ServerThread();
		new ChatClientApp();

	}

	public ChatClientApp() {
		try {
			serverSocket = new ServerSocket(7000);
			while (true) {
				System.out.println("접속대기중");
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + " 주소 연결");

				/* 접속 클라이언트를 스레드로 만들어 ArrayList 추가 */
				ServerThread serverThread = new ServerThread();
				addThread(serverThread);
				serverThread.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addThread(ServerThread serverThread) {
		list.add(serverThread);
	}

	public void removeThread(ServerThread serverThread) {
		list.remove(serverThread); // 제거
	}

	public void broadCast(String message) {
		for (ServerThread serverThread : list) {
			serverThread.pw.println(message);
		}
	}

}

class ServerThread extends Thread {
	ChatClientApp serverSocket;
	PrintWriter pw;

	
	@Override
	public void run() {
		
		String name = null;
		
		
		try {
			// 읽기 준비
			BufferedReader br = new BufferedReader(new InputStreamReader(serverSocket.socket.getInputStream()));

			// 쓰기 준비
			pw = new PrintWriter(serverSocket.socket.getOutputStream(), true);

			name = br.readLine(); // 대화명 읽기

			serverSocket.broadCast("[" + name + "]님 입장하셨습니다.");

			String data = null;
			while ((data = br.readLine()) != null) {
				serverSocket.broadCast("[ " + name + " ] " + data);
			}

		} catch (Exception e) {
			// 현재 쓰레드를 ArrayList에 제거한다.
			serverSocket.removeThread(this);
			serverSocket.broadCast("[ " + name + " ] 님이 퇴장하셨습니다.");
			System.out.println(serverSocket.socket.getInetAddress() + "주소의 [" + name + " ] 님이 퇴장하셨습니다.");
			System.out.println(e + "----> ");
		}
	}

}
