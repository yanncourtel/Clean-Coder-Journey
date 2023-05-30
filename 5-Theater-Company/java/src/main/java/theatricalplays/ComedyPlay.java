package theatricalplays;

public class TragedyPlay extends Play {
    public TragedyPlay(String name) {
        super(name, "tragedy");
    }

    @Override
    public double calculateAmount(int audience) {
        double thisAmount = 40000d;
        if (audience > 30) {
            thisAmount += 1000 * (audience - 30);
        }
        return thisAmount;
    }
}
