package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneTest01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			File file = new File("phone.txt");

			/* --file이 없을 경우 실행되는 부분-- */
			if (!file.exists()) {
				System.out.println("file not found");
				return;
			}
			/* --file이 없을 경우 실행되는 부분 END-- */

			System.out.println("=========== 파일 정보 ===========");
			System.out.println(file.getAbsolutePath()); // 파일 절대경로
			System.out.println(file.length() + "bytes");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String lastModifiedDate = sdf.format(new Date(file.lastModified()));
			System.out.println(lastModifiedDate); // file.lastModified() : 파일의 업데이트 시간, 마지막 수정날짜
			System.out.println("=========== 전화번로 ===========");
			
			// 1. 기반스트림
			FileInputStream fis = new FileInputStream(file);
		
		  // 2. 보조스트림1(byte -> char)	
			InputStreamReader isr = new InputStreamReader(fis);
			
			//3. 보조스트림2(char1|char2|char3)
			br = new BufferedReader(isr);
			
			//4. 처리
			String line = null;
			while((line = br.readLine()) !=null ) {
				
				StringTokenizer st = new StringTokenizer(line, "\t ");
				
				int index = 0;
				while(st.hasMoreTokens()) {
					String token = st.nextToken();
					if(index == 0) { //이름
						System.out.print(token +":");
					}else if(index == 1) { //전화번호 1
						System.out.print(token+"-");
					}else if(index == 2) { //전화번호 2
						System.out.print(token +"-");
					}else {	//전화번호3
						System.out.println(token);
					}

					index++;
				}
				
				
			}
		} catch (IOException e) {
System.out.println("error: "+e);
		}finally {
		try {
			if(br!=null) {
				br.close();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		}
	}
}
