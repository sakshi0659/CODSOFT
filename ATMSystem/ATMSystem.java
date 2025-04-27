import java.util.Scanner;

// This class should be separate and NOT public
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount) {
        if (amount>0){
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    public boolean withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
            return true;
        }else {
            System.out.println("Insufficient balance or invalid amount!");
            return false;
        }
    }
}
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number (1-4): ");
                scanner.next();}
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 4.");
            }
        } while (option != 4);
    }
    private void checkBalance(){
        System.out.printf("Your current balance is: $%.2f%n", account.getBalance());
    }
    private void deposit(){
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }
    private void withdraw(){
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}
public class ATMSystem {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(500.00); 
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}
