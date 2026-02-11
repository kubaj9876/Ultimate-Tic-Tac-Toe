import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {
    public MenuFrame() {
        setTitle("Menu");
        setSize(400, 200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JButton singleplayer = new JButton("Single player");
        JButton multiplayer = new JButton("Multiplayer");

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(singleplayer);
        panel.add(multiplayer);

        JPanel tabbedPane = new JPanel(new CardLayout());
        CardLayout cl = (CardLayout)tabbedPane.getLayout();
        tabbedPane.add(panel, "menu");
        tabbedPane.add(new singlePlayer(), "single player");
        tabbedPane.add(new multiplayerFrame(), "multiplayer");

        singleplayer.addActionListener(e -> cl.show(tabbedPane, "single player"));
        multiplayer.addActionListener(e -> cl.show(tabbedPane, "multiplayer"));

        add(tabbedPane, BorderLayout.CENTER);
    }
}
