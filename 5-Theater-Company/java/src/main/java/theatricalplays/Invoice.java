package theatricalplays;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

public class Invoice {

    public String customer;
    public List<Performance> performances;
    public int volumeCredits;

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    public double calculateTotalAmount(Map<String, Play> plays, StringBuilder result, NumberFormat frmt) {
        var totalAmount = 0d;
        var index = 0;

        for (var perf : this.performances) {
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
            this.volumeCredits += Math.max(perf.audience - 30, 0);
            // add extra credit for every ten comedy attendees
            if ("comedy".equals(play.type)) this.volumeCredits += Math.floor(perf.audience / 5);

            //Apply supplementary 5% for every play after the 10
            if( index > 10) {
                thisAmount = thisAmount*1.05;
            }

            // print line for this order
            result.append(String.format("  %s: %s (%s seats)\n", play.name, frmt.format(thisAmount / 100), perf.audience));

            totalAmount += thisAmount;
        }

        return totalAmount;
    }
}
