package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {

		Date now = new Date();

		System.out.println(now);
		printDate01(now);
		printDate02(now);

	}

	private static void printDate02(Date d) {
		// year (+1900)
		int year = d.getYear() + 1900;

		// month (0~11, +1)
		int month = d.getMonth();

		// day
		int day = d.getDay();

		// hour
		int hour = d.getHours();

		// minutes
		int minutes = d.getMinutes();

		// second
		int second = d.getSeconds();

		System.out.println((year + 1900) + "-" + (month + 1) + "-" + day + " " + hour + ":" + minutes + ":" + second);

	}

	private static void printDate01(Date d) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String date1 = sdf.format(d);
		System.out.println(date1);

	}

}
