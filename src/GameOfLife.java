/**
 * GameOfLife.java
 * 563: HW5 - Game of Life
 * Main runnable file for Game of Life containing main()
 * Created By Luke Mason
 */

public class GameOfLife {
    public static void main(String[] args) {
        // Create game object to run infinite game loop
        Game curGame = new Game(5);

        curGame.print_generation();
        curGame.run_game();
        System.out.println();
        curGame.print_generation();
    }
}
