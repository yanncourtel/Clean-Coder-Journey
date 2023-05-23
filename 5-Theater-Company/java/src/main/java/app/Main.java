package app;

import repository.TheaterRepository;
import theatricalplays.Invoice;
import theatricalplays.StatementPrinter;

import java.util.List;

public class Main {

    //TO CHANGE the customer name to display all invoices
    public static String customer = "FR_Patee";

    public static TheaterRepository db = new TheaterRepository();

    public static void main(String[] args) {
        StatementPrinter printer = new StatementPrinter();

        List<Invoice> invoices = db.AllInvoices(customer);

        invoices.forEach(i -> System.out.println(printer.print(i, TheaterRepository.plays)));
    }
}
