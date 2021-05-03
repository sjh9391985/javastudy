package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamtest {

	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		try {
			//기반 스트림
			FileOutputStream fis = new FileOutputStream("test.txt");
			
			//보조스트림
			bos = new BufferedOutputStream(fis);
			
			// ascii code 사용(97(a)~122(z))
			for(int i = 'a'; i<'z'; i++) {
				bos.write(i);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("can't open: " + e);
		}catch(IOException e) {
			System.out.println("error: " +e);
		} finally {
			try {
				if(bos!=null) {
					bos.close();
				}
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}

