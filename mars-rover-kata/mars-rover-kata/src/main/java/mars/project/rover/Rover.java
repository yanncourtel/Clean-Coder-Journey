package mars.project.rover;

public class Rover {

    private final int x;
    private final int y;
    private final char direction;

    public Rover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }


    public char getDirection() {
        return this.direction;
    }
}
