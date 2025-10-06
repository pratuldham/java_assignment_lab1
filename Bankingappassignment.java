import java.util.*; // importing scanner library to enable input and output functionality

//creating account class
class Account {

    // defining necessary variables and making them private so that other functions cant access and alter the variables.
    private int accNum;
    private String accHoldername;
    private double bal;
    private String phNum;
    private String email;

    // creating constructor Account.
    public Account(int accNum, String accHoldername, double bal, String phNum, String email){
        this.accNum = accNum;
        this.accHoldername = accHoldername;
        this.bal = bal;
        this.phNum = phNum;
        this.email = email;
    }

    //deposit money method:
    public void deposit(double amount){
        if(amount > 0){
            bal += amount;      // bal = bal + amount
            System.out.println("Amount deposited! Total bal: " + bal);
        }else{
            System.out.println("Deposit amount can't be nagative or equal to zero.");
        }
    }

    // withdrawl money method:
    public void withdraw(double amount){
        if(amount > 0){
            if(bal >=amount){
                bal -= amount;      // same as bal = bal - amount
                System.out.println("Amount withdrawn. balance: " + bal);
            }else{
                System.out.println("Withdrawl amount can't be negative!");
            }
        }else{
            System.out.println("Insufficient amount");
        }   
    }
    
    // Method to display account details:
    public void displayAccountDetails(){
        System.out.println("Account Number: " + accNum);
        System.out.println("Account Holder Name: " + accHoldername);
        System.out.println("bal: " + bal);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phNum);
    }
    // Method to update contact details:
    public void updateContactDetails(String email, String phNum){
        this.email = email;
        this.phNum = phNum;
        System.out.println("Contact details updated succesfully!");
    }

    public int getaccNum(){
        return accNum;
    }
}

// Main class
public class Bankingappassignment {
    private Account[] accounts = new Account[10];
    private int accountCount = 0;
    private int nextaccNum = 1;
    private Scanner scanner = new Scanner(System.in);

    // create new account.
    public void createAccount(){
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Initial Deposit amount: ");
        double bal = scanner.nextDouble();

        scanner.nextLine();

        System.out.print("Enter Email address: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        Account newAccount = new Account(nextaccNum, name, bal, email, phone);
        accounts[accountCount] = newAccount;

        accountCount++;
        System.out.println("Account created successfully with account number: " + nextaccNum);
        nextaccNum++;
    }
    
    // find account by account number:
    private Account findAccount(int accno){
        for(int i = 0; i < accountCount; i++){
            if(accounts[i].getaccNum() == accno){
                return accounts[i];
            }
        }
        return null;
    }

    // Deposit:
    public void performDeposit(){
        System.out.print("Enter account number: ");
        int accno = scanner.nextInt();

        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Account acc = findAccount(accno);
        if(acc!= null){
            acc.deposit(amount);
        }else{
            System.out.println("Account not found!");
        }
    }

    // Withdraw:
    public void performWithdraw(){
        System.out.print("Enter account number: ");
        int accno = scanner.nextInt();

        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Account acc = findAccount(accno);
        if(acc!= null){
            acc.withdraw(amount);
        }else{
            System.out.println("Account not found!");
        }
    }
    // Show account details:
    public void showAccountDetails(){
        System.out.print("Enter account number: ");
        int accno = scanner.nextInt();
        scanner.nextLine();

        Account acc = findAccount(accno);
        if(acc != null){
            acc.displayAccountDetails();
        }else{
            System.out.println("Account not found!");
        }
    }

    //Update contact details:
    public void updateContact(){
        System.out.print("Enter account number: ");
        int accno = scanner.nextInt();
        scanner.nextLine();

        Account acc = findAccount(accno);
        if(acc!=null){
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();

            System.out.print("Enter new phone number :");
            String phone = scanner.nextLine();

            acc.updateContactDetails(email, phone);
        }else{
            System.out.println("Account not found!");
        }
    }

    //Main menu: 
    public void mainmenu(){
        while (true){
            System.out.println("\n-------------------Banking Application!-------------------");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: performDeposit(); break;
                case 3: performWithdraw(); break;
                case 4: showAccountDetails(); break;
                case 5: updateContact(); break;
                case 6: System.out.println("-------------------Exited!-------------------"); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
    public static void main(String[] args) {
        Bankingappassignment app = new Bankingappassignment();
        app.mainmenu();
    }
}
