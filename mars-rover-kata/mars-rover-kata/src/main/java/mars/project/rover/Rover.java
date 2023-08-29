package mars.project.rover;

public class Rover {

    private int x;
    private int y;
    private char direction;

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

    public void receiveCommand(String commands) {
        for (char c : commands.toCharArray()) {
            if (c == 'F') {
                if(this.direction == 'N') this.y++;
                else this.y--;
            }
        }
    }
}
