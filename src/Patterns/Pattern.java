package Patterns;

public interface Pattern {
    int DEAD = 0;
    int ALIVE = 1;

    public int[][] getStructure();
}
