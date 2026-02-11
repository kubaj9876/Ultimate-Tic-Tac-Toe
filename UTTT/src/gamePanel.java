import javax.swing.*;
import java.awt.*;

public class gamePanel extends JFrame {
    public static char player;
    public static boolean computer = false;

    public gamePanel(char playerStart, boolean bot){
        player = playerStart;
        computer = bot;
        setTitle("Ultimate Tic Tac Toe");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel gamePanel = new JPanel(new GridLayout(3, 3));
        gamePanel.setPreferredSize(new Dimension(400, 400));
        gamePanel.setBackground(Color.LIGHT_GRAY);

        boardPanel board = new boardPanel();
        historyPanel history = new historyPanel();

        add(board, BorderLayout.WEST);
        add(history, BorderLayout.EAST);

        KeyListener keyListener = new KeyListener(board.getSmallButtons());
        addKeyListener(keyListener);

        setFocusable(true);
        requestFocusInWindow();

        pack();
        setVisible(true);

        SwingUtilities.invokeLater(this::requestFocusInWindow);

        if(player == 'O' && computer){
            keyListener.botMove();
        }
    }
}
