import javax.swing.*;
import java.awt.event.ActionEvent;

public class ListarEventosProvas extends JFrame {
    private JPanel painelListar;
    private JCheckBox checkBox1;
    private JComboBox comboBox1;
    private JCheckBox checkBox2;
    private JComboBox comboBox2;
    private JButton procurarButton;
    private JTable table1;
    private JButton voltarAtrásButton;

    public ListarEventosProvas(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelListar);

        voltarAtrásButton.addActionListener(this::voltarAtrásButtonPerformed);

        pack();
        setVisible(true);
    }


    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new GestorEventos();
        dispose();
    }



}
