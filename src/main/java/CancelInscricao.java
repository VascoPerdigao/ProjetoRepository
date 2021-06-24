import javax.swing.*;
import java.awt.event.ActionEvent;

public class CancelInscricao extends JFrame{
    private JPanel painelCancelInscr;
    private JButton voltarAtrásButton;
    private JButton concluirButton;
    private JComboBox inscritos;
    private String nomeAtleta, nomeEvento, nomeProva;
    private Inscrito inscrito;

    public CancelInscricao() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelCancelInscr);

        for (int i = 0; i < DadosAplicacao.INSTANCIA.contarInscritos(); i++) {
            inscritos.addItem(DadosAplicacao.INSTANCIA.getInscritos().get(i).getNomeEID());
        }


        voltarAtrásButton.addActionListener(this::voltarAtrásButtonPerformed);
        concluirButton.addActionListener(this::concluirButtonPerformed);

        pack();
        setVisible(true);
    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new GestorInscricao();
        dispose();
    }

    public void concluirButtonPerformed(ActionEvent e) {

        inscrito= DadosAplicacao.INSTANCIA.getInscrito(0);

        for (int i = 0; i < DadosAplicacao.INSTANCIA.contarInscritos(); i++) {
            inscritos.addItem(DadosAplicacao.INSTANCIA.getInscritos().get(i).getNomeEID());
        }

        Inscrito inscrito = DadosAplicacao.INSTANCIA.getInscrito(inscritos.getSelectedIndex());
        DadosAplicacao.INSTANCIA.remover(inscrito);

        System.out.println("O atleta " + inscrito.getAtleta() + " não está mais registado na prova " + inscrito.getProva() +" do evento " + inscrito.getEvento());

        new GestorInscricao();
        setVisible(false);
    }


}
