import javax.swing.*;
import java.awt.*;

public class CellNew extends JPanel {
    private int xCord;
    private int yCord;
    private int isAlive;

    /**
     * Constructor with passed coordinates
     * @param x - the x coordinate for the new cell
     * @param y - the y coordinate for the new cell
     */
    CellNew(int x, int y, int cellSize)
    {
        xCord = x;
        yCord = y;
        isAlive = 0;
        setBackground(new Color(0, 102, 204));
        setPreferredSize(new Dimension(cellSize, cellSize));
    }

    /**
     * Returns the x coordinate of a Cell object.
     * Getter function for Cell class
     */
    public int getX()
    {
        return xCord;
    }
    /**
     * Returns the position of y coordinate of a Cell object.
     * Getter function for Cell class
     */
    public int getY()
    {
        return yCord;
    }
    /**
     * Returns the state of cells whether its alive or dead.
     * Getter method of Cell class
     */
    int getAlive()
    {
        return isAlive;
    }
    /**
     * Changes the state of a Cell object.
     * If the cell is alive, then it dies and vice versa.
     */
    void toggleAlive()
    {
        if (isAlive==0)
        {
            isAlive=1;
        }
        else
        {
            isAlive=0;
        }
    }
    /**
     * setter function for isAlive flag.
     * @param flag is an integer parameter. If its 1 then state is active otherwise
     *             its a dead state;
     */
    void setAlive(int flag)
    {
        isAlive = flag;
    }

}
