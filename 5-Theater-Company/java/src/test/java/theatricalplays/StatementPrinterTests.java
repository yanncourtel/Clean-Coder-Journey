package theatricalplays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StatementPrinterTests {

    private List<Performance> performances = List.of(
            new Performance(new TragedyPlay("Hamlet"), 55),
            new Performance(new ComedyPlay("As You Like It"), 35),
            new Performance(new TragedyPlay("Othello"), 40));
    private StatementPrinter statementPrinter = new StatementPrinter();

    @Test
    void exempleAmountOwedTvaFR() {
        Invoice invoice = new Invoice("FR_BigCo", performances);

        var result = statementPrinter.print(invoice);

        //TODO: Probably needs some rework...
        var amountString = "Amount owed is $";
        var finalString = "You earned";
        Assertions.assertEquals(
                result.substring(result.indexOf(amountString) + amountString.length(), result.indexOf(finalString)).trim(),
                "1,825.15");
    }

    @Test
    void exempleAmountOwedTvaLU() {
        Invoice invoice = new Invoice("LU_LuxEntertainement", performances);

        var result = statementPrinter.print(invoice);

        //TODO: Probably needs some rework...
        var amountString = "Amount owed is $";
        var finalString = "You earned";
        var actual = result.substring(result.indexOf(amountString) + amountString.length(), result.indexOf(finalString)).trim();
        Assertions.assertEquals("1,781.90", actual);
    }

    @Test
    void exempleAmountOwedTvaBE() {
        Invoice invoice = new Invoice("BE_test", performances);

        var result = statementPrinter.print(invoice);

        //TODO: Probably needs some rework...
        var amountString = "Amount owed is $";
        var finalString = "You earned";
        var actual = result.substring(result.indexOf(amountString) + amountString.length(), result.indexOf(finalString)).trim();
        Assertions.assertEquals("2,093.30", actual);
    }

    @Test
    void exempleExtraForMoreTenPlays() {

        Invoice invoice = new Invoice("BE_test",
                Collections
                    .nCopies(11, new Performance(Map.of(
                        "hamlet", new TragedyPlay("Hamlet"),
                        "as-like", new ComedyPlay("As You Like It"),
                        "othello", new TragedyPlay("Othello")).get("as-like"), 35))
                    .stream().toList());

        var result = statementPrinter.print(invoice);

        //TODO: Probably needs some rework...
        var amountString = "Amount owed is $";
        var finalString = "You earned";
        var actual = result.substring(result.indexOf(amountString) + amountString.length(), result.indexOf(finalString)).trim();
        Assertions.assertEquals("7,754.89", actual);
    }
}
