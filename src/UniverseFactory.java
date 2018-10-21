public class UniverseFactory {
    public static Universe make() {
        Universe universe = new Universe();

        for(int y = 0; y < Universe.NUM_TILES; y++) {
            for(int x = 0; x < Universe.NUM_TILES; x++) {
                universe.setCell(new Cell(Position.of(x, y)));
            }
        }

        return universe;
    }
}
