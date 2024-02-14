package DeamonThread;

import java.util.*;

class BankAccount{

    private long accountNumber;
    private String accountHolderName;
    private String dateOfBirth;
    private String address;
    private int pin;
    private double balance;



    public BankAccount(long accountNumber, String accountHolderName, String dateOfBirth, String address, int pin, double balance) {
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
    Map<Long, BankAccount> accounts;
    static Scanner sc = new Scanner(System.in);

    public BankAccountCreator(Map<Long, BankAccount> accounts) {
        this.accounts = accounts;
    }

    public void createAccount() {

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

        BankAccount newAccount = new BankAccount(accountNumber, accountHolderName, dob, address, pinNumber, balance);
        accounts.put(accountNumber, newAccount);

        System.out.println("Account created successfully!! your Account number is " + accountNumber);


    }

    public void displayAccountDetails() {
        System.out.print("Bank Account Number : ");
        long accountNumber = sc.nextLong();
        BankAccount account = accounts.get(accountNumber);
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
class AccountHandler{
    Map<Long,BankAccount> accounts;
    static  Scanner sc =new Scanner(System.in);

    public AccountHandler(Map<Long, BankAccount> accounts) {
        this.accounts =accounts;
    }

    public void  depositMoney(){
        System.out.print("Enter your account number : ");
        long accountNumber = sc.nextLong();
        BankAccount bankAccount = accounts.get(accountNumber);
        if(bankAccount !=null){
            System.out.print("Enter the amount to deposit : ");
            double depositAmount = sc.nextDouble();
            if(depositAmount>0){
                bankAccount.deposit(depositAmount);
                System.out.println("Amount credited successfully.. new balance is : "+ bankAccount.getBalance());
            }else{
                System.out.println("Invalid credentials");
            }

        }else{
            System.out.println("Account not exist..Please check your account number.");
        }
    }

    public void withdrawMoney() {
        System.out.print("Enter your account number : ");
        long accountNumber = sc.nextLong();

        BankAccount bankAccount = accounts.get(accountNumber);
        if(bankAccount !=null){
            System.out.print("Enter your PIN number for continue transaction : ");
            int pinNumber =sc.nextInt();
            if(pinNumber == bankAccount.getPin()) {
                System.out.print("Enter the amount to withdraw : ");
                double withdrawAmount = sc.nextDouble();
                if (withdrawAmount > 0 && withdrawAmount <= bankAccount.getBalance()) {
                    bankAccount.withdraw(withdrawAmount);
                    System.out.println("Amount debited from your account.. new balance is : " + bankAccount.getBalance());
                } else {
                    System.out.println("....Insufficient balance.....");
                }
            }else {
                System.out.println("XXXX Wrong PIN XXXX");
            }
        }else{
            System.out.println("Account not exist..Please check your account number.");
        }

    }

    public void transferMoney() {
        System.out.print("Enter your account number : ");
        long senderAccountNumber =sc.nextLong();
        BankAccount senderAccount = accounts.get(senderAccountNumber);
        if(senderAccount != null){
            System.out.print("Enter your PIN : ");
            int pin = sc.nextInt();
            if(pin ==senderAccount.getPin()){
                System.out.print("Enter recipient account number : ");
                long recepientAccountNumber = sc.nextLong();
                BankAccount recepientAccount = accounts.get(recepientAccountNumber);
                if(recepientAccount != null){
                    System.out.print("Enter the amount to transfer : ");
                    double transferAmount =sc.nextDouble();
                    if(transferAmount>0 && transferAmount <= senderAccount.getBalance()){
                        senderAccount.withdraw(transferAmount);
                        recepientAccount.deposit(transferAmount);
                        System.out.println("Transaction successfully..your current balance is "+senderAccount.getBalance());
                        System.out.println("Do you want the transcation statements ?");
                        System.out.println("1.YES\n2.NO");
                        int choice = sc.nextInt();
                        switch (choice){
                            case 1:
                                System.out.println("------------------------------");
                                System.out.println("Sender Name : "+senderAccount.getAccountHolderName());
                                System.out.println("Sender Account Number : "+senderAccount.getAccountNumber());
                                System.out.println("Amount Transfer "+transferAmount);
                                System.out.println("Current Balance : "+senderAccount.getBalance());
                                System.out.println("Recepient Name : "+recepientAccount.getAccountHolderName());
                                System.out.println("Recepient Account Number : "+recepientAccount.getAccountNumber());
                                System.out.println("Money credited in recipient account is : "+transferAmount);
                                System.out.println("------------------------------");
                                break;
                            case 2:
                                break;

                        }

                    }else{
                        System.out.println("Transfer failed...Insufficient balance for transfer");
                    }
                }else{
                    System.out.println("Recipient not found");
                }
            }else{
                System.out.println("XXX Wrong PIN XXX");
            }
        }else{
            System.out.println("Please check your account number you entered wrong account number");
        }
    }
}
public class BankSystem {
    public static void main(String[] args) {
        Map<Long,BankAccount> accountMap = new HashMap<>();
        BankAccountCreator accountCreator = new BankAccountCreator(accountMap);
        AccountHandler accountHandler = new AccountHandler(accountMap);
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(" 1.Create Account\n 2.CheckDetails \n 3.Deposit Money \n 4.Withdraw Money \n 5.Transfer Money :");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice){
                case 1 :
                    accountCreator.createAccount();
                    break;
                case  2 :
                    accountCreator.displayAccountDetails();
                    break;
                case  3 :
                    accountHandler.depositMoney();
                    break;
                case 4 :
                    accountHandler.withdrawMoney();
                    break;
                case 5 :
                    accountHandler.transferMoney();

            }
        }

    }
}