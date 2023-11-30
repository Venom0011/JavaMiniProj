package com.utils;

import java.time.LocalDate;
import java.util.Map;

import com.CustomException.BankException;
import com.code.Actype;
import com.code.Address;
import com.code.Bank;

public class BankUtils {
    
    public static void checkDuplicate(Map<String,Bank> hm, String email) throws BankException{

        if(hm.containsKey(email)){
            throw new BankException("email already exits");
        }
    }

    public static Actype validaActype(String actype){
        return Actype.valueOf(actype);
    }

    public static LocalDate valiDate(String date){
        return LocalDate.parse(date);
    }

    public static Bank ValidateAll(String custName, Address address, String actype, int mobileNo, String email, String password,
			double balance,Map<String,Bank>hm) throws BankException{

                checkDuplicate(hm, email);
                Actype a=validaActype(actype);
                
                return new Bank(custName, address, a, mobileNo, email, password, balance);
            }
}
