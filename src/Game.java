import java.util.Random;

/**
 * Game.java
 * 563: HW5 - Game of Life
 * Created by Luke Mason
 * Class to represent the game actor for the use-case diagram of the Game of Life
 */

public class Game {
    private Cell[][] _currGen; // 2d Array to represent current generation being shown in JFrame
    private boolean _runGame; // Boolean to tell whether the user is currently playing the game
    private int _dim; // Single dimension value for _currGen being _dim x _dim in size

    /**
     * Default value contstuctor to create Game object
     */
    public Game() {
        // Init dimension to 50, not running game, and init current generation
        _dim = 50;
        _runGame = false;
        _currGen = new Cell[50][50];

        // Iterate through current generation to create cells
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                Cell curCell = new Cell(i, j);
                _currGen[i][j] = curCell;
            }
        }
    }

    /**
     * Constructor with passed values ot initialize class level variables
     * @param dim - dimension of the generation
     */
    public Game(int dim) {
        // Init dimension, not running game, and 2d current generation array
        _dim = dim;
        _runGame = false;
        _currGen = new Cell[_dim][_dim];

        // Iterate through current generation to create cells
        for (int i = 0; i < _dim; i++) {
            for (int j = 0; j < _dim; j++) {
                Cell curCell = new Cell(i, j);
                Random rand = new Random();
                int randomNumber = rand.nextInt(10);
                if (randomNumber == 0) {
                    curCell.set_alive(true);
                    System.out.println("(" + i + "," + j + ") is alive");
                }
                _currGen[i][j] = curCell;
            }
        }
    }

    /**
     * Main function to run the game continuously until interrupted
     */
    public void run_game() {
        Cell[][] nextGen = new Cell[_dim][_dim];

        // Iterate through next generation to create cells
        for (int i = 0; i < _dim; i++) {
            for (int j = 0; j < _dim; j++) {
                Cell curCell = new Cell(i, j);
                nextGen[i][j] = curCell;
            }
        }

        // Testing check neighbors function
        for (int i = 0; i < _dim; i++) {
            for (int j = 0; j < _dim; j++) {
                int aliveCount = _currGen[i][j].check_neighbors(_currGen);
                if (aliveCount == 3) {
                    if (!_currGen[i][j].get_alive()) {
                        nextGen[i][j].set_alive(true);
                    }
                }
                else if (aliveCount != 2) {
                    nextGen[i][j].set_alive(false);
                }
            }
        }

        _currGen = nextGen;

        // Inifinite loop until class level variable is switched based on interruption
        while(_runGame) {
            // infinite game loop
        }
    }

    /**
     * Debugging function to print the coordinates of each cell in the current generation
     */
    public void print_generation() {
        // Iterate through current generation and print coordinates for each cell
        for (int i = 0; i < _currGen.length; i++) {
            for (int j = 0; j < _currGen.length; j++) {
                System.out.println(_currGen[i][j].print_coords() + " is " + _currGen[i][j].get_alive());
            }
        }
    }

}
