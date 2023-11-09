package lu.its4u.yahtzee;

public class YahtzeeDice extends Dice{

    boolean kept;
    int index;

    public void keep(){
        kept=true;
    }

    public void replay(){
        kept=false;
    }
}
