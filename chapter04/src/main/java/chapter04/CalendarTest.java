package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		printDate(cal);

		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DATE, 25);
		printDate(cal);

		cal.set(2010, 10, 10);
		cal.add(Calendar.DATE, 25);
		printDate(cal);
	}

	private static void printDate(Calendar cal) {
		final String[] DAYS ={"일","월","화","수","목","금","토"};
		
		// year
		int year = cal.get(Calendar.YEAR);

		// month
		int month = cal.get(Calendar.MONTH);

		// day
		int day1 = cal.get(Calendar.DATE);

		//요일 1부터 시작(1(일요일)~7(토요일))
		int day2 = cal.get(Calendar.DAY_OF_WEEK);
		
		// hour
		int hour = cal.get(Calendar.HOUR);

		// minutes
		int minutes = cal.get(Calendar.MINUTE);

		// second
		int second = cal.get(Calendar.SECOND);

		System.out.println((year) + "-" + (month + 1) + "-" + day1 + " " +day2+"요일 "+ hour + ":" + minutes + ":" + second);

	}

}
