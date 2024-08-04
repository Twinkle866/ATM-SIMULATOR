import java.util.ArrayList;  // Import ArrayList to store transaction history
import java.util.Scanner;    // Import Scanner to read user input

public class ATM {
    private double balance; // Variable to store account balance
    private String pin;     // Variable to store account PIN
    private ArrayList<String> transactionHistory; // ArrayList to store transaction history

    // Constructor to initialize the ATM with initial balance and PIN
    public ATM(double initialBalance, String initialPin) {
        this.balance = initialBalance;       // Set the initial balance
        this.pin = initialPin;               // Set the initial PIN
        this.transactionHistory = new ArrayList<>(); // Initialize the transaction history list
        transactionHistory.add("Account created with balance: " + initialBalance); // Record account creation
    }

    // Method to check and display the account balance
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance); // Print the balance
        transactionHistory.add("Checked balance: $" + balance);     // Record the balance check
    }

    // Method to withdraw cash from the account
    public void withdrawCash(double amount) {
        if (amount <= balance) { // Check if there's enough balance to withdraw
            balance -= amount;   // Subtract the amount from balance
            System.out.println("Successfully withdrew $" + amount); // Print success message
            transactionHistory.add("Withdrew: $" + amount); // Record the withdrawal
        } else {
            System.out.println("Insufficient balance."); // Print insufficient balance message
        }
    }

    // Method to deposit cash into the account
    public void depositCash(double amount) {
        balance += amount;   // Add the amount to balance
        System.out.println("Successfully deposited $" + amount); // Print success message
        transactionHistory.add("Deposited: $" + amount); // Record the deposit
    }

    // Method to change the account PIN
    public void changePin(String newPin) {
        pin = newPin;        // Update the PIN
        System.out.println("PIN successfully changed."); // Print success message
        transactionHistory.add("PIN changed."); // Record the PIN change
    }

    // Method to show the transaction history
    public void showTransactionHistory() {
        System.out.println("Transaction History:"); // Print transaction history header
        for (String transaction : transactionHistory) { // Loop through each transaction
            System.out.println(transaction); // Print each transaction
        }
    }

    // Method to validate the entered PIN
    public boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin); // Return true if entered PIN matches stored PIN
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read input
        ATM atm = new ATM(1000, "1234"); // Create a new ATM object with initial balance $1000 and PIN "1234"

        System.out.println("Welcome to the ATM Simulator!"); // Print welcome message

        while (true) { // Infinite loop for the ATM menu
            System.out.println("\nPlease select an option:"); // Print menu options
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            int choice = scanner.nextInt(); // Read user choice

            switch (choice) { // Handle user choice
                case 1:
                    System.out.println("Enter PIN:"); // Prompt for PIN
                    String pin = scanner.next(); // Read entered PIN
                    if (atm.validatePin(pin)) { // Validate the PIN
                        atm.checkBalance(); // Check and display balance if PIN is correct
                    } else {
                        System.out.println("Invalid PIN."); // Print error message if PIN is incorrect
                    }
                    break;

                case 2:
                    System.out.println("Enter PIN:"); // Prompt for PIN
                    pin = scanner.next(); // Read entered PIN
                    if (atm.validatePin(pin)) { // Validate the PIN
                        System.out.println("Enter amount to withdraw:"); // Prompt for amount to withdraw
                        double amount = scanner.nextDouble(); // Read entered amount
                        atm.withdrawCash(amount); // Withdraw cash if PIN is correct
                    } else {
                        System.out.println("Invalid PIN."); // Print error message if PIN is incorrect
                    }
                    break;

                case 3:
                    System.out.println("Enter PIN:"); // Prompt for PIN
                    pin = scanner.next(); // Read entered PIN
                    if (atm.validatePin(pin)) { // Validate the PIN
                        System.out.println("Enter amount to deposit:"); // Prompt for amount to deposit
                        double amount = scanner.nextDouble(); // Read entered amount
                        atm.depositCash(amount); // Deposit cash if PIN is correct
                    } else {
                        System.out.println("Invalid PIN."); // Print error message if PIN is incorrect
                    }
                    break;

                case 4:
                    System.out.println("Enter current PIN:"); // Prompt for current PIN
                    pin = scanner.next(); // Read entered PIN
                    if (atm.validatePin(pin)) { // Validate the current PIN
                        System.out.println("Enter new PIN:"); // Prompt for new PIN
                        String newPin = scanner.next(); // Read new PIN
                        atm.changePin(newPin); // Change PIN if current PIN is correct
                    } else {
                        System.out.println("Invalid PIN."); // Print error message if current PIN is incorrect
                    }
                    break;

                case 5:
                    System.out.println("Enter PIN:"); // Prompt for PIN
                    pin = scanner.next(); // Read entered PIN
                    if (atm.validatePin(pin)) { // Validate the PIN
                        atm.showTransactionHistory(); // Show transaction history if PIN is correct
                    } else {
                        System.out.println("Invalid PIN."); // Print error message if PIN is incorrect
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the ATM Simulator. Goodbye!"); // Print exit message
                    scanner.close(); // Close the scanner
                    return; // Exit the program

                default:
                    System.out.println("Invalid choice. Please try again."); // Print error message for invalid choice
                    break;
            }
        }
    }
}
