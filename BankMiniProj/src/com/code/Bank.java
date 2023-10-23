package com.code;

public class Bank {
	private int custId;
	static private int count;
	private double balance;
	
	static {
		count=100;
	}
	public Bank(){
		balance=1000;
		count++;
		this.custId=count;
	}
	
	public int getCustId() {
		return custId;
	}
	public double getBalance() {
		return balance;
	}
	public double withdraw(double amt) {
        if (amt > balance) {
            System.out.println("Insufficient balance");
            return balance;
        }
        balance -= amt;
        return balance;
    }

    public double deposit(double amt) {
        balance += amt;
        return balance;
    }
    }
	

