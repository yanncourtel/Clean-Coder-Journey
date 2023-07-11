package theatricalplays;

public class StatementPrinter {

    public String print(Invoice invoice) {
        var result = new StringBuilder(String.format("Statement for %s\n", invoice.customer));

        for (InvoiceLine line: invoice.invoiceLines) result.append(line.toString());

        result.append(String.format("Amount owed is %s\n", NumberToStringUtils.toFormattedNumber(invoice.getTotalAmount())));
        result.append(String.format("You earned %s credits\n", invoice.getVolumeCredits()));

        return result.toString();
    }
}

