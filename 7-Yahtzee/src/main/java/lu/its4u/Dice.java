package lu.its4u;

import java.util.Random;

public class Dice {

    private Integer value;
    
    public void roll(){
        Random r = new Random();
        value= r.nextInt(1,7);
    }

    public Integer getValue() {
        return value;
    }
}
