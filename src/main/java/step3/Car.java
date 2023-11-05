package step3;

public class Car {

    private static final int MOVE_BOUND = 4;

    private int position;

    public void move(int random) {
        if (canMove(random)) {
            position++;
        }
    }

    private boolean canMove(int random) {
        return random >= MOVE_BOUND;
    }

    public int position() {
        return this.position;
    }

}
