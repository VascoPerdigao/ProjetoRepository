import javax.swing.*;
import java.awt.event.ActionEvent;

public class Selecionar extends JFrame{
    private JPanel painelEditar;
    private JButton editarButton;
    private JComboBox Lista;
    private JButton voltarAtrasButton;
    private JButton menuPrincipalButton;
    public JLabel titulo;
    public JLabel descricao;

    public Selecionar(char tipo) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelEditar);

        if(tipo=='E') {

            for (int i = 0; i < DadosAplicacao.INSTANCIA.contarAtletas(); i++) {
                Lista.addItem(DadosAplicacao.INSTANCIA.getAtletas().get(i).getNomeEID());
            }

            editarButton.addActionListener(this::editarButtonPerformed);
            voltarAtrasButton.addActionListener(this::voltarAtrásButtonPerformed);
        }
        if(tipo=='D'){

            for (int i = 0; i < DadosAplicacao.INSTANCIA.contarAtletas(); i++) {
                Lista.addItem(DadosAplicacao.INSTANCIA.getAtletas().get(i).getNomeEID());
            }
            descricao.setText("Escolha o Atleta que pretende eliminar");
            editarButton.setText("Eliminar");
            editarButton.addActionListener(this::eliminarButtonPerformed);
            voltarAtrasButton.addActionListener(this::voltarAtrásButtonPerformed);
        }
        if(tipo=='F') {

            for (int i = 0; i < DadosAplicacao.INSTANCIA.contarEventos(); i++) {
                Lista.addItem(DadosAplicacao.INSTANCIA.getEventos().get(i).getNomeEID());
            }

            editarButton.addActionListener(this::editarEventoButtonPerformed);
            voltarAtrasButton.addActionListener(this::voltarAtrasButtonPerformed);
        }
        if(tipo=='G'){

            for (int i = 0; i < DadosAplicacao.INSTANCIA.contarEventos(); i++) {
                Lista.addItem(DadosAplicacao.INSTANCIA.getEventos().get(i).getNomeEID());
            }
            descricao.setText("Escolha o Evento que pretende eliminar");
            editarButton.setText("Eliminar");
            editarButton.addActionListener(this::eliminarEventoButtonPerformed);
            voltarAtrasButton.addActionListener(this::voltarAtrasButtonPerformed);
        }




        pack();
        setVisible(true);


    }
    public void editarButtonPerformed(ActionEvent e) {
        new CEAtleta('E',  Lista.getSelectedIndex());
        dispose();

    }

    public void editarEventoButtonPerformed(ActionEvent e) {
        new CEevento('E',  Lista.getSelectedIndex());
        dispose();

    }
    public void eliminarButtonPerformed(ActionEvent e) {
        Atleta atleta = DadosAplicacao.INSTANCIA.getAtleta(Lista.getSelectedIndex());
        DadosAplicacao.INSTANCIA.remover(atleta);
        new GerirAtleta();
        dispose();

    }
    public void eliminarEventoButtonPerformed(ActionEvent e) {
        Evento evento = DadosAplicacao.INSTANCIA.getEvento(Lista.getSelectedIndex());
        DadosAplicacao.INSTANCIA.removerEvento(evento);
        new GestorEventos();
        dispose();

    }

    public void voltarAtrasButtonPerformed(ActionEvent e) {
        new GestorEventos();
        dispose();

    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new GerirAtleta();
        dispose();

    }



}
