import javax.swing.*;
import java.awt.*;

public class winnerDialog extends Component {
    public winnerDialog(String winnerText) {
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Koniec gry", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(this);

        JLabel label = new JLabel("Gracz " + winnerText + " wygrał", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        dialog.add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton exitButton = new JButton("Wyjdź");
        exitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(exitButton);

        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
}
