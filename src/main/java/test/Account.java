package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The test.Account class represents a bank account with a list of transactions.
 */
public class  Account {
    private final List<Transaction> transactions = new ArrayList<Transaction>();

    /**
     * Deposits a specified amount into the account on a given date.
     *
     * @param amount the amount to deposit
     * @param date the date of the deposit
     */
    public void deposit(int amount, String date) {
        transactions.add(new Transaction(date, amount));
    }

    /**
     * Withdraws a specified amount from the account on a given date.
     *
     * @param amount the amount to withdraw
     * @param date the date of the withdrawal
     */
    public void withdraw(int amount, String date) {
        transactions.add(new Transaction(date, -amount));
    }

    /**
     * Prints the account statement, showing the date, amount, and balance of each transaction.
     */
    public void printStatement() {
        List<Transaction> reversedTransactions = new ArrayList<>(transactions);
        Collections.reverse(reversedTransactions); // Reverse the list to display transactions in chronological order

        int balance = transactions.stream().mapToInt(Transaction::getAmount).sum();

        System.out.println("DATE       | AMOUNT  | BALANCE");
        for (Transaction transaction : reversedTransactions) {
            System.out.printf("%s | %7d | %7d%n", transaction.getDate(), transaction.getAmount(), balance);
            balance -= transaction.getAmount(); // Update the balance for the next transaction
        }
    }
}





