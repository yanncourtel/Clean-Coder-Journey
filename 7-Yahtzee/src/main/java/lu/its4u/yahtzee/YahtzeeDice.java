package lu.its4u.yahtzee;

public class YahtzeeDice extends Dice{

    boolean kept;
    int index;

    public YahtzeeDice(int index) {
        this.index = index;
    }

    public void keep(){
        kept=true;
    }

    public void replay(){
        kept=false;
    }

    public void reset() {
        value = null;
        kept = false;
    }
}
