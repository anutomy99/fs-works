package org.fs.banksystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class BankUser {
    private long accountNumber;
    private String accountHolderName;
    private String dateOfBirth;
    private String address;
    private int pin;
    private double balance;

    public BankUser(long accountNumber, String accountHolderName, String dateOfBirth, String address, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.pin = pin;
        this.balance =balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String  getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public double getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }

    public  void  deposit(double amount){
        balance+=amount;
    }

    public void withdraw(double amount) {
        balance-=amount;
    }
}
class BankAccountCreator {
    Map<Long, BankUser> userAccounts;
    public BankAccountCreator(Map<Long,BankUser> accounts) {

        this.userAccounts = accounts;
    }

    public void createAccount(long accountNumber,String  accountHolderName,String dob,String address,int pinNumber,double balance) {
        BankUser newAccount = new BankUser(accountNumber, accountHolderName, dob, address, pinNumber, balance);
        userAccounts.put(accountNumber, newAccount);
        System.out.println("Account created successfully!! your Account number is " + accountNumber);
    }

    public void displayAccountDetails(long accountNumber) {

        BankUser account = userAccounts.get(accountNumber);
        if (account != null) {
            System.out.println("-----------------------------");
            System.out.println("Account Number : " + account.getAccountNumber());
            System.out.println("Account holder name : " + account.getAccountHolderName());
            System.out.println("Date Of Birth : " + account.getDateOfBirth());
            System.out.println("Address : " + account.getAddress());
            System.out.println("Balance : " + account.getBalance());
            System.out.println("-----------------------------");
        } else {
            System.out.println("Please check the account Invalid account number X X X");
        }
    }
}
class AccountHandler {
    Map<Long,BankUser> userAccounts;

    public AccountHandler(Map<Long,BankUser> accounts) {

        this.userAccounts = accounts;
    }

    public void depositMoney(long accountNumber, double depositAmount) {
        BankUser bankAccount = userAccounts.get(accountNumber);
        if (depositAmount > 0) {
            bankAccount.deposit(depositAmount);
            System.out.println("Amount credited successfully.. new balance is : " + bankAccount.getBalance());
        } else {
            System.out.println("Invalid credentials");
        }

    }

    public void withdrawMoney(long accountNumber, double withdrawAmount) {
        BankUser bankAccount = userAccounts.get(accountNumber);
        if (withdrawAmount > 0 && withdrawAmount <= bankAccount.getBalance()) {
            bankAccount.withdraw(withdrawAmount);
            System.out.println("Amount debited from your account.. new balance is : " + bankAccount.getBalance());
        } else {
            System.out.println("....Insufficient balance.....");
        }

    }

    public void transferMoney(long senderAccountNumber, long recepientAccountNumber, double transferAmount) {
        BankUser senderAccount = userAccounts.get(senderAccountNumber);
        BankUser recepientAccount = userAccounts.get(recepientAccountNumber);
        if (transferAmount > 0 && transferAmount <= senderAccount.getBalance()) {
            senderAccount.withdraw(transferAmount);
            recepientAccount.deposit(transferAmount);
            System.out.println("Transaction successfully..your current balance is " + senderAccount.getBalance());
            System.out.println("Do you want the transcation statements ?");
            System.out.println("1.YES\n2.NO");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("------------------------------");
                    System.out.println("Sender Name : " + senderAccount.getAccountHolderName());
                    System.out.println("Sender Account Number : " + senderAccount.getAccountNumber());
                    System.out.println("Amount Transfer " + transferAmount);
                    System.out.println("Current Balance : " + senderAccount.getBalance());
                    System.out.println("Recepient Name : " + recepientAccount.getAccountHolderName());
                    System.out.println("Recepient Account Number : " + recepientAccount.getAccountNumber());
                    System.out.println("Money credited in recipient account is : " + transferAmount);
                    System.out.println("------------------------------");
                    break;
                case 2:
                    break;

            }

        } else {
            System.out.println("Transfer failed...Insufficient balance for transfer");
        }

    }
}


public class BankSystem {
    public static void main(String[] args) {
        Map<Long,BankUser> userAccountMap = new HashMap<>();
        BankAccountCreator accountCreator = new BankAccountCreator(userAccountMap);
        AccountHandler accountHandler = new AccountHandler(userAccountMap);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(" 1.Create Account\n 2.CheckDetails \n 3.Deposit Money \n 4.Withdraw Money \n 5.Transfer Money :");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    long accountNumber = Math.abs(new Random().nextLong() % 1_000_000_00L);
                    System.out.print("Enter account holder name : ");
                    String accountHolderName = sc.next();
                    System.out.print("Enter DOB : ");
                    String dob = sc.next();
                    System.out.print("Enter Address: ");
                    String address = sc.next();
                    System.out.print("Enter PIN Number : ");
                    int pinNumber = sc.nextInt();
                    double balance = 0.0;
                    accountCreator.createAccount(accountNumber, accountHolderName, dob, address, pinNumber, balance);
                    break;
                case 2:
                    System.out.print("Bank Account Number : ");
                    accountNumber = sc.nextLong();
                    accountCreator.displayAccountDetails(accountNumber);
                    break;
                case 3:
                    System.out.print("Enter your account number : ");
                    accountNumber = sc.nextLong();
                    BankUser bankAccount = userAccountMap.get(accountNumber);
                    if (bankAccount != null) {
                        System.out.print("Enter the amount to deposit : ");
                        double depositAmount = sc.nextDouble();
                        accountHandler.depositMoney(accountNumber, depositAmount);
                    } else {
                        System.out.println("Account not exist..Please check your account number.");
                    }
                    break;
                case 4:
                    System.out.print("Enter your account number : ");
                    accountNumber = sc.nextLong();
                    bankAccount = userAccountMap.get(accountNumber);
                    if (bankAccount != null) {
                        System.out.print("Enter your PIN number for continue transaction : ");
                        pinNumber = sc.nextInt();
                        if (pinNumber == bankAccount.getPin()) {
                            System.out.print("Enter the amount to withdraw : ");
                            double withdrawAmount = sc.nextDouble();
                            accountHandler.withdrawMoney(accountNumber, withdrawAmount);
                        } else {
                            System.out.println("XXXX Wrong PIN XXXX");
                        }
                    } else {
                        System.out.println("Account not exist..Please check your account number.");
                    }
                    break;
                case 5:
                    System.out.print("Enter your account number : ");
                    long senderAccountNumber = sc.nextLong();
                    BankUser senderAccount = userAccountMap.get(senderAccountNumber);
                    if (senderAccount != null) {
                        System.out.print("Enter your PIN : ");
                        int pin = sc.nextInt();
                        if (pin == senderAccount.getPin()) {
                            System.out.print("Enter recipient account number : ");
                            long recepientAccountNumber = sc.nextLong();
                            BankUser recepientAccount = userAccountMap.get(recepientAccountNumber);
                            if (recepientAccount != null) {
                                System.out.print("Enter the amount to transfer : ");
                                double transferAmount = sc.nextDouble();
                                accountHandler.transferMoney(senderAccountNumber, recepientAccountNumber, transferAmount);
                            } else {
                                System.out.println("Recipient not found");
                            }
                        } else {
                            System.out.println("XXX Wrong PIN XXX");
                        }
                    } else {
                        System.out.println("Please check your account number you entered wrong account number");
                    }
            }

        }
    }

}

