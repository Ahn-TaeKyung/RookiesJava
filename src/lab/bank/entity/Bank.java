package lab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import lab.bank.exception.AccountNotFoundException;
import lab.bank.exception.InsufficientBalanceException;

public class Bank {
	private List<Account> accounts;
	private int nextAccountNumber;
	
	public Bank(){
		accounts = new ArrayList<Account>();
		nextAccountNumber = 1000;
	}
	
	public String createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
		SavingsAccount savingsAccount = new SavingsAccount("AC"+Integer.toString(nextAccountNumber), 
														ownerName, initialBalance, interestRate);
		System.out.println("저축 계좌가 생성되었습니다:" + savingsAccount.toString());
		accounts.add(savingsAccount);
		nextAccountNumber += 1;
		return "";
	}
	
	public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
		CheckingAccount checkingAccount = new CheckingAccount("AC"+Integer.toString(nextAccountNumber), 
														ownerName, initialBalance, withdrawalLimit);
		System.out.println("체킹 계좌가 생성되었습니다:" + checkingAccount.toString());
		accounts.add(checkingAccount);
		nextAccountNumber += 1;
		return "";
	}
	
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		String errMessage = String.format("예외 발생: 계좌번호 %s에 해당하는 계좌를 찾을 수 없습니다.", accountNumber);
		throw new AccountNotFoundException(errMessage);
	}
	public void deposit(String accountNumber, double amount) {
		try{
			findAccount(accountNumber).deposit(amount);
		}catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	public void withdraw(String accountNumber, double amount) {
		try{
			try {
				findAccount(accountNumber).withdraw(amount);
			} catch (InsufficientBalanceException e) {
				System.out.println(e.getMessage());
			}
		}catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
		try{
			try {
				findAccount(fromAccountNumber).withdraw(amount);
			} catch (InsufficientBalanceException e) {
				System.out.println(e.getMessage());
			}
		}catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try{
			findAccount(toAccountNumber).deposit(amount);
		}catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.format("%.1f원이 %s에서 %s로 송금되었습니다.\n", amount, fromAccountNumber, toAccountNumber);
	}
	public void printAllAcounts() {
		for (Account account : accounts) {
			System.out.println(account.toString());
		}
		
	}
}
