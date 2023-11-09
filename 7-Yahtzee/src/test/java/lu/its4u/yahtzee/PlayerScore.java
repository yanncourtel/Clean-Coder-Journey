package lu.its4u.yahtzee;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class PlayerScore {

    public static final int BONUS = 35;
    
    private Map<Rule, Integer> scores = new HashMap<>(Map.of(
        new SumOfOneRule(), 0,
        new SumOfTwoRule(), 0,
        new SumOfThreeRule(), 0,
        new SumOfFourRule(), 0,
        new SumOfFiveRule(), 0,
        new SumOfSixRule(), 0
    ));

    public void save(String ruleName, Set<Dice> dices) {

    }

    public Map<Rule, Integer> preview(Set<Dice> dices) {
        return Map.of();
    }

    public int getSumBonus() {
        int sumTotal = this.scores.entrySet().stream()
            .filter(e -> e.getKey().getName().startsWith("Somme"))
            .map(Entry::getValue)
            .mapToInt(Integer::intValue)
            .sum();

        return sumTotal < 64 ? 0 : BONUS;
    }

    public int getTotal() {
        int rulesTotal = this.scores.entrySet().stream()
            .map(Entry::getValue)
            .mapToInt(Integer::intValue)
            .sum();

        return rulesTotal + this.getSumBonus();
    }

    public Map<Rule, Integer> getScores() {
        return this.scores;
    }
}
