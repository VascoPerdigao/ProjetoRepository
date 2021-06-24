import javax.swing.*;
import java.awt.event.ActionEvent;

public class NomeFicheiro extends JFrame {
    private JPanel painelNomeFicheiro;
    private JButton voltarAtrasButton;
    private JButton guardarButton;
    private JTextField textField1;

    public NomeFicheiro() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelNomeFicheiro);

        voltarAtrasButton.addActionListener(this::voltarAtrasButtonPerformed);

        pack();
        setVisible(true);
    }

    public void voltarAtrasButtonPerformed(ActionEvent e) {
        new GestorEventos();
        dispose();
    }
}
