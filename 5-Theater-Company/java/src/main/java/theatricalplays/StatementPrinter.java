package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {

    public String print(Invoice invoice) {
        var result = new StringBuilder(String.format("Statement for %s\n", invoice.customer));

        NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);
        invoice.calculateTotalAmount();
        var totalAmount = invoice.getTotalAmount();
        for (InvoiceLine line: invoice.invoiceLines) {
            result.append(String.format("  %s: %s ; TVA : %s (%s seats)\n", line.playName, frmt.format(line.amount),frmt.format(line.tva), line.audience));

        }

        totalAmount = totalAmount * invoice.getTvaRate();
        result.append(String.format("Amount owed is %s\n", frmt.format(totalAmount)));
        result.append(String.format("You earned %s credits\n", invoice.volumeCredits));
        return result.toString();
    }

}
