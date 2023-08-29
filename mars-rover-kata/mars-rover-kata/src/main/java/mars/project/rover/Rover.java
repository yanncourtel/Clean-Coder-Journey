package mars.project.rover;

public class Rover {

    private int x;
    private int y;
    private char direction;
    private Planet planet;
    
    public Rover(int x, int y, char direction, Planet planet) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.planet = planet;
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

    public void receiveCommand(String commands) {
        for (char c : commands.toCharArray()) {
            if (c == 'F') {
                handleMoveForward();
            } else if (c == 'B') {
                handleMoveBackward();
            } else if (c == 'L') {
                handleRotateLeft();
            } else if (c == 'R') {
                handleRotateRight();
            }
        }
    }

    private void handleRotateLeft() {
        if (this.direction == 'S') this.direction = 'E';
        else if (this.direction == 'E') this.direction = 'N';
        else if (this.direction == 'N') this.direction = 'W';
        else this.direction = 'S';
    }
    private void handleRotateRight() {
        if (this.direction == 'S') this.direction = 'W';
        else if (this.direction == 'E') this.direction = 'S';
        else if (this.direction == 'N') this.direction = 'E';
       else this.direction = 'N';
    }
    private void handleMoveBackward() {
        if(this.direction == 'N') this.y--;
        else if(this.direction == 'W') this.x++;
        else if(this.direction == 'E') this.x--;
        else this.y++;
    }

    private void handleMoveForward() {
        if(this.direction == 'N') this.y++;
        else if(this.direction == 'W') this.x--;
        else if(this.direction == 'E') this.x++;
        else this.y--;

        if (this.y > this.planet.maxY()) this.y = this.planet.minY();
    }
}
