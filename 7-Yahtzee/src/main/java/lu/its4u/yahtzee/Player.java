package lu.its4u.yahtzee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Player {
    Set<YahtzeeDice> dices;
    int rollCount;

    /**
     * Crate new Player with 5 dices.
     */
    public Player() {
        Set dices = new HashSet();
        for (int i = 0; i < 5; i++) {
            dices.add(new YahtzeeDice(i + 1));
        }
        this.dices = dices;
    }

    public int rollBoardDices() throws TooManyRollException {
        if(rollCount >= 3) {
            throw new TooManyRollException();
        }
        int lauchendDice =0;
        for (YahtzeeDice dice: dices) {
            if(!dice.kept) {
                dice.roll();
                lauchendDice++;
            }

        }
        rollCount++;
        return lauchendDice;
    }
    public void keepDice(int index) {
        dices.stream()
                .filter(dice -> dice.index == index)
                .forEach(YahtzeeDice::keep);

    }

    public void replayDice(int index) {
        dices.stream()
                .filter(dice -> dice.index == index)
                .forEach(YahtzeeDice::replay);
    }

    public Map<Integer, Boolean> displayDices() {
        return new HashMap<>();
    }

}
