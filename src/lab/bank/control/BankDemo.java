package lab.bank.control;

import lab.bank.entity.Account;
import lab.bank.entity.Bank;
import lab.bank.entity.SavingsAccount;
import lab.bank.exception.AccountNotFoundException;

public class BankDemo {
	public static void main(String[] args) {
		System.out.println("===계좌 생성===");
		Bank bank = new Bank();
		bank.createSavingsAccount("홍길동", 10000, 3);
		bank.createCheckingAccount("김철수", 20000, 5000);
		bank.createSavingsAccount("이영희", 30000, 2);
		
		System.out.println("\n===모든 계좌 목록===");
		bank.printAllAcounts();
		System.out.println("==================");
		
		System.out.println("\n===입금/출금 테스트===");
		bank.deposit("AC1000", 5000);
		bank.withdraw("AC1001", 3000);
		
		System.out.println("\n===이자 적용 테스트===");
		Account account;
		try {
			account = bank.findAccount("AC1000");
			if (account instanceof SavingsAccount) {
			    SavingsAccount savingsAccount = (SavingsAccount) account;
			    savingsAccount.applyInterest();
			} else {
			    System.out.println("이 계좌는 저축계좌가 아닙니다.");
			}
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n===계좌 이체 테스트===");
		bank.transfer("AC1002", "AC1001", 5000);
		
		System.out.println("\n===모든 계좌 목록===");
		bank.printAllAcounts();
		
		System.out.println("========================");
		bank.withdraw("AC1001", 9000);
		bank.withdraw("AC1001", 9000);
		try {
			bank.findAccount("AC9999");
		} catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
