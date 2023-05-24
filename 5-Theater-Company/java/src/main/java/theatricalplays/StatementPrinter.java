package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public String print(Invoice invoice, Map<String, Play> plays) {
        var totalAmount = 0d;
        var volumeCredits = 0;
        var result = String.format("Statement for %s\n", invoice.customer);

        NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

        var index = 0;
        for (var perf : invoice.performances) {
            var play = plays.get(perf.playID);
            var thisAmount = 0d;
            index++;

            switch (play.type) {
                case "tragedy":
                    thisAmount = 40000d;
                    if (perf.audience > 30) {
                        thisAmount += 1000 * (perf.audience - 30);
                    }
                    break;
                case "comedy":
                    thisAmount = 30000d;
                    if (perf.audience > 20) {
                        thisAmount += 10000 + 500 * (perf.audience - 20);
                    }
                    thisAmount += 300 * perf.audience;
                    break;
                default:
                    throw new Error("unknown type: ${play.type}");
            }

            // add volume credits
            volumeCredits += Math.max(perf.audience - 30, 0);
            // add extra credit for every ten comedy attendees
            if ("comedy".equals(play.type)) volumeCredits += Math.floor(perf.audience / 5);

            //Apply supplementary 5% for every play after the 10
            if( index > 10) {
                thisAmount = thisAmount*1.05;
            }

            // print line for this order
            result += String.format("  %s: %s (%s seats)\n", play.name, frmt.format(thisAmount / 100), perf.audience);

            totalAmount += thisAmount;
        }

        totalAmount /= 100;

        totalAmount = calculateTva(totalAmount, invoice.customer.substring(0, 2));

        result += String.format("Amount owed is %s\n", frmt.format(totalAmount));
        result += String.format("You earned %s credits\n", volumeCredits);
        return result;
    }

    private static double calculateTva(double amount, String country) {
        return amount * switch (country) {
            case "BE" -> 1.21;
            case "FR" -> 1.055;
            case "LU" -> 1.03;
            default -> 1;
        };
    }
}
