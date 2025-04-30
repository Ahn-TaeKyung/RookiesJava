package lab.bank.entity;

import lab.bank.exception.InsufficientBalanceException;
import lab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account{
	private double withdrawalLimit;
	public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
		super(accountNumber, ownerName, initialBalance);
		this.withdrawalLimit = withdrawalLimit;
	}
	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	public void setWithdrawalLimit(double withdrawalLimit) {
		this.withdrawalLimit = withdrawalLimit;
	}
	@Override
	public void withdraw(double amount) throws InsufficientBalanceException{
		if (amount > withdrawalLimit) {
			String errMessage = String.format("���� �߻�: ��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: %.1f��", withdrawalLimit);
			throw new WithdrawalLimitExceededException(errMessage);
		}
		super.withdraw(amount);
	}
	@Override
	public String toString() {
		
		return super.toString() + String.format(", ��� �ѵ�: %.1f��", withdrawalLimit);
	}
	
	
	
}
