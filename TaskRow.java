
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

public class TaskRow {

    private JButton delButton;
    protected JCheckBox checkBox;
    protected JTextField txtField;
    private ToDo toDo;

    JPanel panel;

    public TaskRow(ToDo toDo) {
        this.toDo = toDo;

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 6));

        delButton = new JButton("X");
        delButton.setFont(new Font("Arial", Font.BOLD, 16));
        delButton.setBackground(Color.WHITE);
        delButton.setFocusable(false);
        delButton.setFocusPainted(false);
        delButton.addActionListener(e->{
           toDo.handleDelete(this);
        });
        checkBox = new JCheckBox();

        txtField = new JTextField(20);
       

        txtField.setHorizontalAlignment(JTextField.CENTER);
        txtField.setFont(new Font("Arial", Font.BOLD, 16));
        txtField.setBackground(Color.WHITE);

        

        panel.setBackground(new Color(200, 230, 255));
        panel.add(checkBox);
        panel.add(txtField);
        panel.add(delButton);

    }

   

}
