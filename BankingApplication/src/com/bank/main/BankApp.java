package com.bank.main;

import java.util.Scanner;

import com.bank.bean.Account;
import com.bank.bean.AccountHolder;

public class BankApp {

	public static void main(String[] args) {

		AccountHolder user1 = accountRegistration();
       
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("\n");
			System.out.println("Enter 1 for deposit the amount");
			System.out.println("Enter 2 for withdraw the amount");
			System.out.println("Enter 3 for  check the Balance");
			System.out.println("Enter 4 for exit");
			int option = scan.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter Deposit Amount ::");
				user1.deposit(scan.nextDouble());
				break;

			case 2:
				System.out.println("Enter withdraw Amount ::");
				user1.withdraw(scan.nextDouble());
				break;

			case 3:
				user1.checkBalance();
				break;

			case 4:
				System.out.println("******* Thanks for using the application *******");
				scan.close();
				System.exit(0);
			default:
				System.out.println("invalid option try again with valid options ");
			}

		}

	}

	public static AccountHolder accountRegistration() {
		Scanner scanner = new Scanner(System.in);
		Account account = new Account();
		AccountHolder user1 = new AccountHolder();
		System.out.println("Enter the Firstname ::");
		user1.setFirstName(scanner.next());
		System.out.println("Enter the Lasttname ::");
		user1.setLasttName(scanner.next());
		System.out.println("Enter the Age ::");
		user1.setAge(scanner.nextInt());
		System.out.println("Enter the Address ::");
		user1.setAddress(scanner.next());
		System.out.println("Enter the MobileNumber ::");
		user1.setMobileNumber(scanner.next());
		System.out.println("Enter the Account type ::");
		account.setAccountType(scanner.next());
		System.out.println("Enter the AccountNumber  ::");
		account.setAccountNumber(scanner.next());
		user1.setAccount(account);
		return user1;
	}

}
