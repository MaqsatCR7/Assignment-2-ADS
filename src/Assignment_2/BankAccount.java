package Assignment_2;

public class BankAccount {
        String accountNumber;
        String username;
        double balance;

        public BankAccount(String accountNumber, String username, double balance) {
            this.accountNumber = accountNumber;
            this.username = username;
            this.balance = balance;
        }

        @Override
        public String toString() {
            return "Account: " + accountNumber + " | User: " + username + " | Balance: " + balance;
        }
}
