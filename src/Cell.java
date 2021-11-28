/**
 * Cell.java
 * 563: HW5 - Game of Life
 * Cell class to represent an individual cell in the Game of Life Grid
 * Created by Luke Mason
 */

public class Cell {
    private int _xcoord;
    private int _ycoord;
    private boolean _alive;

    public Cell(int xcoord, int ycoord) {
        _xcoord = xcoord;
        _ycoord = ycoord;
        _alive = false;
    }

    public int check_neighbors(Cell[][] grid) {
        int count = 0;
        for (int i = _xcoord - 1; i <= _xcoord + 1; i++) {
            for (int j = _ycoord - 1; j <= _ycoord + 1; j++) {
                if (i != _xcoord || j != _ycoord) {
                    if (i >= 0 && i < grid.length && j >= 0 && j < grid.length) {
                        if (grid[i][j]._alive) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public String print_coords() {
        return _xcoord + " " + _ycoord;
    }

    public int get_xcoord() {
        return _xcoord;
    }

    public int get_ycoord() {
        return _ycoord;
    }
}
