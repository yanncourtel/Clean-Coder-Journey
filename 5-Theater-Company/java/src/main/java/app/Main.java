package app;

import repository.TheaterRepository;
import theatricalplays.Invoice;
import theatricalplays.StatementPrinter;

import java.util.List;
import java.util.Optional;

public class Main {

    //TO CHANGE the customer name to display all invoices
    public static String customer = "FR_Patee";

    public static TheaterRepository db = new TheaterRepository();

    public static void main(String[] args) {
        StatementPrinter printer = new StatementPrinter();
        if (args != null && args.length >0){
          customer = args[0];
        }
        List<Invoice> invoices = db.AllInvoices(Optional.ofNullable(args)
                .filter(a -> a.length > 0)
                .map(a -> a[0])
                .orElse(customer)
        );

        invoices.forEach(i -> System.out.println(printer.print(i, TheaterRepository.plays)));
    }
}
