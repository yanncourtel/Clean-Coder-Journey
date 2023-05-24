package app;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MainTest {
//    Statement for FR_Patee
//    Hamlet: $650.00 (55 seats)
//    As You Like It: $2,140.00 (230 seats)
//    Othello: $4,120.00 (402 seats)
//    Amount owed is $7,290.05
//    You earned 643 credits

    @Test
    void invoiceFromFrCustomer() {
        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        Main.main(new String[]{"FR_Patee"});
        Approvals.verify(baos.toString());
        System.setOut(old);

    }

//    @Test
//    void invoiceFromEmptyCustomer() {
//        // Create a stream to hold the output
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        PrintStream ps = new PrintStream(baos);
//        PrintStream old = System.out;
//        System.setOut(ps);
//
//        Main.main(null);
//        Approvals.verify(baos.toString());
//        System.setOut(old);
//
//    }
    @Test
    void invoiceFromLuCustomer() {
        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        Main.main(new String[]{"LU_Schienergienen"});
        Approvals.verify(baos.toString());
        System.setOut(old);

    }
    @Test
    void invoiceFromBeCustomer() {
        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        Main.main(new String[]{"BE_LesFunsWallons"});
        Approvals.verify(baos.toString());
        System.setOut(old);

    }
}