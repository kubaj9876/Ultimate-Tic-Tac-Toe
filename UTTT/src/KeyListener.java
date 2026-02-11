import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
    private final Button[][][][] smallButtons;
    char[] columnNameX = {'G', 'S', 'D'};
    char[] columnNameY = {'L', 'S', 'P'};

    public KeyListener(Button[][][][] smallButtons) {
        this.smallButtons = smallButtons;
    }

    public void makeMove(Point index, Point field){
        if(smallButtons[index.x][index.y][field.x][field.y].setMark(gamePanel.player)){
            getBoardID(index, field, columnNameX, columnNameY);
        }
    }

    static void getBoardID(Point index, Point field, char[] columnNameX, char[] columnNameY) {
        String indexName = columnNameX[index.x] + "" + columnNameY[index.y];
        String fieldName = columnNameX[field.x] + "" + columnNameY[field.y];

        historyPanel.addHistory(new Object[]{gamePanel.player, indexName, fieldName});
        gamePanel.player = (gamePanel.player == 'X') ? 'O' : 'X';
        boardPanel.check(field);
    }

    public void botMove() {
        Point big = boardPanel.search();
        if (big == null) return;

        while (true){
            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);
            if (smallButtons[big.x][big.y][x][y].isAvailable()){
                makeMove(big, new Point(x,y));
                break;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Point activeBoard = boardPanel.search();
        if (activeBoard == null) return;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_NUMPAD7:
                makeMove(new Point(activeBoard.x,activeBoard.y), new Point(0,0));
                if(gamePanel.computer) botMove();
                break;
            case KeyEvent.VK_NUMPAD8:
                makeMove(new Point(activeBoard.x,activeBoard.y), new Point(0,1));
                if(gamePanel.computer) botMove();
                break;
            case KeyEvent.VK_NUMPAD9:
                makeMove(new Point(activeBoard.x,activeBoard.y), new Point(0,2));
                if(gamePanel.computer) botMove();
                break;
            case KeyEvent.VK_NUMPAD4:
                makeMove(new Point(activeBoard.x,activeBoard.y), new Point(1,0));
                if(gamePanel.computer) botMove();
                break;
            case KeyEvent.VK_NUMPAD5:
                makeMove(new Point(activeBoard.x,activeBoard.y), new Point(1,1));
                if(gamePanel.computer) botMove();
                break;
            case KeyEvent.VK_NUMPAD6:
                makeMove(new Point(activeBoard.x,activeBoard.y), new Point(1,2));
                if(gamePanel.computer) botMove();
                break;
            case KeyEvent.VK_NUMPAD1:
                makeMove(new Point(activeBoard.x,activeBoard.y), new Point(2,0));
                if(gamePanel.computer) botMove();
                break;
            case KeyEvent.VK_NUMPAD2:
                makeMove(new Point(activeBoard.x,activeBoard.y), new Point(2,1));
                if(gamePanel.computer) botMove();
                break;
            case KeyEvent.VK_NUMPAD3:
                makeMove(new Point(activeBoard.x,activeBoard.y), new Point(2,2));
                if(gamePanel.computer) botMove();
                break;
        }
    }
}
