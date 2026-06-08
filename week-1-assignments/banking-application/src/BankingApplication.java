// Banking Application

import java.lang.*;
import java.util.*;

//----------------------------------------------------------------------------------------------------------------------------------------
//                          class                                   Role
//                          BankAccount                             Store Balance and Handling account operations
//----------------------------------------------------------------------------------------------------------------------------------------

class BankAccount
{
    private int accNo;
    private String customerName;
    private double balance;
    private int pin;

    private ArrayList<String> transactionHistory;

    public BankAccount(int accNo, String name, double balance,int pin)
    {
        this.accNo = accNo;
        this.customerName = name;
        this.balance = balance;
        this.pin = pin;

        transactionHistory = new ArrayList<>();

        transactionHistory.add("Account Opened with Initial Deposit : ₹" + balance);

    }

    // Getters
    public int getAccNo()
    {
        return accNo;
    }

    public String getName()
    {
        return customerName;
    }

    public double getBalance()
    {
        return balance;
    }
    
    // Normal Banking operaions
    public boolean verifyPin(int enteredPin)
    {
        return (pin == enteredPin);
    }

    public void deposit(double amount)
    {
        balance = balance + amount;

        transactionHistory.add("Deposited: "+amount);
    }

    public boolean withdraw(double amount)
    {
        double minBalance = 1000;

        if((balance - amount) < minBalance)
        {
            System.out.println("Maintain minimum of Rs 1000 balance in account");
        }

        if((balance - amount) >= 0)                             // validation for overdrafts
        {
            balance = balance - amount;

            transactionHistory.add("Withdrawn : "+amount);

            return true;
        }
        else                                                    
        {
            System.out.println("Insufficient Balance\n");
            return false;
        }

    }

    public void displayTransactions()
    {
        if(transactionHistory.isEmpty())
        {
            System.out.println("There are no transactions to print\n");
            return;
        }
        else
        {
            System.out.println("Transaction History is: \n");
            for(String transaction: transactionHistory)
            {

                System.out.println(transaction);
            }
        }
    }

    // overriding toString method
    @Override
    public String toString()
    {
        return "Account No: "+accNo+
                "\n Customer Name: "+customerName+
                "\n Current Balance: "+balance+"\n";
    }


}   // end of BankAccount

//----------------------------------------------------------------------------------------------------------------------------------------
//                          class                                   Role
//                          Banking                                 Handles Menu logic and User Interaction
//----------------------------------------------------------------------------------------------------------------------------------------

class Banking
{
    private ArrayList<BankAccount> accounts; 
    private int accountCounter = 1000;

    public Banking()
    {
        accounts = new ArrayList<>();
    }

    
    public void createAccount(Scanner sobj)
    {
        sobj.nextLine();
        double balance = 0.0;

        System.out.print("Enter Account Holder Name : ");
        String customerName = sobj.nextLine();

        System.out.print("Set 4 Digit PIN : ");
        int pin = sobj.nextInt();

        try
        {
            System.out.print("Enter Initial Deposit : ");
            balance = sobj.nextDouble();

            if(balance < 1000)
            {
                System.out.println("Minimum balance should be ₹1000\n");
                return;
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("Please enter a numeric amount");
            sobj.nextLine();
            return;
        }

        BankAccount account = new BankAccount(accountCounter++, customerName, balance, pin);

        accounts.add(account);

        System.out.println("Account Creation process successfully done.Submit all KYC details required\n");
        System.out.println("Account Number : " + account.getAccNo());

    }

    public BankAccount SearchAccount(int accNo)
    {
        for(BankAccount a: accounts)
        {
            if(a.getAccNo() == accNo)
            {
                return a;
            }
        }
        
        return null;
    }

    public void deposit(Scanner sobj)
    {
        System.out.println("Enter account Number: ");
        int accountNo = sobj.nextInt();

        BankAccount account = SearchAccount(accountNo);

        if(account == null)
        {
            System.out.println("Account not found\n");
            return;
        }

        System.out.println("Enter deposit amount: ");
        double amount = sobj.nextDouble();

        if(amount <= 0)
        {
            System.out.println("Invalid amount\n");
            return;
        }

        account.deposit(amount);

        System.out.println("Account successfully credited with amount: "+amount);
        System.out.println("Updated balace: "+account.getBalance());
    }

    public void withdraw(Scanner sobj)
    {
        System.out.println("Enter account Number: ");
        int accountNo = sobj.nextInt();

        BankAccount account = SearchAccount(accountNo);

        if(account == null)                                           // validation for account
        {
            System.out.println("Account not found\n");
            return;
        }

        System.out.println("Enter PIN");
        int pin = sobj.nextInt();

        if(pin < 1000 || pin > 9999)                                // Validation for pin
        {
            System.out.println("PIN must be exactly 4 digits\n");
            return;
        }

        if(account.verifyPin(pin) == false)                         // validation for pin
        {
            System.out.println("Invalid Pin entered\n");
            return;
        }

        System.out.println("Enter withdrawl amount: ");
        double amount = sobj.nextDouble();

        if(amount <= 0)
        {
            System.out.println("Invalid amount\n");
            return;
        }

        boolean bFlag = account.withdraw(amount);

        if(bFlag)
        {
            System.out.println("Amount withdrawn successfully\n");
            System.out.println("Currect balance is: "+account.getBalance());
        }
        else
        {
            System.out.println("Insufficient funds or Minimum balace violation\n Contact your branch\n");
        }        
    }

    public void balanceInquiry(Scanner sobj)
    {
        System.out.println("Enter account Number: ");
        int accountNo = sobj.nextInt();

        BankAccount account = SearchAccount(accountNo);

        if(account == null)                                           // validation for account
        {
            System.out.println("Account not found\n");
            return;
        }

        System.out.println("Enter PIN");
        int pin = sobj.nextInt();

        if(pin < 1000 || pin > 9999)                                // Validation for pin
        {
            System.out.println("PIN must be exactly 4 digits\n");
            return;
        }

        if(account.verifyPin(pin) == false)                         // validation for pin
        {
            System.out.println("Invalid Pin entered\n");
            return;
        }

        if(account.getBalance() < 1000)
        {
            System.out.println("Maintain minimum balance of Rs 1000 in account\n");
        }

        System.out.println("Currect Balance is: "+account.getBalance());
    }


    public void transactionHistory(Scanner sobj)
    {
        System.out.println("Enter account number");
        int accountNo = sobj.nextInt();

        BankAccount account = SearchAccount(accountNo);

        if(account == null)
        {
            System.out.println("Account not found\n");
        }

        account.displayTransactions();
        
    }

    public void closeAccount(Scanner sobj)
    {
        System.out.println("Enter account number");
        int accountNo = sobj.nextInt();

        BankAccount account = SearchAccount(accountNo);

        if(account == null)
        {
            System.out.println("Account not found\n");
        }

        System.out.println("Enter Pin: ");
        int pin = sobj.nextInt();

        if(pin < 1000 || pin > 9999)                                // Validation for pin
        {
            System.out.println("PIN must be exactly 4 digits\n");
            return;
        }

        if(account.verifyPin(pin) == false)                         // validation for pin
        {
            System.out.println("Invalid pin\n");
            return;
        }

        if(account.getBalance() > 0)
        {
            System.out.println("Account cannot be closed");
            System.out.println("Please withdraw remaining acount: "+account.getBalance()+"\n");
            return;
        }

        accounts.remove(account);

        System.out.println("Account closed successfully\n");   
    
    }
}   //end of Banking class

//----------------------------------------------------------------------------------------------------------------------------------------
//                          class                                   Role
//                          BankingApplication                      It is main class which start application 
//                                                                  and handles menu driven code
//----------------------------------------------------------------------------------------------------------------------------------------

public class BankingApplication 
{
    public static void main(String[] args) 
    {
        int iChoice = 0;
        Scanner sobj = new Scanner(System.in);
        Banking bobj = new Banking();

        System.out.println("------------------------------------------------------------------------");
        System.out.println("------------Welcome to our Banking Application--------------------------");
        System.out.println("------------------------------------------------------------------------");

        while(true)
        {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Inquiry");
            System.out.println("5. Transaction History");
            System.out.println("6. Close Account");
            System.out.println("7. Exit");
            
            try
            {
                System.out.print("Please select option : ");
                iChoice = sobj.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid choice. Please enter a number.");
                sobj.nextLine();
                continue;
            }

            if(iChoice < 1 || iChoice > 7)                                    // validation for menu
            {
                System.out.println("Please enter a choice between 1 and 7");
                continue;
            }

            switch(iChoice)
            {
                case 1:
                    bobj.createAccount(sobj);
                    break;

                case 2:
                    bobj.deposit(sobj);
                    break;

                case 3:
                    bobj.withdraw(sobj);
                    break;

                case 4:
                    bobj.balanceInquiry(sobj);
                    break;

                case 5:
                    bobj.transactionHistory(sobj);
                    break;

                case 6:
                    bobj.closeAccount(sobj);
                    break;

                case 7:
                    System.out.println("Thank You For Using our Banking Application");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
        
            }   // end of switch
        }   // end of while
    }   // end of main    
}   // end of BankingApplication
