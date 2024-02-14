package DeamonThread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Bank{
    private  String bankName;
    private String ifsc;
    private String branch;

//    public Bank(String bankName, String ifsc, String branch) {
//        this.bankName = bankName;
//        this.ifsc = ifsc;
//        this.branch = branch;
//    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIfsc() {
        return ifsc;
    }

    public String getBranch() {
        return branch;
    }

}
class BankUser  {
    private  long accountNumber;
    private  String accountHolderName;
    private  int pin;
    private double balance;

//    public BankUser(String bankName, String ifscCode, String branch, long accountNumber, String accountHolderName, int pinNumber, double balance) {
//        super(bankName, ifscCode, branch);
//        this.accountNumber =accountNumber;
//        this.accountHolderName = accountHolderName;
//        this.pin = pinNumber;
//        this.balance =balance;
//
//    }


    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }
    public  void  deposit(double amount){
        balance+=amount;
    }

    public void withdraw(double amount) {
        balance-=amount;
    }
}
class BankAccountGenerator {
    Map<Long,BankUser> userMap  ;
    Bank bank =new Bank();
    Scanner sc=new Scanner(System.in);

    public BankAccountGenerator(Map<Long, BankUser> userMap) {
        this.userMap = userMap;
    }

    public void bankAccountGenerator(String bankName, String ifscCode, String branch, long accountNumber, String accountHolderName, int pinNumber, double balance) {

//        BankUser bankUser = new BankUser(bankName,ifscCode,branch,accountNumber, accountHolderName, pinNumber, balance);
//        userMap.put(accountNumber,bankUser);
        System.out.println("Ifsc:");
        bank.setBankName(sc.next());
//        userMap.put(accountNumber,bank);
        System.out.println("Account created successfully!! your Account number is " + accountNumber);

    }
    public void displayAccountDetails(long accountNumber) {

        BankUser  userAccount = userMap.get(accountNumber);
        if (userAccount != null) {
            System.out.println("-----------------------------");
//            System.out.println("Bank Name : "+userAccount .getBankName());
//            System.out.println("IFSC Code : "+userAccount .getIfsc());
//            System.out.println("Branch Name  : "+userAccount .getBranch());
            System.out.println("Account Number : " + userAccount .getAccountNumber());
            System.out.println("Account holder name : " + userAccount .getAccountHolderName());
            System.out.println("Balance : " + userAccount .getBalance());
            System.out.println("-----------------------------");
        } else {
            System.out.println("Please check the account Invalid account number X X X");
        }
    }
}
class BankAccountHandler{
    Map<Long,BankUser> userMap;

    public BankAccountHandler(Map<Long, BankUser> userMap) {
        this.userMap = userMap;
    }

    public void  depositeMoney(long accountNumber, double depositAmount){
            BankUser bankUser =userMap.get(accountNumber);
            if(depositAmount>0){
               bankUser.deposit(depositAmount);
                System.out.println("Amount credited successfully.. new balance is : "+ bankUser.getBalance());
            }else{
                System.out.println("Invalid credentials");
            }



    }
}
public class BankSystemManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Long,BankUser> userMap = new HashMap<>();
        BankAccountGenerator accountGenerator = new BankAccountGenerator(userMap);
        BankAccountHandler bankAccountHandler = new BankAccountHandler(userMap);

        while (true) {
            System.out.println(" 1.Create Account\n 2.CheckDetails \n 3.Deposit Money \n 4.Withdraw Money \n 5.Transfer Money ");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:

                        System.out.print("Enter bank name: ");
                        String bankName = sc.next();
                        System.out.print("Enter IFSC Code: ");
                        String ifscCode = sc.next();
                        System.out.print("Enter branch name: ");
                        String branch = sc.next();
                        long accountNumber = Math.abs(new Random().nextLong() % 1_000_000_00L);
                        System.out.print("Enter account holder name : ");
                        String accountHolderName = sc.next();
                        System.out.print("Enter PIN Number : ");
                        int pinNumber = sc.nextInt();
                        double balance = 0.0;
                        accountGenerator.bankAccountGenerator(bankName,ifscCode,branch,accountNumber,accountHolderName,pinNumber,balance);

                    break;
                case 2 :
                    System.out.print("Bank Account Number : ");
                    accountNumber = sc.nextLong();
                    accountGenerator.displayAccountDetails(accountNumber);
                    break;
                case 3 :
                    System.out.print("Enter your account number : ");
                    accountNumber = sc.nextLong();
                    BankUser bankAccount = userMap.get(accountNumber);
                    if(bankAccount !=null){
                        System.out.print("Enter the amount to deposit : ");
                        double depositAmount = sc.nextDouble();
                        bankAccountHandler.depositeMoney(accountNumber,depositAmount);
                    }else{
                        System.out.println("Account not exist..Please check your account number.");
                    }
            }
        }
    }
}