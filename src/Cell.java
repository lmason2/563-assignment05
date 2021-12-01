/**
 * Cell.java
 * 563: HW5 - Game of Life
 * Cell class to represent an individual cell in the Game of Life Grid
 * Created by Luke Mason
 */

public class Cell {
    private int _xcoord; // x coordinate of the cell
    private int _ycoord; // y coordinate of the cell
    private boolean _alive; // is the cell alive(true) or dead(false)

    /**
     * Constructor with passed coordinates
     * @param xcoord - the x coordinate for the new cell
     * @param ycoord - the y coordinate for the new cell
     */
    public Cell(int xcoord, int ycoord) {
        _xcoord = xcoord;
        _ycoord = ycoord;
        _alive = false; // Cell always starts dead
    }

    /**
     * Check neighbors around Cell
     * @param curGen - The current generation to check neighbors against
     * @return The number of alive neighbors around this Cell
     */
    public int check_neighbors(Cell[][] curGen) {
        int count = 0;
        for (int i = _xcoord - 1; i <= _xcoord + 1; i++) {
            for (int j = _ycoord - 1; j <= _ycoord + 1; j++) {
                if (i != _xcoord || j != _ycoord) {
                    if (i >= 0 && i < curGen.length && j >= 0 && j < curGen.length) {
                        if (curGen[i][j]._alive) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * Simple debugging function to print coordinates
     * @return String representation (x coordinate and y coordinate)
     */
    public String print_coords() {
        return _xcoord + " " + _ycoord;
    }

    /**
     * Getter for _xcoord class variable
     * @return integer value of _xcoord
     */
    public int get_xcoord() {
        return _xcoord;
    }

    /**
     * Getter for _ycoord class variable
     * @return integer value of _ycoord
     */
    public int get_ycoord() {
        return _ycoord;
    }

    /**
     * Getter for _alive class variable
     * @return boolean value of _alive
     */
    public boolean get_alive() { return _alive; }

    /**
     * Setter for _alive
     * @param newAlive is the value to set _alive to
     */
    public void set_alive(boolean newAlive) {
        _alive = newAlive;
    }

}
