package mars.project.rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RoverTest {

    @Test
    void shouldHaveInitialPositionAndDirection() {
        Rover rover = new Rover(3, 4, 'N');
        assertEquals(3, rover.getX(), "should be 3");
        assertEquals(4, rover.getY(), "should be 4");
        assertEquals('N', rover.getDirection(), "should be N");
    }

    @Test
    void shouldMoveForwardWhenReceivingCommandFAndFacingNorth() {
        Rover rover = new Rover(3, 4, 'N');
        rover.receiveCommand("F");

        assertEquals(3, rover.getX(), "should be 3");
        assertEquals(5, rover.getY(), "should be 5");
        assertEquals('N', rover.getDirection(), "should be N");
    }

    @ParameterizedTest
    @ValueSource(chars = {'S'})
    void shouldMoveForwardWhenReceivingCommandFAndFacingSouth(char direction) {
        Rover rover = new Rover(3, 4, direction);
        rover.receiveCommand("F");

        assertEquals(3, rover.getX(), "should be 3");
        assertEquals(3, rover.getY(), "should be 3");
        assertEquals(direction, rover.getDirection());
    }
}
