import javax.swing.*;
import java.awt.event.ActionEvent;

public class GestorInscricao extends JFrame{
    private JPanel painelGestorInsc;
    private JButton inscreverAltetaButton;
    private JButton cancelarInscriçãoButton;
    private JButton importarInscriçõesButton;
    private JButton guardarInscriçõesButton;
    private JButton voltarAtrásButton;

    public GestorInscricao(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelGestorInsc);

        voltarAtrásButton.addActionListener(this::voltarAtrásButtonPerformed);
        inscreverAltetaButton.addActionListener(this::inscreverAltetaButtonPerformed);
        cancelarInscriçãoButton.addActionListener(this::cancelarInscriçãoButtonPerformed);
        importarInscriçõesButton.addActionListener(this::importarInscriçõesButtonPerformed);
        guardarInscriçõesButton.addActionListener(this::guardarInscriçõesButtonPerformed);




        pack();
        setVisible(true);

    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new janelaMegaEventos("Mega Eventos");
        dispose();

    }

    public void inscreverAltetaButtonPerformed(ActionEvent e) {
        new Inscricao();
        dispose();

    }

    public void cancelarInscriçãoButtonPerformed(ActionEvent e) {
        new CancelInscricao();
        dispose();

    }

    public void importarInscriçõesButtonPerformed(ActionEvent e) {
        new Importar_exportar();
        dispose();

    }

    public void guardarInscriçõesButtonPerformed(ActionEvent e) {
        GuardarInscricao guardarInscricao = new GuardarInscricao();
        dispose();

    }


}
