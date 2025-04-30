package lab.bank.entity;

public class SavingsAccount extends Account{
	private double interestRate;

	public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
		super(accountNumber, ownerName, initialBalance);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void applyInterest() {
		double balance = this.getBalance();
		double interest = balance * interestRate / 100;
		this.setBalance(balance + interest); 
		System.out.format("%.1f원이 입금되었습니다. 현재 잔액: %.1f원\n", interest, this.getBalance());
	}
	@Override
	public String toString() {
		
		return super.toString() + String.format(", 이자율: %.1f%%", interestRate);
	}
}
