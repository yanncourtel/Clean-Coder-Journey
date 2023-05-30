package repository;

import theatricalplays.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TheaterRepository {

        public static List<String> DB_Customer = new ArrayList<>();

        public static List<Invoice> DB_Invoice = new ArrayList<>();

        public static Map<String, Play> plays = Map.of(
                "hamlet", new TragedyPlay("Hamlet"),
                "as-like", new ComedyPlay("As You Like It"),
                "othello", new TragedyPlay("Othello")
        );

        public TheaterRepository() {
                initDb();
        }

        private void initDb() {
                DB_Customer.add("FR_Patee");
                DB_Customer.add("LU_Schienergienen");
                DB_Customer.add("LU_LuxEntertainement");
                DB_Customer.add("BE_LesFunsWallons");
                DB_Customer.add("FR_CirqueZapata");

                // Invoices are stored by country
                // FRANCE
                DB_Invoice.add(new Invoice("FR_Patee", List.of(
                                new Performance(plays.get("hamlet"), 55),
                                new Performance(plays.get("as-like"), 230),
                                new Performance(plays.get("othello"), 402))));
                DB_Invoice.add(new Invoice("FR_CirqueZapata", List.of(
                                new Performance(plays.get("hamlet"), 683),
                                new Performance(plays.get("hamlet"), 1260),
                                new Performance(plays.get("as-like"), 350),
                                new Performance(plays.get("othello"), 890))));

                // LUXEMBOURG
                DB_Invoice.add(new Invoice("LU_LuxEntertainement", List.of(
                                new Performance(plays.get("hamlet"), 30),
                                new Performance(plays.get("as-like"), 121))));
                DB_Invoice.add(new Invoice("LU_Schienergienen", List.of(
                                new Performance(plays.get("hamlet"), 70),
                                new Performance(plays.get("hamlet"), 89),
                                new Performance(plays.get("othello"), 145))));

                // BELGIUM
                DB_Invoice.add(new Invoice("BE_LesFunsWallons", List.of(
                                new Performance(plays.get("as-like"), 26),
                                new Performance(plays.get("as-like"), 55),
                                new Performance(plays.get("as-like"), 48))));
        }

        public List<Invoice> AllInvoices(String customer) {
                // inmemory implementation : code to change if new invoice
                return TheaterRepository.DB_Invoice.stream()
                                .filter(i -> customer.equals(i.customer))
                                .toList();
        }

        public List<String> CustomersFromDb() {
                return TheaterRepository.DB_Customer;
        }
}
