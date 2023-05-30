package theatricalplays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class StatementPrinterTests {

    @Test
    void exempleAmountOwedTvaFR() {
        Map<String, Play> plays = Map.of(
                "hamlet",  new TragedyPlay("Hamlet"),
                "as-like", new ComedyPlay("As You Like It"),
                "othello", new TragedyPlay("Othello"));

        Invoice invoice = new Invoice("FR_BigCo", List.of(
                new Performance(plays.get("hamlet"), 55),
                new Performance(plays.get("as-like"), 35),
                new Performance(plays.get("othello"), 40)));

        StatementPrinter statementPrinter = new StatementPrinter();
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
        Map<String, Play> plays = Map.of(
                "hamlet",  new TragedyPlay("Hamlet"),
                "as-like", new ComedyPlay("As You Like It"),
                "othello", new TragedyPlay("Othello"));

        Invoice invoice = new Invoice("LU_LuxEntertainement", List.of(
                new Performance(plays.get("hamlet"), 55),
                new Performance(plays.get("as-like"), 35),
                new Performance(plays.get("othello"), 40)));

        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice);

        //TODO: Probably needs some rework...
        var amountString = "Amount owed is $";
        var finalString = "You earned";
        var actual = result.substring(result.indexOf(amountString) + amountString.length(), result.indexOf(finalString)).trim();
        Assertions.assertEquals("1,781.90", actual);
    }

    @Test
    void exempleAmountOwedTvaBE() {
        Map<String, Play> plays = Map.of(
                "hamlet",  new TragedyPlay("Hamlet"),
                "as-like", new ComedyPlay("As You Like It"),
                "othello", new TragedyPlay("Othello"));

        Invoice invoice = new Invoice("BE_test", List.of(
                new Performance(plays.get("hamlet"), 55),
                new Performance(plays.get("as-like"), 35),
                new Performance(plays.get("othello"), 40)));

        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice);

        //TODO: Probably needs some rework...
        var amountString = "Amount owed is $";
        var finalString = "You earned";
        var actual = result.substring(result.indexOf(amountString) + amountString.length(), result.indexOf(finalString)).trim();
        Assertions.assertEquals("2,093.30", actual);
    }

    @Test
    void exempleExtraForMoreTenPlays() {
        Map<String, Play> plays = Map.of(
                "hamlet",  new TragedyPlay("Hamlet"),
                "as-like", new ComedyPlay("As You Like It"),
                "othello", new TragedyPlay("Othello"));

        Invoice invoice = new Invoice("BE_test", List.of(
                new Performance(plays.get("as-like"), 35),
                new Performance(plays.get("as-like"), 35),
                new Performance(plays.get("as-like"), 35),
                new Performance(plays.get("as-like"), 35),
                new Performance(plays.get("as-like"), 35),
                new Performance(plays.get("as-like"), 35),
                new Performance(plays.get("as-like"), 35),
                new Performance(plays.get("as-like"), 35),
                new Performance(plays.get("as-like"), 35),
                new Performance(plays.get("as-like"), 35),
                new Performance(plays.get("othello"), 35)));

        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice);

        //TODO: Probably needs some rework...
        var amountString = "Amount owed is $";
        var finalString = "You earned";
        var actual = result.substring(result.indexOf(amountString) + amountString.length(), result.indexOf(finalString)).trim();
        Assertions.assertEquals("7,589.72", actual);
    }
}
