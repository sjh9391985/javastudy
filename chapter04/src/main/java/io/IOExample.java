package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class IOExample {

	public static void main(String[] args) throws IOException {

		byte[] src = { 1, 2, 3, 4 };
		byte[] dest = null;
		
		InputStream is = new ByteArrayInputStream(src); // read (입력)
		ByteArrayOutputStream os = new ByteArrayOutputStream(); // write(출력)

		int data = -1;
		while ((data = is.read()) != -1) {
			os.write(data);
		}
		
		dest = ((ByteArrayOutputStream)os).toByteArray(); //내부안의 버퍼를 다운캐스팅하여 가져옴

		System.out.println(Arrays.toString(dest));
	}

}
