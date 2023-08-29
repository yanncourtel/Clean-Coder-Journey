package mars.project.rover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void shouldHaveInitialPositionAndDirection() {
        Rover rover = new Rover(3, 4, 'N');
        assertEquals(3, rover.getX(), "should be 3");
        assertEquals(4, rover.getY(), "should be 4");
        assertEquals('N', rover.getDirection(), "should be N");
    }

    @ParameterizedTest
    @CsvSource({"S,3,4,3,3",
            "N,3,4,3,5",
            "W,3,4,2,4",
            "E,3,4,4,4"})
    void shouldMoveForwardWhenReceivingCommandF(char direction, int initX, int initY, int targetX, int targetY) {
        Rover rover = new Rover(initX, initY, direction);
        rover.receiveCommand("F");

        assertEquals(targetX, rover.getX(), "should be " + targetX);
        assertEquals(targetY, rover.getY(), "should be " + targetY);
        assertEquals(direction, rover.getDirection());
    }

    @ParameterizedTest
    @CsvSource({
        "S,3,4,3,5",
        "N,3,4,3,3",
        "W,3,4,4,4",
        "E,3,4,2,4"
    })
    void shouldMoveBackwardWhenReceivingCommandB(char direction, int initX, int initY, int targetX, int targetY) {
        Rover rover = new Rover(initX, initY, direction);
        rover.receiveCommand("B");

        assertEquals(targetX, rover.getX(), "should be " + targetX);
        assertEquals(targetY, rover.getY(), "should be " + targetY);
        assertEquals(direction, rover.getDirection());
    }

    @ParameterizedTest
    @CsvSource({
        "S,E",
        "E,N",
        "N,W",
        "W,S"
    })
    void shouldRotateLeftWhenReceivingCommandL(char initDirection, char expectedDirection) {
        Rover rover = new Rover(0, 0, initDirection);
        rover.receiveCommand("L");

        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(expectedDirection, rover.getDirection());
    }
}
