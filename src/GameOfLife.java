/**
 * GameOfLife.java
 * 563: HW5 - Game of Life
 * Main runnable file for Game of Life containing main()
 * Created By Luke Mason
 */

public class GameOfLife {
    public static void main(String[] args) {
        Game curGame = new Game(50);

        curGame.print_cells();
    }
}
