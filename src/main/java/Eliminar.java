import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Eliminar extends JFrame{
    private JPanel painelEliminar;
    private JComboBox comboBox1;
    private JButton eliminarButton;
    private JButton voltarAtrásButton;
    private JButton menuPrincipalButton;


    public Eliminar() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelEliminar);

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
