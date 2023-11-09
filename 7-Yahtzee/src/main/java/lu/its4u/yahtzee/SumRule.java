package lu.its4u.yahtzee;

import java.util.Set;

public abstract class SumRule extends Rule {

    private int value;

    public SumRule(int value) {
        super("Somme de " + value);
        this.value = value;
    }
    
    @Override
    public final int evaluate(Set<Dice> dices) {
        return dices.stream()
            .map(Dice::getValue)
            .filter(v -> v == this.value)
            .mapToInt(Integer::intValue)
            .sum();
    }
}
