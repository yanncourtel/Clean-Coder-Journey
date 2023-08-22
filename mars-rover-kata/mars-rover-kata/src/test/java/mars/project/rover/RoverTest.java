package mars.project.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void shouldHaveInitialPositionAndDirection() {
        Rover rover = new Rover(3, 4, 'N');
        assertEquals(3, rover.getX(), "should be 3");
        assertEquals(4, rover.getY(), "should be 4");
        assertEquals('N', rover.getDirection(), "should be N");
    }
}
