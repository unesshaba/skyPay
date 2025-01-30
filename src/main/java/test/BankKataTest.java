package test;



/**
 * The test.BankKataTest class is the entry point for the bank kata application.
 * It demonstrates the usage of the test.Account class by performing a series of deposits and withdrawals,
 * and then printing the account statement.
 */
public class BankKataTest {
    public static void main(String[] args) {
        Account account = new Account();

        // Deposit 1000 on 10-01-2012
        account.deposit(1000, "10-01-2012");

        // Deposit 2000 on 13-01-2012
        account.deposit(2000, "13-01-2012");

        // Withdraw 500 on 14-01-2012
        account.withdraw(500, "14-01-2012");

        // Print the account statement
        account.printStatement();
    }
}