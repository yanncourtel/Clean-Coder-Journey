package theatricalplays;

public class InvoiceLine {
    private double amount;
    private String playName;
    private int audience;
    private double tva;

    public InvoiceLine( String playName, double amount, int audience) {
        this.amount = amount;
        this.playName = playName;
        this.audience = audience;
    }

    @Override
    public String toString() {
        return String.format("  %s: %s ; TVA : %s (%s seats)\n",
                getPlayName(),
                NumberToStringUtils.toFormattedNumber(getAmount()),
                NumberToStringUtils.toFormattedNumber(getTva()),
                getAudience());
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public int getAudience() {
        return audience;
    }

    public void setAudience(int audience) {
        this.audience = audience;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double amountWithTva) {
        this.tva = amountWithTva;
    }
}
