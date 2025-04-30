package lab.bank.exception;

public class WithdrawalLimitExceededException extends InsufficientBalanceException{
	public WithdrawalLimitExceededException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
