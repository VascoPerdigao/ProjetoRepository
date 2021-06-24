import javax.swing.*;
import java.awt.event.ActionEvent;

public class ListaPaisesMedalhados extends JFrame{
    private JPanel PaisesMedalhados;
    private JCheckBox checkBox1;
    private JTable table1;
    private JButton voltarAtrasButton;

    public ListaPaisesMedalhados(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(PaisesMedalhados);

        voltarAtrasButton.addActionListener(this::voltarAtrásButtonPerformed);


        pack();
        setVisible(true);

    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new Estatistica();
        dispose();

    }
}
