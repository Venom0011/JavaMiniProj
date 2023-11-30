package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.code.Address;
import com.code.Bank;
import com.code.Register;

import static com.utils.BankMethods.*;

public class BankApp {
	static ArrayList<Register> reg = new ArrayList<Register>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Map<String, Bank> hm = new HashMap<>();
		try (Scanner sc = new Scanner(System.in)) {

			boolean exit = false;
			while (!exit) {
				System.out.println("1.Register 2.Login 3.Display");
				try {
					switch (sc.nextInt()) {
						case 1:
							System.out.println(
									"Enter the String custName, Address address, String actype, int mobileNo, String email, String password double balance, String accOpenDate,Map<String,Bank>hm to register");

							Bank c = com.utils.BankUtils.ValidateAll(sc.next(),
									new Address(sc.next(), sc.next(), sc.next()), sc.next(), sc.nextInt(), sc.next(),
									sc.next(), sc.nextDouble(), hm);

							hm.put(c.getEmail(), c);
							break;
						case 2:
							System.out.println("Enter email and password to register");
							authenticateUser(sc.next(), sc.next(), hm);
							break;
						case 3:
							System.out.println("The detaills are :");
							System.out.println("Enter the fileName to retrive the data");
							String fileName = sc.next();
							hm = getData(fileName);
							hm.values().stream().forEach(System.out::println);
							break;
						case 4:
							System.out.println("Enter the actno to search");
							Bank b = getCustomer(sc.nextInt(), hm);
							System.out.println("The details are " + b);
							break;
						case 5:
							System.out.println("Enter the accNo and amount to deposit ");
							deposit(sc.nextInt(), sc.nextDouble(), hm);
							break;
						case 6:
							System.out.println("Enter the accNo and amount to withdraw");
							withdraw(sc.nextInt(), sc.nextDouble(), hm);
							break;   
						case 7:
							removeAccount(hm);
							break;
						case 8:
							System.out.println("Sorting based on accNo");
							TreeMap<String, Bank> mp = new TreeMap<>(hm);
							System.out.println("Sorted data is ");
							mp.values().stream().forEach(System.out::println);
							break;
						case 9:
							System.out.println("Sorting based on registration date");
							hm.values().stream().sorted((k, v) -> k.getAccOpenDate().compareTo(v.getAccOpenDate()))
									.forEach(System.out::println);
							break;
						case 10:
							System.out.println("Enter the accNo to transfer money");
							moneyTransfer(sc.nextInt(), sc.nextInt(), hm, sc.nextDouble());
						
							break;

						case 0:
							System.out.println("Enter the fileName to save the data");
							fileName = sc.next();
							storeData(fileName, hm);
							exit = true;
							break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			sc.nextLine();
			e.printStackTrace();
		}
	}

}
