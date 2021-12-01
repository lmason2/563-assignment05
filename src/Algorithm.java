public class Algorithm {
    /** Generates totally new generation after
     * applying algorithm on the current state
     */
    static int[][] newGeneration(int[][] state, int length)
    {
        int space = length+2;
        int [][] previousGeneration = new int[space][space];
        for (int i=0; i < space; ++i)
        {
            for (int j=0; j < space; ++j)
            {
                if (i==0 || j==0 || i==space-1 || j==space-1)
                {
                    previousGeneration[i][j] = 0;
                }
                else
                {
                    previousGeneration[i][j] = state[i-1][j-1];
                }
            }
        }
        state = evolutionProcess(previousGeneration, space);
        return state;
    }

    /**
     * Returns the conunt of all alive neighbours of a particular cells
     * @param matrix the matrix of current generation
     * @param x x cordinate of the cell for which neighbours need to be calculated
     * @param y y cordinate of the cell for which neighbours need to be calculated
     * @return
     */

    static int numberOfAliveNeighbours(int matrix[][], int x, int y)
    {
        int count=0;

        for (int width = x-1; width <= x+1; ++width)
        {
            for (int height = y-1; height <= y+1; ++height)
            {
                if (matrix[width][height]==1)
                {
                    ++count;
                }
            }
        }
        return count;
    }

    /**
     * Rules for the game GameOfLife
     * @param count number of aliveneighbours
     * @param state state of the cell being considered.
     * @return
     */

    private static int rulesOfGame(int count, int state)
    {
        int aliveOrNot = state;

        if (count < 2 && state == 1)
        {
            aliveOrNot = 0;
        }

        else if (count > 3 && state == 1)
        {
            aliveOrNot = 0;
        }

        else if (count == 3 && state == 0)
        {
            aliveOrNot = 1;
        }
        return aliveOrNot;
    }

    /**
     * Function for returning new generation
     * @param oldGeneration
     * @param position of the cell for which the algorithm is being applied
     * @return
     */

     static int[][] evolutionProcess(int[][] oldGeneration, int position)
    {
        int originalSide = position-2;
        int [][] nextGeneration = new int [originalSide][originalSide];

        for (int i=1; i<position-1; ++i)
        {
            for (int j=1; j<position-1; ++j)
            {

                int aliveNeighbours = numberOfAliveNeighbours(oldGeneration, i, j);
                aliveNeighbours -= oldGeneration[i][j];

                int state;
                state = rulesOfGame(aliveNeighbours, oldGeneration[i][j]);
                //assign the result to a cell
                nextGeneration[i-1][j-1] = state;
            }
        }
        return nextGeneration;
    }


}
