package theatricalplays;

public abstract class Play {

    public String name;
    public String type;

    public Play(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public abstract double calculateAmount(int audience);

    public double calculateExtraCredit(int audience) {
        return 0;
    }

    public final int calculateCredit(int audience) {
        var credit = Math.max(audience - 30, 0);
        credit += calculateExtraCredit(audience);

        return credit;
    }
}
