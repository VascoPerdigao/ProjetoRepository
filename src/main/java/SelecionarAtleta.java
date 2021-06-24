import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class SelecionarAtleta extends JFrame{
    private JPanel painelEditar;
    private JButton editarButton;
    private JComboBox ListaAtletas;
    private JButton voltarAtrasButton;
    private JButton menuPrincipalButton;
    public JLabel titulo;

    public SelecionarAtleta(char tipo) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelEditar);
        for (int i = 0; i < DadosAplicacao.INSTANCIA.contarAtletas(); i++) {
            ListaAtletas.addItem(DadosAplicacao.INSTANCIA.getAtletas().get(i).getAtleta_ID());
        }

        if(tipo=='E') {
            editarButton.addActionListener(this::editarButtonPerformed);
        }
        if(tipo=='D'){
            editarButton.addActionListener(this::eliminarButtonPerformed);
        }


        voltarAtrasButton.addActionListener(this::voltarAtrásButtonPerformed);

        pack();
        setVisible(true);


    }
    public void editarButtonPerformed(ActionEvent e) {
        new CEAtleta('E',  ListaAtletas.getSelectedIndex());
        dispose();

    }
    public void eliminarButtonPerformed(ActionEvent e) {
        Atleta atleta = DadosAplicacao.INSTANCIA.getAtleta(ListaAtletas.getSelectedIndex());
        DadosAplicacao.INSTANCIA.remover(atleta);
        new GerirAtleta();
        dispose();

    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new GerirAtleta();
        dispose();

    }


}
