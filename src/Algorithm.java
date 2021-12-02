import java.util.Arrays;

public class Algorithm {
    static int[][] newGeneration(int[][] state, int length) {
        int[][] nextGen = new int[length][length];


        System.out.println(Arrays.deepToString(state));

        // Iterate through next generation to create cells
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                nextGen[i][j] = 0;
            }
        }

        // Testing check neighbors function
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int aliveCount = check_neighbors(state, i, j);
                if (aliveCount == 3) {
                    if (state[i][j] == 0) {
                        nextGen[i][j] = 1;
                    }
                }
                else if (aliveCount != 2) {
                    nextGen[i][j] = 0;
                }
            }
        }

        return nextGen;
    }

    private static int check_neighbors(int[][] currentGeneration, int x, int y) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i != x || j != y) {
                    if (i >= 0 && i < currentGeneration.length && j >= 0 && j < currentGeneration.length) {
                        if (currentGeneration[i][j] == 1) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }



}
