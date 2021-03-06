import javax.swing.*;
import java.awt.event.ActionEvent;

public class janelaMegaEventos extends JFrame{
    private JPanel painelMegaEventos;
    private JButton consultarPistasButton;
    private JButton inscriçãoDeAtletasButton;
    private JButton gerirEventosButton;
    private JButton gerirProvasButton;
    private JButton gerirAtletasButton;
    private JButton registarResultadoDeUmaButton;
    private JButton estatisticaButton;
    private JButton sairButton;


    public janelaMegaEventos(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelMegaEventos);


        // Causes this Window to be sized to fit the preferred size and layout of its subcomponents.
        pack();
        setVisible(true);

        consultarPistasButton.addActionListener(this::consultarPistasButtonPerformed);
        sairButton.addActionListener(this::btnSairActionPerformed);
        gerirEventosButton.addActionListener(this::btngerirEventosButton);
        gerirAtletasButton.addActionListener(this::btngerirAtletasButton);
        gerirProvasButton.addActionListener(this::btngerirProvasButton);
        inscriçãoDeAtletasButton.addActionListener(this::inscriçãoDeAtletasButtonActionPerformed);
        estatisticaButton.addActionListener(this::estatisticaButtonActionPerformed);
        registarResultadoDeUmaButton.addActionListener(this::registarResultadoDeUmaButtonActionPerformed);

    }

    private void btngerirEventosButton(ActionEvent e) {
        new GestorEventos();
        dispose();
    }

    private void btngerirAtletasButton(ActionEvent e) {
        new GerirAtleta();
        dispose();
    }
    private void btngerirProvasButton(ActionEvent e) {
        new Gestorprova();
        dispose();
    }

    private void consultarPistasButtonPerformed(ActionEvent e) {
        new ConsultarPistas();
        dispose();
    }


    private void estatisticaButtonActionPerformed(ActionEvent e) {
        new Estatistica();
        dispose();
    }

    private void registarResultadoDeUmaButtonActionPerformed(ActionEvent e) {
        new RegistarResultado();
        dispose();
    }




    private void inscriçãoDeAtletasButtonActionPerformed(ActionEvent e) {
        new GestorInscricao();
        dispose();
    }



    private void btnSairActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public static void main(String[] args) {
        new janelaMegaEventos("Mega Eventos").setVisible(true);
    }

}
