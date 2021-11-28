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

    public int check_neighbors(Cell[] grid) {
        int myxcoord = _xcoord;
        int myycoord = _ycoord;


        return -1;
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
