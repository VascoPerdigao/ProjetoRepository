import javax.swing.*;
import java.awt.event.ActionEvent;

public class CEAtleta extends JFrame{
    private JPanel painelCriarEditar;
    private JTextField textField1;
    private JButton voltarAtrasButton;
    private JButton criarButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JRadioButton mRadioButton;
    private JRadioButton fRadioButton;
    private JTextField textField5;
    private JTextField textField6;


    public CEAtleta() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelCriarEditar);

        voltarAtrasButton.addActionListener(this::voltarAtrásButtonPerformed);

        pack();
        setVisible(true);
    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new GerirAtleta();
        dispose();

    }


}
