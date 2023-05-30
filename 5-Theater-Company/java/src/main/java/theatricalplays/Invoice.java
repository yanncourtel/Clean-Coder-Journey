package theatricalplays;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

    public String customer;
    public List<Performance> performances;
    public double totalAmount;
    public List<InvoiceLine> invoiceLines = new ArrayList<>();
    public int volumeCredits;
    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    public void calculateTotalAmount() {
        var index = 0;

        for (var perf : this.performances) {
            var thisAmount = 0d;
            index++;

            thisAmount = perf.calculateAmount();

            volumeCredits += perf.calculateCredit();

            //Apply supplementary 5% for every play after the 10
            if( index > 10) {
                thisAmount = thisAmount*1.05;
            }
            thisAmount = thisAmount/100;
            // print line for this order
            var invoiceLine = new InvoiceLine(perf.play.name, thisAmount, perf.audience);
            invoiceLine.setTva( thisAmount * (this.getTvaRate()-1));
            invoiceLines.add(invoiceLine);

            totalAmount += thisAmount;
        }
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getTvaRate() {
        return switch (customer.substring(0, 2)) {
            case "BE" -> 1.21;
            case "FR" -> 1.055;
            case "LU" -> 1.03;
            default -> 1;
        };
    }
}
