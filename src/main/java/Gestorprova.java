import javax.swing.*;
import java.awt.event.ActionEvent;

public class Gestorprova extends JFrame {
    private JPanel painelGestorProva;
    private JButton criarProvaButton;
    private JButton editarProvaButton;
    private JButton eliminarProvaButton;
    private JButton voltarAtrásButton;

    public Gestorprova(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelGestorProva);

        voltarAtrásButton.addActionListener(this::voltarAtrásButtonPerformed);
        criarProvaButton.addActionListener(this::criarProvaButtonButtonPerformed);
        editarProvaButton.addActionListener(this::editarProvaButtonPerformed);

        eliminarProvaButton.addActionListener(this::eliminarProvaButtonPerformed);



        pack();
        setVisible(true);

    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new janelaMegaEventos("Mega Eventos");
        dispose();

    }



    public void criarProvaButtonButtonPerformed(ActionEvent e) {
        new CEprova('C',0);
        dispose();

    }

    public void editarProvaButtonPerformed(ActionEvent e) {
        Selecionar selecionar =new Selecionar('T');
        selecionar.titulo.setText("Editar Prova");
        dispose();

    }
    public void eliminarProvaButtonPerformed(ActionEvent e) {
        Selecionar selecionar =new Selecionar('P');
        selecionar.titulo.setText("Eliminar Prova");
        dispose();
    }


}
