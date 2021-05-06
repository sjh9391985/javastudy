package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private static final String DOCUMENTROOT = "./webapp";
	private Socket socket;

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream os = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort());

			String request = null;
			while (true) {
				String line = br.readLine(); // 요청을 읽고 응답을 보냄

				// 브라우저가 연결을 끊으면,
				if (line == null) {
					break;
				}

				// request Header만 읽음
				if ("".equals(line)) {
					break;
				}

				// 첫 번째 라인만 처리
				if (request == null) {
					request = line;
					break;
				}
			}

			// 요청 처리
			String[] tokens = request.split(" ");
			if ("GET".equals(tokens[0])) {
				consoleLog("request: " + tokens[1]);
				responseStaticResource(os, tokens[1], tokens[2]);
			} else { // method: POST, PUT, DELETE, HEAD, CONNECT
				/* SimpleHTTP Server 에서는 무시 */
				respone400Error(os, tokens[1], tokens[2]);
				

				// 응답예시
				// os.write("HTTP/1.1 400 Bad request\r\n".getBytes("UTF-8"));
				// os.write("Content-Type:text/html; charset=utf-8\r\n".getBytes("UTF-8"));
				// os.write("\r\n".getBytes());
				// HTML 에러문서 (./webapp/error/400.html) 읽어서 보여주기

				// respone400Error(os, tokens[1], tokens[2]);
			}

			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
			// os.write("HTTP/1.1 200 OK\r\n".getBytes("UTF-8"));
			// os.write("Content-Type:text/html;
			// charset=utf-8\r\n".getBytes("UTF-8"));
			// os.write("\r\n".getBytes());
			// os.write("<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된
			// 것입니다.</h1>".getBytes("UTF-8"));

		} catch (Exception ex) {
			consoleLog("error:" + ex);

		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}

			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}

	private void respone400Error(OutputStream os, String url, String protocol) throws IOException{
		url = "./error/400.html";
		File file = new File(DOCUMENTROOT + url);
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		os.write((protocol + "400 Bad request\r\n").getBytes("UTF-8"));
		os.write(("Content-Type:" + contentType + ";charset=utf-8\r\n").getBytes("UTF-8"));
		os.write("\r\n".getBytes());
		os.write(body);
	}
	
	private void responseStaticResource(OutputStream os, String url, String protocol) throws IOException {
		// welcome file setting
		if ("/".equals(url)) {
			url = "./index.html";
		}

		File file = new File(DOCUMENTROOT + url);
						// "./webapp"
		
		if (file.exists() == false) {
			url = "./error/404.html";
			// resopnse404Error(os, url, protocol);
			File file1 = new File(DOCUMENTROOT+ url);
			byte[] body = Files.readAllBytes(file1.toPath());
			String contentType = Files.probeContentType(file1.toPath());
			// 응답예시
			os.write((protocol+"404 File Not Found\r\n").getBytes("UTF-8"));
			os.write(("Content-Type:" + contentType +"; charset=utf-8\r\n").getBytes("UTF-8"));
			os.write("\r\n".getBytes());
			os.write(body);
			// HTML 에러문서 (./webapp/error/404.html) 읽어서 보여주기
			
			return;
		}
		
		


		// new IO
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		os.write((protocol + "200 OK\r\n").getBytes("UTF-8"));
		os.write(("Content-Type:" + contentType + ";charset=utf-8\r\n").getBytes("UTF-8"));
		os.write("\r\n".getBytes());
		os.write(body);
		
	}

	public void consoleLog(String message) { // Thread 상속받아서 사용중이여서 바로 getId()로 사용
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}
}
