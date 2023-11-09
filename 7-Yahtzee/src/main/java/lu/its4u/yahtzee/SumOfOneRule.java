package lu.its4u.yahtzee;

import java.util.Set;

public class SumOfOneRule extends Rule {

    public SumOfOneRule() {
        super("Somme de 1");
    }

    @Override
    public int evaluate(Set<Dice> dices) {
        return dices.stream()
            .map(Dice::getValue)
            .filter(v -> v == 1)
            .mapToInt(Integer::intValue)
            .sum();
    }
    
}
