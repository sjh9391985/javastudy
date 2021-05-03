package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream("dooly.jpg"); // read (입력)
			os = new FileOutputStream("dooly.copy.jpg"); // write(출력)
		
			int data = -1;
			while ((data = is.read()) != -1) {
				os.write(data);
			}
		}catch(FileNotFoundException e) {
			System.out.println("file not fount : " + e);
		} catch(IOException e) {
			System.out.println("erro: " +e);
		}finally{
			try {
				if(is != null) {
					is.close();
				}
				if(os!=null) {
					os.close();
				}
			}
			catch(Exception e) {
				
			}
			
		}
	}
}