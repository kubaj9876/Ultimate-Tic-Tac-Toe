import javax.swing.*;
import java.awt.*;

public class multiplayerFrame extends JPanel {
    public multiplayerFrame() {
        whoStartsPanel whoStarts = new whoStartsPanel();

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(1, 2));
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) getParent().getLayout();
            cl.show(getParent(), "menu");
        });
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            new gamePanel(whoStarts.getSelectedPlayer().charAt(0), false);
            Window window = SwingUtilities.getWindowAncestor(multiplayerFrame.this);
            window.dispose();
        });
        panelButtons.add(returnButton);
        panelButtons.add(startButton);
        setLayout(new BorderLayout());
        add(whoStarts, BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);
    }
}
