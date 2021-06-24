import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConsultarPistas extends JFrame{
    private JPanel painelConsultarPista;
    private JComboBox eventos;
    private JComboBox provas;
    private JComboBox etapas;
    private JTable table1;
    private JButton voltarAtrásButton;

    public ConsultarPistas(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelConsultarPista);

        voltarAtrásButton.addActionListener(this::voltarAtrásButtonPerformed);

        for (int i = 0; i < DadosAplicacao.INSTANCIA.contarEventos(); i++) {
            eventos.addItem(DadosAplicacao.INSTANCIA.getEventos().get(i).getNomeEID());
        }

        for (int i = 0; i < DadosAplicacao.INSTANCIA.contarProvas(); i++) {
            provas.addItem(DadosAplicacao.INSTANCIA.getProvas().get(i).getNomeEID());
        }

        for (int i = 0; i < DadosAplicacao.INSTANCIA.contarEtapas(); i++) {
            etapas.addItem(DadosAplicacao.INSTANCIA.getEtapas().get(i).getId());
        }

        pack();
        setVisible(true);

    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new janelaMegaEventos("Mega Eventos");
        setVisible(false);

    }
}
