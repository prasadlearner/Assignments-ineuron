package com.bank.bean;
public class AccountHolder {
	private String firstName;
	private String lasttName;
	private int age;
	private String address;
	private String mobileNumber;
	private Account account;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasttName() {
		return lasttName;
	}

	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void deposit(double amount) {
		account.setBalance(amount);
		if (account.getBalance() >= amount) {
			System.out.println("Amount is Credeted Successfully");
		} else {
			System.out.println("Transation is failed try again...");
		}
	}

	public void withdraw(double amount) {
		double accBalance = account.getBalance();
		if (accBalance >= amount) {
			account.setBalance(accBalance - amount);
			System.out.println("balance is debited from your account successfully");
		} else {
			System.out.println("Account Balance is Insufficient for this Transaction");
		}
	}

	public void checkBalance() {
		System.out.println("Balance available in your account is :: " + account.getBalance());
	}

}
