package exercises.entities.exceptions;

public class Account {
	private Integer number;
	private String holder;
	private Double withdrawLimit;
	private Double balance;
	
	public Account(Integer number, String holder, Double withdrawLimit, Double balance) {
		this.number = number;
		this.holder = holder;
		this.withdrawLimit = withdrawLimit;
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Double getBalance() {
		return balance;
	}

	public void deposit(Double amount) {
		balance += amount;
	}
	public void withdraw(Double amount) {
		if(balance <= 0) {
			throw new DomainException("No balance in your account");
		}
		if(amount > withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if(amount > balance) {
			throw new DomainException("Not enough balance");
		}
		
		balance-= amount;
	}
	@Override
	public String toString() {
		return "New balance: " + balance;
	}
}
