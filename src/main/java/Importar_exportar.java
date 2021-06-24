import javax.swing.*;
import java.awt.event.ActionEvent;

public class Importar_exportar extends JFrame{
    private JPanel painelImportar;
    public JLabel tituloImportar;
    public JButton importarFicheiroButton;
    private JButton voltarAtrásButton;
    private JButton menuPrincipalButton;
    public JLabel Ficheiro_selecionar;


    public Importar_exportar() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelImportar);

        voltarAtrásButton.addActionListener(this::voltarAtrásButtonPerformed);
        menuPrincipalButton.addActionListener(this::menuPrincipalButtonButtonPerformed);

        pack();
        setVisible(true);
    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new GerirAtleta();
        dispose();

    }

    public void menuPrincipalButtonButtonPerformed(ActionEvent e) {
        new janelaMegaEventos("Mega Eventos");
        dispose();
    }

}
