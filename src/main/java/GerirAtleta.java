import javax.swing.*;
import java.awt.event.ActionEvent;

public class GerirAtleta extends JFrame{
    private JPanel PainelGerirAtletas;
    private JButton criarAtletaButton;
    private JButton editarAtletaButton;
    private JButton eliminarAtletaButton;
    private JButton listarAtletasButton;
    private JButton importarAtletasButton;
    private JButton guardarAtletasButton;
    private JButton voltarAtrásButton;

    public GerirAtleta(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(PainelGerirAtletas);

        voltarAtrásButton.addActionListener(this::voltarAtrásButtonPerformed);

        pack();
        setVisible(true);

    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        janelaMegaEventos janela=new janelaMegaEventos("Mega Eventos");
        dispose();

    }

    public static void main(String[] args) {
        new GerirAtleta().setVisible(true);
    }

}