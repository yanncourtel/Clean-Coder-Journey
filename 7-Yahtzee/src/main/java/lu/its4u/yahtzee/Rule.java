package lu.its4u.yahtzee;

import java.util.Set;

public abstract class Rule {
    
    private String name;

    public Rule(String name) {
        this.name = name;
    }

    public abstract int evaluate(Set<Dice> dices);

    public String getName() {
        return name;
    }
}
