package Patterns;

public class Toad implements Pattern {
    @Override
    public int[][] getStructure() {
        return new int[][] {
            {0, 1, 1, 1},
            {1, 1, 1, 0}
        };
    }
}
