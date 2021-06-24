import javax.swing.*;
import java.awt.event.ActionEvent;

public class Inscricao extends JFrame {
    private JPanel painelInscricao;
    private JComboBox atletas;
    private JButton voltarAtrásButton;
    private JButton concluir;
    private JComboBox eventos;
    private JComboBox provas;
    private JTextField marca;
    private JTextField pais;
    private String nomeAtleta, nomeEvento, nomeProva, marca2,pais2;
    private Inscrito inscrito;

    public Inscricao(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelInscricao);

        for (int i = 0; i < DadosAplicacao.INSTANCIA.contarAtletas(); i++) {
            atletas.addItem(DadosAplicacao.INSTANCIA.getAtletas().get(i).getNomeEID());
        }

        for (int i = 0; i < DadosAplicacao.INSTANCIA.contarEventos(); i++) {
            eventos.addItem(DadosAplicacao.INSTANCIA.getEventos().get(i).getNomeEID());
        }

        for (int i = 0; i < DadosAplicacao.INSTANCIA.contarProvas(); i++) {
            provas.addItem(DadosAplicacao.INSTANCIA.getProvas().get(i).getNomeEID());
        }


        voltarAtrásButton.addActionListener(this::voltarAtrásButtonPerformed);
        concluir.addActionListener(this::concluirButtonPerformed);

        pack();
        setVisible(true);

    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new GestorInscricao();
        dispose();
    }

    public void concluirButtonPerformed(ActionEvent e) {
        nomeAtleta=atletas.getSelectedItem().toString();
        nomeEvento=eventos.getSelectedItem().toString();
        nomeProva=provas.getSelectedItem().toString();
        marca2 = marca.getText();
        pais2 = pais.getText();

        inscrito = new Inscrito(nomeAtleta,nomeEvento,nomeProva,marca2,pais2);
        DadosAplicacao.INSTANCIA.adicionar(inscrito);

        System.out.println(nomeAtleta + "," + nomeEvento +", " +nomeProva + "," + marca2 + "," + pais2);

        new GestorInscricao();
        setVisible(false);
    }



}
