import javax.swing.*;
import java.awt.*;

public class boardPanel extends JPanel {

    private static final Button[][][][] smallButtons = new Button[3][3][3][3];
    private static final JButton[][] bigButtons = new JButton[3][3];
    private static final JPanel[][] panels = new JPanel[3][3];
    private static boolean gameOver = false;

    public boardPanel() {
        setLayout(new GridLayout(3, 3));
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.LIGHT_GRAY);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JPanel panel = new JPanel(new CardLayout());
                CardLayout cl = (CardLayout) panel.getLayout();

                Point index = new Point(i, j);

                JPanel panelButtons = new JPanel(new GridLayout(3, 3));
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        Point field = new Point(x, y);
                        Button button = new Button(index, field);
                        panelButtons.add(button);
                        smallButtons[i][j][x][y] = button;
                    }
                }
                panelButtons.setEnabled(false);

                JButton button = new JButton("");
                button.setBackground(Color.WHITE);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                button.addActionListener(e -> cl.show(panel, "show"));
                bigButtons[i][j] = button;

                panel.add(panelButtons, "show");
                panel.add(bigButtons[i][j], "hide");

                panels[i][j] = panel;
                add(panel);
            }
        }
    }

    public Button[][][][] getSmallButtons() { return smallButtons; }

    public static Button getSmallButton(int bigX, int bigY, int x, int y) {
        return smallButtons[bigX][bigY][x][y];
    }

    private static boolean match(JButton a, JButton b, JButton c) {
        String text = a.getText();
        return !text.isEmpty() && text.equals(b.getText()) && text.equals(c.getText());
    }

    public static void requestFocusToMainFrame() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .getActiveWindow()
                .requestFocus();
    }

    public static Point search(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for(int x = 0; x < 3; x++){
                    for(int y = 0; y < 3; y++){
                        if(smallButtons[i][j][x][y].isAvailable()){
                            return new Point(i, j);
                        }
                    }
                }
            }
        }
        return null;
    }

    private static String checkWinner(JButton[][] board) {
        for (int i = 0; i < 3; i++) {
            if (match(board[i][0], board[i][1], board[i][2])) {
                return board[i][0].getText();
            }
            if (match(board[0][i], board[1][i], board[2][i])) {
                return board[0][i].getText();
            }
        }
        if (match(board[0][0], board[1][1], board[2][2])) {
            return board[0][0].getText();
        }
        if (match(board[0][2], board[1][1], board[2][0])) {
            return board[0][2].getText();
        }

        boolean full = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText().isEmpty()) {
                    full = false;
                    break;
                }
            }
        }

        if (full) return "R";
        return "";
    }

    public static void check(Point field) {
        if (gameOver) return;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String winner = checkWinner(smallButtons[i][j]);
                if (!winner.isEmpty()) {
                    CardLayout cl = (CardLayout) panels[i][j].getLayout();
                    bigButtons[i][j].setText(winner);
                    if (winner.equals("R")) {
                        bigButtons[i][j].setBackground(Color.GRAY);
                    }
                    cl.show(panels[i][j], "hide");
                }
            }
        }

        int[] score = {0, 0, 0};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String winner = bigButtons[i][j].getText();
                switch (winner) {
                    case "X" -> score[0]++;
                    case "O" -> score[1]++;
                    case "R" -> score[2]++;
                }
            }
        }
        if ((score[0] >= 5 || score[1] >= 5 || score[2] >= 5) || (score[0] + score[1] + score[2] == 9)){
            gameOver = true;
            if(score[0] > score[1] && score[0] > score[2]){
                new winnerDialog("X");
            } else if(score[1] > score[0] && score[1] > score[2]){
                new winnerDialog("O");
            } else new winnerDialog("R");

        }

        boolean targetBoardWon = !bigButtons[field.x][field.y].getText().isEmpty();

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                boolean thisBoardWon = !bigButtons[x][y].getText().isEmpty();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (targetBoardWon) {
                            smallButtons[x][y][i][j].setAvailable(!thisBoardWon && smallButtons[x][y][i][j].getText().isEmpty());
                        } else {
                            smallButtons[x][y][i][j].setAvailable(x == field.x && y == field.y && smallButtons[x][y][i][j].getText().isEmpty());
                        }
                    }
                }
            }
        }
    }
}
