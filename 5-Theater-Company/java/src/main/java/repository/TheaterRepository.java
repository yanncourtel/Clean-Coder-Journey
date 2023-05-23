package repository;

import theatricalplays.Invoice;
import theatricalplays.Performance;
import theatricalplays.Play;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TheaterRepository {

    public static List<String> DB_Customer = new ArrayList<>();

    public static List<Invoice> DB_Invoice =  new ArrayList<>();

    public static Map<String, Play> plays = Map.of(
            "hamlet",  new Play("Hamlet", "tragedy"),
                "as-like", new Play("As You Like It", "comedy"),
                "othello", new Play("Othello", "tragedy"));

    public TheaterRepository() {
        initDb();
    }

    private void initDb(){
        DB_Customer.add("FR_Patee");
        DB_Customer.add("LU_Schienergienen");
        DB_Customer.add("LU_LuxEntertainement");
        DB_Customer.add("BE_LesFunsWallons");
        DB_Customer.add("FR_CirqueZapata");

        //Invoices are stored by country
        //FRANCE
        DB_Invoice.add(new Invoice("FR_Patee", List.of(
                new Performance("hamlet", 55),
                new Performance("as-like", 230),
                new Performance("othello", 402))));
        DB_Invoice.add(new Invoice("FR_CirqueZapata", List.of(
                new Performance("hamlet", 683),
                new Performance("hamlet", 1260),
                new Performance("as-like", 350),
                new Performance("othello", 890))));

        //LUXEMBOURG
        DB_Invoice.add(new Invoice("LU_LuxEntertainement", List.of(
                new Performance("hamlet", 30),
                new Performance("as-like", 121))));
        DB_Invoice.add(new Invoice("LU_Schienergienen", List.of(
                new Performance("hamlet", 70),
                new Performance("hamlet", 89),
                new Performance("othello", 145))));

        //BELGIUM
        DB_Invoice.add(new Invoice("BE_LesFunsWallons", List.of(
                new Performance("as-like", 26),
                new Performance("as-like", 55),
                new Performance("as-like", 48))));
    }

    public List<Invoice> AllInvoices(String customer) {
        //inmemory implementation : code to change if new invoice
        return TheaterRepository.DB_Invoice.stream()
                .filter(i -> customer.equals(i.customer))
                .toList();
    }

    public List<String> CustomersFromDb(){
        return TheaterRepository.DB_Customer;
    }
}
