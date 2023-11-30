package com.code;

import java.io.Serializable;
import java.time.LocalDate;

public class Bank implements Serializable {
	private int custId;
	static private int Custcount;
	private String custName;
	private Address address;
	private Actype actype;
	private int MobileNo;
	private String Email;
	private String password;
	private double balance;
	private LocalDate accOpenDate;
	private LocalDate transDate;

	static {
		Custcount = 100;
	}

	public Bank(String custName, Address address, Actype actype, int mobileNo, String email, String password,
			double balance) {
		this.custName = custName;
		this.address = address;
		this.actype = actype;
		MobileNo = mobileNo;
		Email = email;
		this.password = password;
		this.balance = balance;
		this.accOpenDate = LocalDate.now();
		this.custId = Custcount++;
	}

	public int getCustId() {
		return custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Actype getActype() {
		return actype;
	}

	public void setActype(Actype actype) {
		this.actype = actype;
	}

	public double getBalance() {
		return balance;
	}

	public LocalDate getAccOpenDate() {
		return accOpenDate;
	}

	public void setAccOpenDate(LocalDate accOpenDate) {
		this.accOpenDate = accOpenDate;
	}

	public LocalDate getTransDate() {
		return transDate;
	}

	public void setTransDate(LocalDate transDate) {
		this.transDate = transDate;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(int mobileNo) {
		MobileNo = mobileNo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	

	@Override
	public String toString() {
		return "Bank [custId=" + custId + ", custName=" + custName + ", address=" + address + ", actype=" + actype
				+ ", balance=" + balance + ", accOpenDate=" + accOpenDate + ", transDate=" + transDate + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this.Email != ((Bank) obj).Email)
			return false;
		return true;
	}

}
