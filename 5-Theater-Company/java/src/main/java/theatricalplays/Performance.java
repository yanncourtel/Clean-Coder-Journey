package theatricalplays;

public class Performance {

    public Play play;
    public int audience;

    public Performance(Play play, int audience) {
        this.play = play;
        this.audience = audience;
    }

    public double calculateAmount() {
        return play.calculateAmount(this.audience);
    }

    public int calculateCredit() {
        return play.calculateCredit(this.audience);
    }
}
