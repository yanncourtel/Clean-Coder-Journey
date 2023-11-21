package lu.its4u.yahtzee;

import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerScoreTest {

    @Test
    void scoreLessThan64ShouldNotGiveBonus() {
        PlayerScore playerScore = new PlayerScore();

        Assertions.assertEquals(0, playerScore.getSumBonus());
    }
    
    @Test
    void scoreMoreThan64ShouldGiveBonus() {
        PlayerScore playerScore = new PlayerScore();
        playerScore.getScores().putAll(Map.of(
            new SumOfOneRule(), 3,
            new SumOfTwoRule(), 6,
            new SumOfThreeRule(), 9,
            new SumOfFourRule(), 12,
            new SumOfFiveRule(), 20,
            new SumOfSixRule(), 18)
        );
    
        Assertions.assertEquals(PlayerScore.BONUS, playerScore.getSumBonus());
    }

    @Test
    void scoreLessThan64() {
        PlayerScore playerScore = new PlayerScore();
        playerScore.getScores().putAll(Map.of(
            new SumOfOneRule(), 3,
            new SumOfTwoRule(), 6,
            new SumOfThreeRule(), 9,
            new SumOfFourRule(), 12,
            new SumOfFiveRule(), 15,
            new SumOfSixRule(), 18)
        );
    
        Assertions.assertEquals(63, playerScore.getTotal());
    }

    @Test
    void scoreMoreThan64() {
        PlayerScore playerScore = new PlayerScore();
        playerScore.getScores().putAll(Map.of(
            new SumOfOneRule(), 3,
            new SumOfTwoRule(), 6,
            new SumOfThreeRule(), 9,
            new SumOfFourRule(), 12,
            new SumOfFiveRule(), 20,
            new SumOfSixRule(), 18)
        );
    
        Assertions.assertEquals(68 + PlayerScore.BONUS, playerScore.getTotal());
    }

    @Test
    void testSaveAllDiceTo6() {
        PlayerScore playerScore = new PlayerScore();
        playerScore.save("Somme de 6", Set.of(
            new YahtzeeDice(1),
            new YahtzeeDice(2),
            new YahtzeeDice(3),
            new YahtzeeDice(4),
            new YahtzeeDice(5)
        ));

        Assertions.assertEquals(30, playerScore.getTotal());
    }
}
