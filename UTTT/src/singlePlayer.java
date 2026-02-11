import javax.swing.*;
import java.awt.*;

public class singlePlayer extends JPanel {
    public singlePlayer() {
        setLayout(new BorderLayout());

        whoStartsPanel whoStarts = new whoStartsPanel();

        JPanel panelButtons = new JPanel();
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) getParent().getLayout();
            cl.show(getParent(), "menu");
        });
        panelButtons.add(returnButton);

        JPanel panelDifficulty = getPanel(whoStarts);

        add(whoStarts, BorderLayout.NORTH);
        add(panelDifficulty, BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);
    }

    private JPanel getPanel(whoStartsPanel whoStarts) {
        String[] modes = {"easy", "medium", "hard"};
        JPanel panelDifficulty = new JPanel(new GridLayout(1, 3));
        for (String mode : modes) {
            JButton modeButton = new JButton(mode);
            modeButton.addActionListener(e -> {
                new gamePanel(whoStarts.getSelectedPlayer().charAt(0), true);
                Window window = SwingUtilities.getWindowAncestor(singlePlayer.this);
                window.dispose();
            });
            panelDifficulty.add(modeButton);
        }
        return panelDifficulty;
    }
}
