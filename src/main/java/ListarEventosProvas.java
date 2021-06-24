import javax.swing.*;
import java.awt.event.ActionEvent;

public class ListarEventosProvas extends JFrame {
    private JPanel painelListar;
    private JCheckBox checkBox1;
    private JComboBox listaEventos;
    private JCheckBox checkBox2;
    private JComboBox listaProvas;
    private JButton procurarButton;
    private JTable TabelaEventosProvas;
    private JButton voltarAtrásButton;

    public ListarEventosProvas(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelListar);

        for (int i = 0; i < DadosAplicacao.INSTANCIA.contarEventos(); i++) {
            listaEventos.addItem(DadosAplicacao.INSTANCIA.getEventos().get(i).getNomeEID());
        }

        for (int i = 0; i < DadosAplicacao.INSTANCIA.contarProvas(); i++) {
            listaProvas.addItem(DadosAplicacao.INSTANCIA.getProvas().get(i).getNomeEID());
        }

        voltarAtrásButton.addActionListener(this::voltarAtrásButtonPerformed);

        pack();
        setVisible(true);
    }


    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new GestorEventos();
        dispose();
    }



}
