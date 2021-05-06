package multichat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	private ServerSocket serverSocket;
	private static final int PORT = 8080; // port number
	BufferedReader bufferedReader;
	private HashMap<String, Object> hm;
	private boolean initFlag;
	private PrintWriter printWriter;

	
	public ChatServerThread(Socket socket, HashMap<String, Object> hm) {
		this.socket = socket;
		this.hm = hm;
		try {
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			nickname = bufferedReader.readLine();
			broadCast(nickname + "님이 접속하셨습니다.");
			System.out.println("닉네임: " + nickname);
			synchronized (hm) {
				hm.put(this.nickname, printWriter);
			}
			initFlag = true;

		} catch (Exception e) {
			System.out.println("[Error] : " + e + "입니다.");
		}
	}
	
	
	
	@Override
	public void run() {
		try {
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.equals("/quit")) {
					break;
				}
				if (line.indexOf("/to") == 0) {
					sendMsg(line);
				} else {
					broadCast(nickname + " : " + line);
				}
			}
		} catch (Exception e) {
			System.out.println("[Error] : " + e + "입니다.");
		} finally {
			synchronized (hm) {
				hm.remove(nickname);
			}
			broadCast(nickname + "님이 퇴장 하였습니다.");
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (Exception e) {
				System.out.println("[Error] : " + e + "입니다.");
			}
		}
	}

	private void sendMsg(String line) {
		int start = line.indexOf(" ") + 1;
		int end = line.indexOf(" ", start);
		if (end != -1) {
			String to = line.substring(start, end);
			String line2 = line.substring(end + 1);
			Object obj = hm.get(to);
			if (obj != null) {
				PrintWriter pw = (PrintWriter) obj;
				pw.println(nickname + "의 메시지: " + line2);
				pw.flush();
			}
		}

	}

	private void broadCast(String string) {
		// TODO Auto-generated method stub
		synchronized (hm) {
			Collection<Object> collection = hm.values();
			Iterator<?> iter = collection.iterator();
			while (iter.hasNext()) {
				PrintWriter pw = (PrintWriter) iter.next();
				pw.println(string);
				pw.flush();
			}
		}
	}

}
