package Thread.OnlineBankingThread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class UserAccount{
    private long accountNumber;
    private String accountHolderName;
    private String dateOfBirth;
    private String address;
    private int pin;
    private double balance;
    public UserAccount(long accountNumber, String accountHolderName, String dateOfBirth, String address, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.pin = pin;
        this.balance = balance;
    }
    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized  void  deposit(double amount){
        balance+=amount;
    }

    public synchronized  void withdraw(double amount) {
        balance-=amount;
    }
}
class DepositeThread extends Thread{
    private  UserAccount userAccount;
    private  double depositeAmount;

    public DepositeThread(UserAccount userAccount, double depositeAmount) {
        this.userAccount = userAccount;
        this.depositeAmount = depositeAmount;
    }

    @Override
    public void run() {
        if (depositeAmount > 0) {
            userAccount.deposit(depositeAmount);
            System.out.println(Thread.currentThread().getName()+" : Amount credited successfully.. new balance is : " + userAccount.getBalance());
        } else {
            System.out.println("Invalid credentials");
        }
    }
}
class WithdrawThread extends Thread{
    private   UserAccount userAccount;
    private   double withdrawAmount;
    public WithdrawThread(UserAccount userAccount, double withdrawAmount) {
        this.userAccount = userAccount;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {
        if (withdrawAmount > 0 && withdrawAmount <= userAccount.getBalance()) {
            userAccount.withdraw(withdrawAmount);
            System.out.println(Thread.currentThread().getName()+" : Amount debited from your account.. new balance is : " + userAccount.getBalance());
        } else {
            System.out.println("....Insufficient balance.....");
        }

    }
}
class CreateAccountThread extends Thread {
    Map<Long, UserAccount> userAccountMap;

    private long accountNumber;
    private String accountHolderName;
    private  String dob;
    private  String address;
    private int pinNumber;
    private double balance;
    public CreateAccountThread(Map<Long, UserAccount> userAccountMap, long accountNumber, String accountHolderName, String dob, String address, int pinNumber, double balance) {
     this.userAccountMap =userAccountMap;
     this.accountNumber =accountNumber;
     this.accountHolderName =accountHolderName;
     this.dob =dob;
     this.address= address;
     this.pinNumber =pinNumber;
     this.balance=balance;


    }

    @Override
    public void run() {
        UserAccount userAccount = new UserAccount(accountNumber, accountHolderName, dob, address, pinNumber, balance);
        userAccountMap.put(accountNumber, userAccount);
        System.out.println(Thread.currentThread().getName()+" : Account created successfully!!!! Account number is " + accountNumber);
    }
}

public class OnlineBanking {
    public static void main(String[] args) throws InterruptedException {
        Map<Long,UserAccount> userAccountMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(" 1.Create Account\n 2.CheckDetails \n 3.Deposit Money \n 4.Withdraw Money");
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
                    CreateAccountThread createAccountThread = new CreateAccountThread(userAccountMap,accountNumber,accountHolderName,dob,address,pinNumber,balance);
                    createAccountThread.setName("Account Creator Thread");
                    createAccountThread.start();
                    createAccountThread.join();
                    break;

                case 2:
                 System.out.print("Enter account number for checking details : ");
                 accountNumber = sc.nextLong();
                 UserAccount account = userAccountMap.get(accountNumber);
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
                 break;
                case 3:
                    System.out.print("Enter your account number : ");
                    accountNumber = sc.nextLong();
                    UserAccount userAccount =userAccountMap.get(accountNumber);
                    if (userAccount != null) {
                        System.out.print("Enter the amount to deposit : ");
                        double depositAmount = sc.nextDouble();
                        DepositeThread depositeThread = new DepositeThread(userAccount,depositAmount);
                        depositeThread.setName("Deposite Thread");
                        depositeThread.start();
                        depositeThread.join();

                    } else {
                        System.out.println("Account not exist..Please check your account number.");
                    }
                    break;

                case 4:
                    System.out.print("Enter your account number : ");
                    accountNumber = sc.nextLong();
                    userAccount = userAccountMap.get(accountNumber);
                    if (userAccount != null) {
                        System.out.print("Enter your PIN number for continue transaction : ");
                        pinNumber = sc.nextInt();
                        if (pinNumber ==userAccount.getPin()) {
                            System.out.print("Enter the amount to withdraw : ");
                            double withdrawAmount = sc.nextDouble();
                            WithdrawThread withdrawThread = new WithdrawThread(userAccount,withdrawAmount);
                            withdrawThread.setName("Withdraw Thread");
                            withdrawThread.start();
                            withdrawThread.join();
                        } else {
                            System.out.println("XXXX Wrong PIN XXXX");
                        }
                    } else {
                        System.out.println("Account not exist..Please check your account number.");
                    }
                    break;
            }

        }

    }
}