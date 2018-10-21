import javax.swing.JFrame;

public class App {
    public static void main(String args[]) {
        Universe universe = UniverseFactory.make();

        universe.getCell(3, 2).alive();
        universe.getCell(4, 2).alive();
        universe.getCell(5, 2).alive();
        universe.getCell(2, 3).alive();
        universe.getCell(3, 3).alive();
        universe.getCell(4, 3).alive();

        JFrame frame = new JFrame("Game of Life");
        frame.add(universe);
        frame.pack();
        frame.setVisible(true);
    }
}
