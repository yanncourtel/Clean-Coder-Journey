package lu.its4u.yahtzee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Player {
    Set<YahtzeeDice> dices;

    /**
     * Crate new Player with 5 dices.
     */
    public Player() {
        Set dices = new HashSet();
        for (int i = 0; i < 5; i++) {
            dices.add(new YahtzeeDice());
        }
        this.dices = dices;
    }

    public void rollBoardDices(){
        for (YahtzeeDice dice: dices) {
            dice.roll();
        }
    }
    public void keepDice(int index) {

    }

    public void replayDice(int index) {

    }

    public Map<Integer, Boolean> displayDices() {
        return new HashMap<>();
    }

}
