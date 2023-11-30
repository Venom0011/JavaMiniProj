package com.utils;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import com.CustomException.BankException;
import com.code.Bank;

public class BankMethods {
    public static void authenticateUser(String email, String password, Map<String, Bank> hm) throws BankException {
        if (hm.containsKey(email)) {
            for (Bank b : hm.values()) {
                if (b.getPassword().equals(password)) {
                    System.out.println("login Success");
                    return;
                } else {
                    throw new BankException("Password incorrect");
                }
            }
        } else {
            throw new BankException("Email not found");
        }
    }

    public static Bank getCustomer(int accNo,Map<String,Bank>hm) throws BankException{
        for(Bank b:hm.values()){
            if(b.getCustId()==accNo){
                return b;
            }
        }
        throw new BankException("Accno not found");

    }

    public static double withdraw(int accNo,double amt,Map<String,Bank>hm) throws BankException {
		
       Bank b=getCustomer(accNo, hm);
        if (amt > b.getBalance()) {
			System.out.println("Insufficient balance");
			return b.getBalance();
		}
		b.setBalance(b.getBalance()-amt);
        b.setTransDate(LocalDate.now());
		return b.getBalance();
	}

	public static double deposit(int accNo,double amt,Map<String,Bank>hm) throws BankException {
		Bank b=getCustomer(accNo, hm);

        b.setBalance(b.getBalance()+amt) ;

        b.setTransDate(LocalDate.now());
		return b.getBalance();
	}

    public static void moneyTransfer(int accNo1,int accNo2,Map<String,Bank>hm,double amt) throws BankException{
        withdraw(accNo1, amt, hm);
        deposit(accNo2, amt, hm);
        System.out.println("Money transfered from "+accNo1+" to "+accNo2+" Successfully ");
    }

    public static void removeAccount(Map<String,Bank>hm){
        List<Bank>lst=new ArrayList<>(hm.values());
        Iterator<Bank> itr=lst.iterator();
        while(itr.hasNext()){
            Bank b=itr.next();
        long period=Period.between(b.getTransDate(), LocalDate.now()).toTotalMonths();    
            if(period>4){
                itr.remove();
            }
        }
    }

    public static void storeData(String fileName,Map<String,Bank>hm) {
        try(ObjectOutputStream op=new ObjectOutputStream(new FileOutputStream(fileName))){
            op.writeObject(hm);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String,Bank> getData(String fileName){
        try(ObjectInputStream ip=new ObjectInputStream(new FileInputStream(fileName));
            
        ){
            return (Map<String,Bank>)ip.readObject();
        }
        catch(Exception e){
            e.printStackTrace();
            return new HashMap<>();
        }
    }
    
}
