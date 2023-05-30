package theatricalplays;

public class ComedyPlay extends Play {
    public ComedyPlay(String name) {
        super(name, "comedy");
    }

    @Override
    public double calculateAmount(int audience) {
        double thisAmount = 30000d;
        if (audience > 20) {
            thisAmount += 10000 + 500 * (audience - 20);
        }
        thisAmount += 300 * audience;
        return thisAmount;
    }

    @Override
    public double calculateExtraCredit(int audience) {
        return Math.floor(audience / 5);
    }
}
