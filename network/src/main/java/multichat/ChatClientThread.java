package multichat;

import java.io.BufferedReader;
import java.net.Socket;

public class ChatClientThread extends Thread {

	private Socket socket = null;
	private BufferedReader bufferedReader = null;

	public ChatClientThread(Socket socket, BufferedReader bufferedReader) {
		this.socket = socket;
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void run() {
		try {
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println("[Error] : " + e + "입니다.");
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (Exception e) {
				System.out.println("[Error] : " + e + "입니다.");
			}

		}
	}

}
