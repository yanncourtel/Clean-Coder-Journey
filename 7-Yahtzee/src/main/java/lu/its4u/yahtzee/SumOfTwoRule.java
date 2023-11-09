package lu.its4u.yahtzee;

import java.util.Set;

public class SumOfTwoRule extends Rule {

    public SumOfTwoRule() {
        super("Somme de 2");
    }

    @Override
    public int evaluate(Set<Dice> dices) {
        return dices.stream()
            .map(Dice::getValue)
            .filter(v -> v == 2)
            .mapToInt(Integer::intValue)
            .sum();    }

}
