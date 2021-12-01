import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {
    private int space = 2;
    private Color backGround = new Color(0, 102, 204);
    private int cellArea = 30;

    /**
     * Takes in a matrix of specific area and displays it.
     * @param state to show state of cells
     * @param length to show dimension of matrix
     */
    Grid(int[][] state, int length)
    {
        JPanel [][] matrix = new JPanel[length][length];
        setPreferredSize(new Dimension(20*length, 20*length));
        setBackground(backGround);
        setLayout(new GridLayout(length,length,length,length));
        for (int i=0; i < length; ++i)
        {
            for (int j=0; j < length; ++j)
            {
                matrix[i][j] = new JPanel();
                matrix[i][j].setBackground(Color.black);
                add(matrix[i][j]);
                final CellNew cell = new CellNew(i, j, length);
                cell.setAlive(state[i][j]);
                if (cell.getAlive()==1)
                {
                    matrix[i][j].setBackground(new Color(204, 204, 0));
                }
            }
        }
    }
}
