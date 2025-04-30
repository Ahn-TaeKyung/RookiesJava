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
		System.out.format("%.1f���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��\n", amount, balance);
	}
	public void withdraw(double amount) throws InsufficientBalanceException{
		if(amount > balance) {
			String errMessage = String.format("�ܾ��� �����մϴ�. (��û�ݾ� : %d, ���� �ܾ� : %d, args)", amount, balance);
			throw new InsufficientBalanceException(errMessage);
		}
		this.balance -= amount;
		System.out.format("%.1f���� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f��\n", amount, balance);
	}
	public String toString() {
		return "���¹�ȣ:" + this.accountNumber + ", ������:" + this.ownerName + ", �ܾ�:"
				+ this.balance + "��";
	}
}
