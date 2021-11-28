/**
 * Game.java
 * 563: HW5 - Game of Life
 * Created by Luke Mason
 * Class to represent the game actor for the use-case diagram of the Game of Life
 */

public class Game {
    private Cell[][] _grid;
    private boolean _runGame;

    public Game(int dim) {
        _runGame = false;
        _grid = new Cell[dim][dim];

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                Cell curCell = new Cell(i, j);
                _grid[i][j] = curCell;
            }
        }
    }

    public void print_cells() {
        for (int i = 0; i < _grid.length; i++) {
            for (int j = 0; j < _grid.length; j++) {
                System.out.println(_grid[i][j].print_coords());
            }
        }
    }

}
