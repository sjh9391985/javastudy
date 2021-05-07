package multichat.client;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import practice.ChatGuiClient;

public class ChatWindow extends Runnable {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	
	Socket socket;
	BufferedReader br;
	PrintWriter pw;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void serverConnection() {
		
		try {
			socket = new Socket("127.0.0.1", 7000);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			new Thread(this).start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatWindow(null).serverConnection(); // 객체생성과 동시에 메서드 호출
	}
	
	
	
	
	public void show() {
		/*
		 * 1. UI 초기화
		 * 
		 */

		// Button
		buttonSend.setBackground(Color.white);
		buttonSend.setForeground(Color.black);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				sendMessage();

			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char KeyCode = e.getKeyChar();
				if (KeyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
				if (KeyCode == KeyEvent.VK_ESCAPE) {
					finish();
				}

			}

		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		/*
		 * 2. IOStream 생성
		 */

		/*
		 * 3. Chat Client Thread 생성(Receive Thread)
		 */

	}


	private void updateTextArea(String message) {
		textArea.append(message + "\n");

	}

	/* thread 내부로 만들어주는것이 좋다. */

	private void finish() {
		System.out.println("소켓닫기 or 방나가기 프로토콜 구현");
		System.exit(0);

	}

	private void sendMessage() {
		// 버튼을 눌었을대 작동
		String message = textField.getText();

		System.out.println("프로토콜 메시지 구현");

		updateTextArea(message);

		// protocol 구현
		textField.setText("");
		textField.requestFocus();

	}
}

