package lu.its4u.yahtzee;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    void rollDices() throws TooManyRollException {
        Player p1 = new Player();
        assertEquals(5, p1.rollBoardDices());
        for (YahtzeeDice dice : p1.dices) {
            hasScore(dice);
        }
        Assertions.assertEquals(5, p1.dices.size(), "Player should have 5 dices");
    }

    private void hasScore(YahtzeeDice dice) {
        Assertions.assertNotNull(dice.getValue());
        Assertions.assertTrue(dice.getValue() <= 6);
        Assertions.assertTrue(dice.getValue() > 0);
    }

    @Test
    public void having5DicesOnTheBoardAndKeepingOneTest() {
        Player player = new Player();

        player.keepDice(1);

        assertEquals(true, player.dices.stream().filter(d -> d.index == 1).findFirst().get().kept);
        assertEquals(false, player.dices.stream().filter(d -> d.index == 2).findFirst().get().kept);
        assertEquals(false, player.dices.stream().filter(d -> d.index == 3).findFirst().get().kept);
        assertEquals(false, player.dices.stream().filter(d -> d.index == 4).findFirst().get().kept);
        assertEquals(false, player.dices.stream().filter(d -> d.index == 5).findFirst().get().kept);
    }

    @Test
    public void having1KeptAndReplayingOneTest() {
        Player player = new Player();

        // Keep the dice to change status, it has been tested above
        player.keepDice(1);

        // Replay the dice
        player.replayDice(1);

        assertEquals(false, player.dices.stream().filter(d -> d.index == 1).findFirst().get().kept);
        assertEquals(false, player.dices.stream().filter(d -> d.index == 2).findFirst().get().kept);
        assertEquals(false, player.dices.stream().filter(d -> d.index == 3).findFirst().get().kept);
        assertEquals(false, player.dices.stream().filter(d -> d.index == 4).findFirst().get().kept);
        assertEquals(false, player.dices.stream().filter(d -> d.index == 5).findFirst().get().kept);
    }


    @Test
    void playerShouldBeAbletoPlay3Time() throws TooManyRollException {
        Player p1 = new Player();
        p1.rollBoardDices();
        p1.rollBoardDices();
        p1.rollBoardDices();
        Assertions.assertEquals(5, p1.dices.size(), "Player should have 5 dices");
    }

    @Test
    void playerShouldRollOnlyReplayableDices() throws TooManyRollException {
        Player p1 = new Player();
        p1.rollBoardDices();
        p1.keepDice(1);
        p1.keepDice(3);
        assertEquals(3, p1.rollBoardDices());

        Assertions.assertEquals(5, p1.dices.size(), "Player should have 5 dices");
    }

    @Test
    void playerShouldntBeAbletoPlay4Time() throws TooManyRollException {
        Player p1 = new Player();
        p1.rollBoardDices();
        p1.rollBoardDices();
        p1.rollBoardDices();
        Assertions.assertThrows(TooManyRollException.class, () -> {p1.rollBoardDices();
        });
    }
}
