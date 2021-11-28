/**
 * Game.java
 * 563: HW5 - Game of Life
 * Created by Luke Mason
 * Class to represent the game actor for the use-case diagram of the Game of Life
 */

public class Game {
    private Cell[][] _currGen;
    private boolean _runGame;
    private int _dim;

    public Game(int dim) {
        _dim = dim;
        _runGame = false;
        _currGen = new Cell[dim][dim];

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                Cell curCell = new Cell(i, j);
                _currGen[i][j] = curCell;
            }
        }
    }

    public void run_game() {
        for (int i = 0; i < _dim; i++) {
            for (int j = 0; j < _dim; j++) {
                int aliveCount = _currGen[i][j].check_neighbors(_currGen);
                System.out.println("cell (" + i + "," + j + ") has " + aliveCount + " alive neighbors");
            }
        }
        while(_runGame) {
            // infinite game loop
        }
    }

    public void print_cells() {
        for (int i = 0; i < _currGen.length; i++) {
            for (int j = 0; j < _currGen.length; j++) {
                System.out.println(_currGen[i][j].print_coords());
            }
        }
    }

}
