package tddmicroexercises.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    public void isShouldCalculateDriverPoints() {
        // setup

        // act

        // verify
        //FIXME only one call should be test in one unit test
        assertEquals(25, TestData.race1.getPoints(TestData.driver1));
        assertEquals(18, TestData.race1.getPoints(TestData.driver2));
        assertEquals(15, TestData.race1.getPoints(TestData.driver3));
    }

}
