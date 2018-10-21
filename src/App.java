import javax.swing.JFrame;

public class App {
    public static void main(String args[]) throws InterruptedException {
        Universe universe = UniverseFactory.make();

        universe.getCell(Position.of(3, 2)).alive();
        universe.getCell(Position.of(4, 2)).alive();
        universe.getCell(Position.of(5, 2)).alive();
        universe.getCell(Position.of(2, 3)).alive();
        universe.getCell(Position.of(3, 3)).alive();
        universe.getCell(Position.of(4, 3)).alive();

        JFrame frame = new JFrame("Game of Life");
        frame.add(universe);
        frame.pack();
        frame.setVisible(true);
    }
}
