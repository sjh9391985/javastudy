package prob05;

public class Account {
	
	private String accountNo;
	private int balance;
	
	public Account(String number) {
		this.accountNo = number;
	}
	
	public Account() {	
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int save(int num) {
		this.balance = num;
		return balance;
	}
	
	public int deposit(int num) {
		this.balance = this.balance - num;
		return balance;
	}
	
	
	
	
}
