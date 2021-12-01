import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TimerTask;

/**
 * GameOfLife.java
 * 563: HW5 - Game of Life
 * Main runnable file for Game of Life containing main()
 * Created By Luke Mason
 */

public class GameOfLife extends JPanel{
     static final int space = 1;
     static final Color background = new Color(102, 0, 153);
     static int [][] generation1;//passedgenration
     static int [][] generation2;
     static Timer timer;

    public static void main(String[] args) {
        // Create game object to run infinite game loop
        Game curGame = new Game(50);
        curGame.run_game();
        SwingUtilities.invokeLater(GameOfLife::runGui);
    }

    private GameOfLife(int side)
    {
        //create original generation with the size of sides
        JPanel [][] matrix = new JPanel[side][side];
        setPreferredSize(new Dimension(30*side, 30*side));
        generation1 = new int[side][side];
        setBackground(background);
        setLayout(new GridLayout(side, side, space, space));

        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++)
            {
                matrix[i][j] = new JPanel();
                //placeHolder[i][j].setOpaque(true);
                matrix[i][j].setBackground(Color.black);
                //matrix[i][j].getRootPane().setBorder(BorderFactory.createLineBorder(Color.black,25,true));
                add(matrix[i][j]);

                int cellSize = 20;
                final CellNew cell = new CellNew(i, j, cellSize);
                matrix[i][j].addMouseListener(new MouseAdapter()
                {
                    public void mouseClicked(MouseEvent e)
                    {
                        if (cell.getAlive()==0)
                        {
                            int xPos = cell.getX();
                            int yPos = cell.getY();
                            matrix[xPos][yPos].setBackground(new Color(204, 204, 0));
                        }
                        else
                        {
                            int xPos = cell.getX();
                            int yPos = cell.getY();
                            matrix[xPos][yPos].setBackground(Color.black);
                        }
                        cell.toggleAlive();
                        originalGeneration(generation1, cell);
                    }
                });
            }
        }
    }

    private void originalGeneration(int[][] matrix, CellNew cell)
    {
        int x = cell.getX();
        int y = cell.getY();
        matrix[x][y] = cell.getAlive();
    }

    private static void timerPause()
    {
        timer.cancel();
    }

    private static void timerRestart()
    {
        timer = new Timer();
    }

    private static void runGui()
    {
        JFrame frame = new JFrame("GameOfLife");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1;
        panel1 = new JPanel(new CardLayout());
        panel1.setPreferredSize(new Dimension(500, 500));
        CardLayout layout = (CardLayout) panel1.getLayout();

        // Creating start button and setting an initial grid to obtain user input with mouse click
        JButton startButton = new JButton("Click to start on game");
        JPanel startPanel = new JPanel();
        String startMenu = "Start Menu";
        startPanel.setLayout(new GridBagLayout());
        GridBagConstraints s = new GridBagConstraints();
        startPanel.add(startButton, s);
        panel1.add(startPanel, startMenu);
        layout.show(panel1, startMenu);
        startButton.addActionListener(e -> {

            int side = 50;
                int input = JOptionPane.showOptionDialog(frame, "Grid of " + side + '!', "Creating matrix...", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if(input == JOptionPane.OK_OPTION)
                {
                    JPanel gamePanel = new JPanel();
                    String firstMenu = "First Menu";
                    JPanel boardPanel = new JPanel();
                    String nextMenu = "Game Board";
                    gamePanel.setLayout(new GridBagLayout());
                    boardPanel.setLayout(new GridBagLayout());
                    GameOfLife grids = new GameOfLife(side);
                    gamePanel.add(grids);


                    JPanel optionPanel = new JPanel();
                    optionPanel.setLayout(new GridBagLayout());
                    JButton start = new JButton("Start");

                    JButton stop = new JButton("Stop");

                    GridBagConstraints bag = new GridBagConstraints();
                    bag.fill = GridBagConstraints.HORIZONTAL;
                    bag.gridx = 0;
                    bag.gridy = 1;
                    optionPanel.add(start, bag);
                    bag.gridx = 2;
                    optionPanel.add(stop, bag);
                    bag.gridx = 0;
                    bag.gridy = 2;
                    gamePanel.add(optionPanel, bag);
                    panel1.add(gamePanel, firstMenu);
                    layout.show(panel1, firstMenu);

                    //when a start button clicked, algorithm is applied
                    start.addActionListener(e1 -> {
                        generation2 = Algorithm.newGeneration(generation2, side);
                        Grid updatedGrids = new Grid(generation2, side);
                        boardPanel.add(updatedGrids);
                        start.setEnabled(false);
                        boardPanel.add(optionPanel, bag);
                        panel1.add(boardPanel, nextMenu);
                        layout.show(panel1, nextMenu);

                        timerRestart();
                        TimerTask myTask = new TimerTask()
                        {
                            @Override
                            public void run()
                            {
                                boardPanel.removeAll();
                                generation2 = Algorithm.newGeneration(generation2, side);
                                Grid updatedGrids = new Grid(generation2, side);
                                boardPanel.add(updatedGrids);
                                boardPanel.add(optionPanel, bag);
                                boardPanel.revalidate();
                                panel1.add(boardPanel, nextMenu);
                                layout.show(panel1, nextMenu);
                            }
                        };
                        timer.scheduleAtFixedRate(myTask ,1000 , 1000);
                    });

                    //when quit button is clicked, exit the program
                    stop.addActionListener(e13 -> System.exit(0));

                }

        });

        //add card layout of mainPanel to the frame and display the window
        frame.getContentPane().add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
