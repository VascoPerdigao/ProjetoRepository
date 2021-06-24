import javax.swing.*;
import java.awt.event.ActionEvent;


public class GestorEventos extends JFrame {
    private JPanel painelGestorEventos;
    private JButton criarEventoButton;
    private JButton editarEventoButton;
    private JButton eliminarEventoButton;
    private JButton listarEventosProvasButton;
    private JButton importarEventoButton;
    private JButton guardarEventoButton;
    private JButton voltarAtrásButton;

    public GestorEventos(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelGestorEventos);

        voltarAtrásButton.addActionListener(this::voltarAtrásButtonPerformed);
        criarEventoButton.addActionListener(this::criarEventoButtonButtonPerformed);
        editarEventoButton.addActionListener(this::editarEventoButtonPerformed);
        eliminarEventoButton.addActionListener(this::eliminarEventoButtonPerformed);
        listarEventosProvasButton.addActionListener(this::listarEventosProvasButtonPerformed);
       // importarEventoButton.addActionListener(this::importarEventoButtonPerformed);
       guardarEventoButton.addActionListener(this::guardarEventoButtonPerformed);

        pack();
        setVisible(true);

    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new janelaMegaEventos("Mega Eventos");
        dispose();

    }

    public void criarEventoButtonButtonPerformed(ActionEvent e) {
        new CEevento('C', 0);
        dispose();
    }

    public void editarEventoButtonPerformed(ActionEvent e) {
        Selecionar selecionar =new Selecionar('F'); //G- delete e F- Editar
        selecionar.titulo.setText("Edição de Evento");
        selecionar.descricao.setText("Selecione o evento que pretende editar:");
        dispose();
    }

    public void eliminarEventoButtonPerformed(ActionEvent e) {
        Selecionar selecionar =new Selecionar('G'); //G- delete e F- Editar
        selecionar.titulo.setText("Eliminar Evento");
        dispose();
    }

    public void listarEventosProvasButtonPerformed(ActionEvent e) {
        new ListarEventosProvas();
        dispose();

    }

    public void guardarEventoButtonPerformed(ActionEvent e) {
        new GuardarEvento();
        dispose();

    }
}
