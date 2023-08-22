package mars.project.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void shouldHaveInitialPosition(){
        Rover rover = new Rover(3,4);
        assertEquals(3, rover.getX(),"should be 3");
        assertEquals(4, rover.getY(),"should be 4");
    }
}
