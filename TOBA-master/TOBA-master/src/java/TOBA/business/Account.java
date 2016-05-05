/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Robert2
 */
@Entity
@Table
public class Account implements Serializable { 

    public void setAccountType(AccountType accountType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public enum AccountType { Checkings, accountsavings;

        public int getId() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
  
   
    @Id
    @Column (name="AccountID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountId;
    @Column (name="ACCOUNT_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private AccountType accountType;
    
    @Column (name="Balance")
    private double balance;
    

   

    public Account() {

    }

    public Account(double balance, AccountType typeOfAccount){
        this.balance = balance;
        this.accountType = typeOfAccount;
    }    
    
    public long getAccountId() {
        return accountId;
    }
    
    public void setAccountId(long accountId){
        this.accountId = accountId;
    }
    
    public AccountType getAccountType() {
        return accountType;
    }
        
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    } 
    
    public void credit(double amount) {
        this.balance += amount;
    }
    
    public void debit(double amount) {
        this.balance -= amount;
    }
    
}
