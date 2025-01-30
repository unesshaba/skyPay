package test;


import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

class AccountTest {
    private Account account;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        account = new Account();
        System.setOut(new PrintStream(outContent)); // Capture the console output
    }

    @Test
    void testDeposit() {
        account.deposit(1000, "10-01-2012");
        account.printStatement();

        String expectedOutput =
                "DATE       | AMOUNT  | BALANCE\n" +
                        "10-01-2012 |    1000 |    1000\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testWithdraw() {
        account.deposit(1000, "10-01-2012");
        account.withdraw(500, "11-01-2012");
        account.printStatement();

        String expectedOutput =
                "DATE       | AMOUNT  | BALANCE\n" +
                        "11-01-2012 |    -500 |     500\n" +
                        "10-01-2012 |    1000 |    1000\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testMultipleTransactions() {
        account.deposit(1000, "10-01-2012");
        account.deposit(2000, "13-01-2012");
        account.withdraw(500, "14-01-2012");
        account.printStatement();

        String expectedOutput =
                "DATE       | AMOUNT  | BALANCE\n" +
                        "14-01-2012 |    -500 |    2500\n" +
                        "13-01-2012 |    2000 |    3000\n" +
                        "10-01-2012 |    1000 |    1000\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}