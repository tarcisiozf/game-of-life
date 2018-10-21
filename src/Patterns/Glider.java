package Patterns;

public class Glider implements Pattern {
    @Override
    public int[][] getStructure() {
        return new int[][] {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
        };
    }
}
