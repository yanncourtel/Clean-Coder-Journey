package lu.its4u.yahtzee;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RuleTest {

    @Nested
    class SumOfOne {
        
        @Test
        void shouldEvaluateTo0() {
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
    }

    @Nested
    class SumOfTwo {

        @Test
        void shouldEvaluateTo0() {
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

    @Nested
    class SumOfThree {

        @Test
        void shouldEvaluateTo0() {
            Assertions.assertEquals(0, new SumOfThreeRule().evaluate(Set.of(
                new FixedValueDice(5),
                new FixedValueDice(5),
                new FixedValueDice(5),
                new FixedValueDice(5),
                new FixedValueDice(5)
            )));
        }
    
        @Test
        void shouldEvaluateTo3With1DiceToThree() {
            Assertions.assertEquals(3, new SumOfThreeRule().evaluate(Set.of(
                new FixedValueDice(3),
                new FixedValueDice(2),
                new FixedValueDice(1),
                new FixedValueDice(2),
                new FixedValueDice(5)
            )));
        }
    }

    @Nested
    class SumOfFour {

        @Test
        void shouldEvaluateTo0() {
            Assertions.assertEquals(0, new SumOfFourRule().evaluate(Set.of(
                new FixedValueDice(5),
                new FixedValueDice(5),
                new FixedValueDice(5),
                new FixedValueDice(5),
                new FixedValueDice(5)
            )));
        }
    
        @Test
        void shouldEvaluateTo12With3DicesToTwo() {
            Assertions.assertEquals(12, new SumOfFourRule().evaluate(Set.of(
                new FixedValueDice(5),
                new FixedValueDice(4),
                new FixedValueDice(4),
                new FixedValueDice(4),
                new FixedValueDice(5)
            )));
        }
    }

    @Nested
    class SumOfFive {

        @Test
        void shouldEvaluateTo0() {
            Assertions.assertEquals(0, new SumOfFiveRule().evaluate(Set.of(
                new FixedValueDice(3),
                new FixedValueDice(3),
                new FixedValueDice(3),
                new FixedValueDice(3),
                new FixedValueDice(3)
            )));
        }
    
        @Test
        void shouldEvaluateTo1With2DicesToFive() {
            Assertions.assertEquals(10, new SumOfFiveRule().evaluate(Set.of(
                new FixedValueDice(5),
                new FixedValueDice(4),
                new FixedValueDice(4),
                new FixedValueDice(4),
                new FixedValueDice(5)
            )));
        }
    }

    @Nested
    class SumOfSix {

        @Test
        void shouldEvaluateTo0() {
            Assertions.assertEquals(0, new SumOfSixRule().evaluate(Set.of(
                new FixedValueDice(5),
                new FixedValueDice(5),
                new FixedValueDice(5),
                new FixedValueDice(5),
                new FixedValueDice(5)
            )));
        }
    
        @Test
        void shouldEvaluateTo12With3DicesToTwo() {
            Assertions.assertEquals(12, new SumOfSixRule().evaluate(Set.of(
                new FixedValueDice(5),
                new FixedValueDice(6),
                new FixedValueDice(4),
                new FixedValueDice(6),
                new FixedValueDice(5)
            )));
        }
    }
}
