import javax.swing.*;
import java.awt.event.ActionEvent;

public class RecordeMundial extends JFrame{
    private JPanel painelRecordeMundial;
    private JTable table1;
    private JButton voltarAtrasButton;

    public RecordeMundial(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelRecordeMundial);

        voltarAtrasButton.addActionListener(this::voltarAtr√°sButtonPerformed);


        pack();
        setVisible(true);

    }

    public void voltarAtr√°sButtonPerformed(ActionEvent e) {
        new Estatistica();
        dispose();

    }
}
