import java.awt.Rectangle;

public class Cell {
    public final static int DIMENSION = 15;
    private Position position;
    private boolean alive = false;

    public Cell(Position position) {
        this.position = position;
    }

    public void alive() {
        this.alive = true;
    }

    public void kill() {
        this.alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public Rectangle getRectangle() {
        return new Rectangle(position.getX() * DIMENSION, position.getY() * DIMENSION, DIMENSION, DIMENSION);
    }

    public Position getPosition() {
        return position;
    }
}
