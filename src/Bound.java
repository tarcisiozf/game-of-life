public class Bound {
    private Position upperLeft;
    private Position bottomRight;

    public Bound(Position upperLeft, Position bottomRight) {
        this.upperLeft = upperLeft;
        this.bottomRight = bottomRight;
    }

    public boolean intersects(Position position) {
        return position.getX() >= upperLeft.getX()
            && position.getX() < bottomRight.getX()
            && position.getY() >= upperLeft.getY()
            && position.getY() < bottomRight.getY();
    }
}
