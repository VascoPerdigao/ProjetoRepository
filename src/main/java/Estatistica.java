import javax.swing.*;
import java.awt.event.ActionEvent;

public class Estatistica extends JFrame{
    private JPanel painelEstatistica;
    private JButton listarOsPaisesMaisMedalhadosButton;
    private JButton listarOsRecordesDoButton;
    private JButton voltarAtrasButton;

    public Estatistica(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelEstatistica);

        voltarAtrasButton.addActionListener(this::voltarAtr√°sButtonPerformed);
        listarOsPaisesMaisMedalhadosButton.addActionListener(this::listarOsPaisesMaisButtonPerformed);
        listarOsRecordesDoButton.addActionListener(this::listarOsRecordesDoButtonPerformed);

        pack();
        setVisible(true);

    }

    public void voltarAtr√°sButtonPerformed(ActionEvent e) {
        new janelaMegaEventos("Mega Eventos");
        dispose();

    }

    public void listarOsPaisesMaisButtonPerformed(ActionEvent e) {
        new ListaPaisesMedalhados();
        dispose();
    }

    public void listarOsRecordesDoButtonPerformed(ActionEvent e) {
        new RecordeMundial();
        dispose();

    }


}
