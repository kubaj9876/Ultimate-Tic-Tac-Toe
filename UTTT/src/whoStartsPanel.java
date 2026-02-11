import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class whoStartsPanel extends JPanel {
    private final ButtonGroup groupRadio = new ButtonGroup();

    public whoStartsPanel() {
        setLayout(new GridLayout(1, 3));

        JRadioButton X = new JRadioButton("X");
        JRadioButton O = new JRadioButton("O");

        groupRadio.add(X);
        groupRadio.add(O);
        X.setSelected(true);

        add(new JLabel("Kto zaczyna:"));
        add(X);
        add(O);
    }

    public String getSelectedPlayer() {
        Enumeration<AbstractButton> buttons = groupRadio.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}
