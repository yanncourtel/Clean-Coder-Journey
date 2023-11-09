package lu.its4u;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiceTest {


    @Test
    void roll() {
        Dice dice  = new Dice();
        dice.roll();
        Assertions.assertTrue(dice.getValue() <=6);
        Assertions.assertTrue(dice.getValue() >0);
    }
}