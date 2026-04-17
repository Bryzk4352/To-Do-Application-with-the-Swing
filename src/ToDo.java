
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public final class ToDo extends JFrame {

    private JPanel mainPanel;
    private JPanel taskPanel;
    private final ArrayList<TaskRow> tasks = new ArrayList<>();

    public ToDo() {
        super("To-Do App");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        upperLayout();
        mainLayout();
    }

    private void upperLayout() {
        JPanel upperPanel = new JPanel();
        upperPanel.setBackground(new Color(30, 58, 138));
        JLabel txtTODO = new JLabel("TO-DO APP", SwingConstants.CENTER);
        txtTODO.setForeground(Color.WHITE);
        txtTODO.setFont(new Font("Monospaced", Font.BOLD, 20));
        upperPanel.add(txtTODO);
        add(upperPanel, BorderLayout.NORTH);
    }

    private void mainLayout() {

        mainPanel = new JPanel(new BorderLayout());

        JScrollPane scroll = new JScrollPane(mainPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll, BorderLayout.CENTER);

        JPanel addPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        addPanel.setOpaque(false);
        mainPanel.add(addPanel, BorderLayout.NORTH); // add to north

        JPanel wrapPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         taskPanel = new JPanel();
         taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
         
        wrapPanel.add(taskPanel);
        mainPanel.add(wrapPanel, BorderLayout.CENTER);

        JButton cmdAdd = new JButton("+");
        cmdAdd.setPreferredSize(new Dimension(70, 30));
        cmdAdd.setFocusable(false);
        cmdAdd.setFocusPainted(false);
        cmdAdd.setBackground(Color.WHITE);
        addPanel.add(cmdAdd);

        cmdAdd.addActionListener(e -> {
            TaskRow task = new TaskRow(this);
            tasks.add(task);
            taskPanel.add(task.panel);
            taskPanel.revalidate();
            taskPanel.repaint();

        });
    }
                           
    public void handleDelete(TaskRow taskDel) {
        tasks.remove(taskDel);
        taskPanel.remove(taskDel.panel);
        taskPanel.revalidate();
        taskPanel.repaint();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
            new ToDo().setVisible(true);
        });

 }
}

