import javax.swing.*;
import java.awt.event.ActionEvent;

public class AtribuirNumero extends JFrame{
    private JPanel panel1;
    private JLabel numeroAtribuido;
    private JButton conlcuirButton;

    AtribuirNumero(int num){
        numeroAtribuido.setText(String.valueOf(num));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        conlcuirButton.addActionListener(this::conlcuirButtonPerformed);
        pack();
        setVisible(true);

    }

    public void conlcuirButtonPerformed(ActionEvent e) {
        new GerirAtleta();
        dispose();

    }
}
