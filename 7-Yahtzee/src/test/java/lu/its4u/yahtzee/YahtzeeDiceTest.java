package lu.its4u.yahtzee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YahtzeeDiceTest {

    @Test
    void keep() {
        YahtzeeDice dice = new YahtzeeDice();
        dice.keep();
        Assertions.assertTrue(dice.kept);
    }

    @Test
    void replay() {
        YahtzeeDice dice = new YahtzeeDice();
        dice.replay();
        Assertions.assertFalse(dice.kept);
    }
}