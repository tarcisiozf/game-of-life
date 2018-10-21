import Patterns.Glider;
import Patterns.Toad;

import javax.swing.JFrame;

public class App {
    public static void main(String args[]) {
        Universe universe = UniverseFactory.make();
        universe.setPattern(new Toad(), Position.of(1, 1));
        universe.setPattern(new Glider(), Position.of(1, 10));

        JFrame frame = new JFrame("Game of Life");
        frame.add(universe);
        frame.pack();
        frame.setVisible(true);
    }
}
