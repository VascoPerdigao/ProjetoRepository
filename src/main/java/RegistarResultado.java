import javax.swing.*;
import java.awt.event.ActionEvent;

public class RegistarResultado extends JFrame{
    private JPanel painelRegistarResul;
    private JButton voltarAtrasButton;
    private JButton confirmarButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JComboBox comboBox9;
    private JComboBox comboBox10;
    private JComboBox comboBox11;
    private JComboBox comboBox12;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JTextField textField6;

    public RegistarResultado(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelRegistarResul);

        voltarAtrasButton.addActionListener(this::voltarAtr√°sButtonPerformed);


        pack();
        setVisible(true);

    }

    public void voltarAtr√°sButtonPerformed(ActionEvent e) {
        new janelaMegaEventos("Mega Eventos");
        dispose();

    }
}
