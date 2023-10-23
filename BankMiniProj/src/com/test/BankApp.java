package com.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.code.Bank;
import com.code.Register;

public class BankApp {
	static ArrayList<Register> reg = new ArrayList<Register>();
	static Scanner sc = new Scanner(System.in);

	public static void register() {
		System.out.println("Enter uname");
		String uname = sc.next();
		System.out.println("Enter password");
		String pass = sc.next();
		reg.add(new Register(uname, pass));

		login();
	}

	public static void login() {
		System.out.println("Please enter uname and Password to login");
		String uname = sc.next();
		String pass = sc.next();
		boolean userFound = false;
		for (Register r : reg) {
			if (r.getUname().equals(uname) && r.getPassword().equals(pass)) {
				userFound = true;
				System.out.println("Login Success for :" + r.getUname());
				break;
			}
		}
		if (userFound) {
			bankMethods();
		} else {
			System.out.println("Account does not exits: ");
			System.out.println("Do you want to create account : Y or N");
			char c = sc.next().charAt(0);
			if (c == 'Y' || c == 'y') {
				register();
			} else {
				System.out.println("Thank You for Banking with us..");
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("\n----Welcome To Our Bank----\n");
		System.out.println("1.Register\n2.Login");
		int ch = sc.nextInt();
		if (ch == 1) {
			register();
		} else if (ch == 2) {
			login();
		}
	}

	public static void bankMethods() {

		Bank obj = new Bank();
		int ch;
		do {
			System.out.println("1.View Balance 2.Withdraw 3.Deposit");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Your Curent balance is : " + obj.getBalance());
				break;
			case 2:
				System.out.println("Enter the amount to withdraw ");
				double amt = sc.nextDouble();
				double bal = obj.withdraw(amt);
				System.out.println("Balance after withdraw :" + bal);
				break;
			case 3:
				System.out.println("Enter the amount to deposit ");
				amt = sc.nextDouble();
				System.out.println("Balance after deposit :" + obj.deposit(amt));
				break;
			}
		} while (ch != 4);
		System.out.println("Thank You for Banking with us..");
	}

}
