import javax.swing.*;
import java.awt.event.ActionEvent;

public class SelecionarAtleta extends JFrame{
    private JPanel painelEditar;
    private JButton editarButton;
    private JComboBox comboBox1;
    private JButton voltarAtrasButton;
    private JButton menuPrincipalButton;

    public SelecionarAtleta() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelEditar);

        voltarAtrasButton.addActionListener(this::voltarAtrásButtonPerformed);

        pack();
        setVisible(true);


    }


    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new GerirAtleta();
        dispose();

    }


}
