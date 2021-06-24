import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConsultarPistas extends JFrame{
    private JPanel painelConsultarPista;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JTable table1;
    private JButton voltarAtrásButton;

    public ConsultarPistas(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelConsultarPista);

        voltarAtrásButton.addActionListener(this::voltarAtrásButtonPerformed);

        pack();
        setVisible(true);

    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new janelaMegaEventos("Mega Eventos");
        setVisible(false);

    }
}
