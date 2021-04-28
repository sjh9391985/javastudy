package prob03;

public class CurrencyConverter {

	private static double rate;

	public static double toDollar(double won) {
		double dollor = ((double)won/rate);
		return dollor;
	}

	public static double toKRW(double dollor) {
		double won = ((double)dollor*rate);
		return won;
	}

	public static void setRate(double rate) {
		CurrencyConverter.rate = rate;
	}
	
	
}
