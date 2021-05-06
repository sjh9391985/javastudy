package multichat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.exit(1);
		}

		Socket socket = null;
		BufferedReader bufferedReader = null;
		PrintWriter printWriter = null;
		boolean endflag = false;
		Scanner scanner = null;

		try {
			socket = new Socket(args[1], 8080);
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			printWriter.println(args[0]);
			printWriter.flush();
			ChatClientThread chatClientThread = new ChatClientThread(socket, bufferedReader);
			chatClientThread.start();

			String line = null;
			while ((line = keyboard.readLine()) != null) {
				printWriter.println(line);
				printWriter.flush();
				if (line.equals("/quit")) {
					endflag = true;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("[Error] : " + e + "입니다.");
		} finally {
			try {
				if (printWriter != null) {
					printWriter.close();
				}
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
