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
    private JLabel descricao;

    public SelecionarAtleta(char tipo) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelEditar);
        for (int i = 0; i < DadosAplicacao.INSTANCIA.contarAtletas(); i++) {
            ListaAtletas.addItem(DadosAplicacao.INSTANCIA.getAtletas().get(i).getNomeEID());
        }

        if(tipo=='E') {

            editarButton.addActionListener(this::editarButtonPerformed);
        }
        if(tipo=='D'){
            descricao.setText("Escolha o Atleta que pertende eliminar");
            editarButton.setText("Eliminar");
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
