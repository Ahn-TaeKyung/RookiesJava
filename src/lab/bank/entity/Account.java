package lab.bank.entity;

import lab.bank.exception.InsufficientBalanceException;

public class Account {
	private String accountNumber;
	private String ownerName;
	private double balance;
	
	public Account(String accountNumber, String ownerName, double initialBalance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = initialBalance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void deposit(double amount) {
		balance += amount;
		System.out.format("%.1f원이 입금되엇습니다. 현재 잔액: %.1f원\n", amount, balance);
	}
	public void withdraw(double amount) throws InsufficientBalanceException{
		if(amount > balance) {
			String errMessage = String.format("잔액이 부족합니다. (요청금액 : %d, 현재 잔액 : %d, args)", amount, balance);
			throw new InsufficientBalanceException(errMessage);
		}
		this.balance -= amount;
		System.out.format("%.1f원이 출금되엇습니다. 현재 잔액: %.1f원\n", amount, balance);
	}
	public String toString() {
		return "계좌번호:" + this.accountNumber + ", 소유자:" + this.ownerName + ", 잔액:"
				+ this.balance + "원";
	}
}
