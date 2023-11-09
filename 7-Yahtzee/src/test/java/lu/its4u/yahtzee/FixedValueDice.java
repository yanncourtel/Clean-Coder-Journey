package lu.its4u.yahtzee;

public class FixedValueDice extends Dice {

    public FixedValueDice(int value) {
        this.value = value;
    }

    @Override
    public void roll() {
        // Do nothing
    }
}
