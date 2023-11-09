package lu.its4u.yahtzee;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
     void rollDices () {
        Player p1 = new Player();
        p1.rollBoardDices();
        for (YahtzeeDice dice : p1.dices) {
            hasScore(dice);
        }
        Assertions.assertEquals(5, p1.dices.size(), "Player should have 5 dices");
    }

    private void hasScore(YahtzeeDice dice) {
        Assertions.assertNotNull(dice.getValue());
        Assertions.assertTrue(dice.getValue() <=6);
        Assertions.assertTrue(dice.getValue() >0);
    }
}
