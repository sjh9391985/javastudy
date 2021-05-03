//IO보단 SCANNER를 사용하는것이 쉽다!
package io;

import java.io.File;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PhoneText02 {

	public static void main(String[] args) {
		Scanner scanner = null;
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

			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String name = scanner.next();
				String phone1 = scanner.next();
				String phone2 = scanner.next();
				String phone3 = scanner.next();

				System.out.println(name + ":" + phone1 + "-" + phone2 + "-" + phone3);
			}

		} catch (IOException e) {
			System.out.println("error: " + e);
		} finally {
			scanner.close();

		}
	}

}
