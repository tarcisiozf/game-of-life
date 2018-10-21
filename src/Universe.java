import javax.swing.Timer;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

class Universe extends Canvas implements ActionListener {
    public final static int NUM_TILES = 32;
    private Cell[][] tiles = new Cell[NUM_TILES][NUM_TILES];
    private Bound bound;
    private Timer timer = new Timer(500, this);

    Universe() {
        setSize();
        setBound();
        timer.start();
    }

    public void paint(Graphics graphics) {
        for(int y = 0; y < NUM_TILES; y++) {
            for(int x = 0; x < NUM_TILES; x++) {
                Cell cell = getCell(Position.of(x, y));

                if (cell.isAlive()) {
                    Rectangle rectangle = cell.getRectangle();
                    graphics.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
                }
            }
        }
    }

    private void nextGeneration() {
        List<Cell> killList = new ArrayList<>();
        List<Cell> aliveList = new ArrayList<>();

        for(int y = 0; y < NUM_TILES; y++) {
            for(int x = 0; x < NUM_TILES; x++) {
                Cell cell = tiles[y][x];

                int numNeighbors = countNeighbors(cell.getPosition());

                //Any live cell with fewer than two live neighbors dies, as if by underpopulation.
                //Any live cell with more than three live neighbors dies, as if by overpopulation.
                //Any live cell with two or three live neighbors lives on to the next generation.
                if (cell.isAlive() && (numNeighbors < 2 || numNeighbors > 3)) {
                    killList.add(cell);
                } else {
                    //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                    if (numNeighbors == 3) {
                        aliveList.add(cell);
                    }
                }
            }
        }

        for(Cell cell : killList) {
            cell.kill();
        }

        for (Cell cell : aliveList) {
            cell.alive();
        }
    }

    private int countNeighbors(Position position) {
        int count = 0;

        for(int y = -1; y <= 1; y++) {
            for(int x = -1; x <= 1; x++) {
                if (y == 0 && x == 0) {
                    continue;
                }

                Position neighborPosition = new Position(position.getX() + x, position.getY() + y);

                if (!bound.intersects(neighborPosition)) {
                    continue;
                }

                Cell neighbor = getCell(neighborPosition);

                if (neighbor.isAlive()) {
                    count++;
                }
            }
        }

        return count;
    }

    public void setCell(Cell cell) {
        Position position = cell.getPosition();
        tiles[position.getY()][position.getX()] = cell;
    }

    public Cell getCell(Position position) {
        return tiles[position.getY()][position.getX()];
    }

    public Cell getCell(int x, int y) {
        return tiles[y][x];
    }

    private void setSize() {
        int size = Universe.NUM_TILES * Cell.DIMENSION;
        super.setSize(size, size);
    }

    private void setBound() {
        bound = new Bound(new Position(0, 0), new Position(NUM_TILES, NUM_TILES));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.nextGeneration();
        repaint();
    }
}
