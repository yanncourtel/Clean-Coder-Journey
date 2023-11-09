package lu.its4u.yahtzee;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumOfOneRuleTest {

    @Test
    void shouldEvaluateTo0WithNoOne() {
        Assertions.assertEquals(0, new SumOfOneRule().evaluate(Set.of(
            new FixedValueDice(5),
            new FixedValueDice(5),
            new FixedValueDice(5),
            new FixedValueDice(5),
            new FixedValueDice(5)
        )));
    }

    @Test
    void shouldEvaluateTo3With3DiceToOne() {
        Assertions.assertEquals(3, new SumOfOneRule().evaluate(Set.of(
            new FixedValueDice(5),
            new FixedValueDice(1),
            new FixedValueDice(1),
            new FixedValueDice(1),
            new FixedValueDice(5)
        )));
    }

    @Test
    void shouldEvaluateTo0WithNoTwo() {
        Assertions.assertEquals(0, new SumOfTwoRule().evaluate(Set.of(
            new FixedValueDice(5),
            new FixedValueDice(5),
            new FixedValueDice(5),
            new FixedValueDice(5),
            new FixedValueDice(5)
        )));
    }

    @Test
    void shouldEvaluateTo3With2DicesToTwo() {
        Assertions.assertEquals(4, new SumOfTwoRule().evaluate(Set.of(
            new FixedValueDice(5),
            new FixedValueDice(2),
            new FixedValueDice(1),
            new FixedValueDice(2),
            new FixedValueDice(5)
        )));
    }
}
