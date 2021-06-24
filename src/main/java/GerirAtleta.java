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
        criarAtletaButton.addActionListener(this::criarAtletaButtonButtonPerformed);
        editarAtletaButton.addActionListener(this::editarAtletaButtonPerformed);
        listarAtletasButton.addActionListener(this::listarAtletasButtonPerformed);
        eliminarAtletaButton.addActionListener(this::eliminarAtletaButtonPerformed);
        importarAtletasButton.addActionListener(this::importarAtletasButtonPerformed);
        guardarAtletasButton.addActionListener(this::guardarAtletasButtonPerformed);


        pack();
        setVisible(true);

    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new janelaMegaEventos("Mega Eventos");
        dispose();

    }



    public void criarAtletaButtonButtonPerformed(ActionEvent e) {
        new CEAtleta('C',0);
        dispose();

    }

    public void editarAtletaButtonPerformed(ActionEvent e) {
       SelecionarAtleta selecionarAtleta=new SelecionarAtleta('E');
       selecionarAtleta.titulo.setText("Editar Atleta");
        dispose();

    }
    public void eliminarAtletaButtonPerformed(ActionEvent e) {
        SelecionarAtleta selecionarAtleta=new SelecionarAtleta('D'); //D- delete e E- Editar
        selecionarAtleta.titulo.setText("Eliminar Atleta");
        dispose();
    }

    public void listarAtletasButtonPerformed(ActionEvent e) {
        new Listar();
        dispose();

    }



    public void importarAtletasButtonPerformed(ActionEvent e) {
        Importar_exportar importarExportar = new Importar_exportar();
        importarExportar.tituloImportar.setText("Importar teste");
        dispose();
    }

    public void guardarAtletasButtonPerformed(ActionEvent e) {
        Importar_exportar exportar = new Importar_exportar();
        exportar.tituloImportar.setText("Guardar Atletas");
        exportar.Ficheiro_selecionar.setText("Clique em guardar para continuar");
        exportar.importarFicheiroButton.setText("Exportar Ficheiro");

        dispose();
    }







}
