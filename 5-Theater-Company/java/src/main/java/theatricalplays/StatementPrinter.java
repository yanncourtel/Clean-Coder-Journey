package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public String print(Invoice invoice, Map<String, Play> plays) {
        var result = new StringBuilder(String.format("Statement for %s\n", invoice.customer));

        NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

        var totalAmount = invoice.calculateTotalAmount(plays, result, frmt);

        totalAmount /= 100;

        totalAmount = calculateTva(totalAmount, invoice.customer.substring(0, 2));

        result.append(String.format("Amount owed is %s\n", frmt.format(totalAmount)));
        result.append(String.format("You earned %s credits\n", invoice.volumeCredits));
        return result.toString();
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
