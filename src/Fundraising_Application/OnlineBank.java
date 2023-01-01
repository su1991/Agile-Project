/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fundraising_Application;

import javax.swing.JScrollPane;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class OnlineBank {

   
   
}

class CustomerState implements Serializable{
    
    String CurrentCustomerState;
    
    
    
    CustomerState(String CustomerUserName){
        
        this.CurrentCustomerState = CustomerUserName;
        
    }
    
    
      
    
}

class Applications implements Serializable{
    
    String ApplicationNumber;
    String Applicationstatus;
    
    
    Applications(String A, String B){
        
        this.ApplicationNumber = A;
        this.Applicationstatus = B;
    }
      
    
}
class UserAccount implements Serializable {


    String Name;
    String Password;
    String Email;
    String phoneNumber;
    String City;
    String Town;
    String District;
    String StreetAddress;
    String PlaceAddress;
    String CreditCard;
    
     static int Accountscounter = 0;
    
    String arrayofUsersAccounts[][] = new String[1][10];
    
    UserAccount(){
        
        
    }
   
    
    
   
   

}


class CustomerAccount extends UserAccount {
    
  
    int ApplicationNumber;
    int Balance = 0;
    String AccountNumber;
    String pin;
           
            
     CustomerAccount(int A, String B, String C, String D, String E,String F){
        
        this.ApplicationNumber = A;
        this.Name = B;
        this.Password = C;
        this.Email = D;
        this.phoneNumber =E;
        this.PlaceAddress = F;
        
        
      
        
        Accountscounter++;
        
    } 

    public int getApplicationNumber() {
        return ApplicationNumber;
    }
     
     

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

   

    public String getPlaceAddress() {
        return PlaceAddress;
    }

 
    public static int getAccountscounter() {
        return Accountscounter;
    }

    public String[][] getArrayofUsersAccounts() {
        return arrayofUsersAccounts;
    }

    
   
    
    
    
    public String getAccountNumber() {
        
        return AccountNumber;
        
    }
    
    public void setAccountNumber(String accNumber) {
        
        AccountNumber = accNumber;  
        
    }
    
    public String getCreditCardNumber() {
        
        return CreditCard;
        
    }
    
    public void setCreditCardNumber(String ccNumber) {
        
        CreditCard = ccNumber;  
        
    }
    
    public String getPinNumber() {
        
        return pin;
        
    }
    
    public void setPinNumber(String pinNumber) {
        
        pin = pinNumber ;  
        
    }
    
    
    public int getBalance() {
        
        return Balance;
        
    }
    
    
    
    int CheckBalance(){
        
        return Balance;
    }
    
    void DepositAmount(int Deposited_amount){
        
        Balance += Deposited_amount;
        
    }
    
}




