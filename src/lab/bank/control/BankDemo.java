package lab.bank.control;

import lab.bank.entity.Account;
import lab.bank.entity.Bank;
import lab.bank.entity.SavingsAccount;
import lab.bank.exception.AccountNotFoundException;

public class BankDemo {
	public static void main(String[] args) {
		System.out.println("===���� ����===");
		Bank bank = new Bank();
		bank.createSavingsAccount("ȫ�浿", 10000, 3);
		bank.createCheckingAccount("��ö��", 20000, 5000);
		bank.createSavingsAccount("�̿���", 30000, 2);
		
		System.out.println("\n===��� ���� ���===");
		bank.printAllAcounts();
		System.out.println("==================");
		
		System.out.println("\n===�Ա�/��� �׽�Ʈ===");
		bank.deposit("AC1000", 5000);
		bank.withdraw("AC1001", 3000);
		
		System.out.println("\n===���� ���� �׽�Ʈ===");
		Account account;
		try {
			account = bank.findAccount("AC1000");
			if (account instanceof SavingsAccount) {
			    SavingsAccount savingsAccount = (SavingsAccount) account;
			    savingsAccount.applyInterest();
			} else {
			    System.out.println("�� ���´� ������°� �ƴմϴ�.");
			}
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n===���� ��ü �׽�Ʈ===");
		bank.transfer("AC1002", "AC1001", 5000);
		
		System.out.println("\n===��� ���� ���===");
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
