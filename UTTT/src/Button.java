import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    private boolean available = true;
    char[] columnNameX = {'G', 'S', 'D'};
    char[] columnNameY = {'L', 'S', 'P'};

    public Button(Point index, Point field) {
        setText("");
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addActionListener(e -> {
            if(!available) return;
            makeMove(index, field);
        });
    }

    public boolean setMark(char mark) {
        if (getText().isEmpty()) {
            setText(mark + "");
            return true;
        }
        return false;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
        if(available) {
            setBackground(Color.LIGHT_GRAY);
        } else { setBackground(Color.WHITE); }
    }

    public void botMove() {
        Point big = boardPanel.search();
        if (big == null) return;

        while (true){
            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);
            if (boardPanel.getSmallButton(big.x, big.y, x, y).isAvailable()){
                makeMove(big, new Point(x,y));
                break;
            }
        }
    }

    public void makeMove(Point index, Point field){
        if (boardPanel.getSmallButton(index.x, index.y, field.x, field.y).setMark(gamePanel.player)) {
            KeyListener.getBoardID(index, field, columnNameX, columnNameY);
            if(gamePanel.player == 'O' && gamePanel.computer){
                botMove();
            }
            boardPanel.requestFocusToMainFrame();
        }
    }
}