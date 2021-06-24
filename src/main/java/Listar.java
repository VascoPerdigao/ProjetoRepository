import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Listar extends JFrame{
    private JPanel painelListar;
    private JTable table1;
    private JButton voltarAtrásButton;

    public Listar(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelListar);
        new TabelaAtletaModel(table1);
        voltarAtrásButton.addActionListener(this::voltarAtrásButtonPerformed);

        pack();
        setVisible(true);
    }


    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new GerirAtleta();
        dispose();
    }



}
