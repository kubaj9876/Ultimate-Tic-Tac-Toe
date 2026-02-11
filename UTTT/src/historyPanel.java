import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class historyPanel extends JPanel {
    private static final String[] columnNames = {"L.p.", "Gracz", "Plansza", "Pole"};
    private static final DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    private static int id = 1;

    public historyPanel() {
        setPreferredSize(new Dimension(200, 400));
        setBackground(Color.DARK_GRAY);

        JTable moveTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(moveTable);
        scrollPane.setPreferredSize(new Dimension(200, 400));

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void addHistory(Object[] data){
        Object[] newData = new Object[data.length + 1];
        newData[0] = id++;
        System.arraycopy(data, 0, newData, 1, data.length);
        tableModel.addRow(newData);
    }
}
