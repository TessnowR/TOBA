/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA.business;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table
@XmlRootElement

public class Users implements Serializable {

    
    @Column(name = "Zipcode")
    private String zipcode;
    @Column(name = "AccountID")
    private Integer accountID;
    @Column(name = "AccountType")
    private String accountType;
    @Column(name = "Balance")
    private Float balance;
    @Column(name = "TransactionID")
    private Integer transactionID;
    @Id
    @Column (name="UserId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    
    @Column (name="FirstName")
    private String firstName;
    @Column (name="LastName")
    private String lastName;
    @Column (name="PhoneNumber")
    private String phoneNumber;
    @Column (name="Address")
    private String address;
    @Column (name="City")
    private String city;
    @Column (name="State")
    private String state;
    @Column (name="Email")
    private String email;
    @Column (name="UserName")
    private String username;
    @Column (name="Password")
    private String password;

    @OneToMany (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private ArrayList<Account> accounts;

    public Users(String firstName, String lastName, String phoneNumber, String address,
            String city, String state, String zipcode, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.email = email;
        this.username = firstName + zipcode;
        this.password = "welcome1";
        this.accounts = new ArrayList<>();
        this.accounts.add(new Account(25.00, Account.AccountType.accountsavings));
        this.accounts.add(new Account(0.00, Account.AccountType.Checkings));
    }

     Users() {
        
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userid) {
        this.userId = userid;
    }
    public String getFirstName(){
        return firstName;
    }
    
    
    
    public String getLastName(){
        return lastName;
    }
    
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
   
    
    public String getAddress(){
        return address;
    }
   
    
    public String getCity(){
        return city;
    }
    
   
    
    public String getState(){
        return state;
    }
   
    
    
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getUsername(){
        return username;
    }
    
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    public ArrayList<Account> getAccounts() {
        return accounts;
    }    

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
    
    public Account getAccount(Account.AccountType which) {
        for (Account a: this.accounts){
            if (a.getAccountType() == which){
                return a;
            }
        }
        return null;
    }
    
    public double getCheckingBalance(){
        Account checking = getAccount(Account.AccountType.Checkings);
        return checking.getBalance();
    }
    
    public double getSavingsBalance(){
        Account savings = getAccount(Account.AccountType.accountsavings);
        return savings.getBalance();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }
}
    

