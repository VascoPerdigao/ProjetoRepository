import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class CEprova extends JFrame{
    private JPanel panel1;
    private JButton voltarAtrasButton;
    private JButton criarButton;
    private JButton criarEtapaButton;
    private JTextField nomeTextField;
    private JList list1;
    private JLabel titulo;
    private String nome;
    private Prova provaSelecionada;


    public CEprova(char tipoCEProva, int ID_prova) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        if (tipoCEProva=='E'){
            provaSelecionada = DadosAplicacao.INSTANCIA.getProva(ID_prova);

            titulo.setText("Editar Prova");
            criarButton.setText("Editar");
            nomeTextField.setText(provaSelecionada.getNome());
            criarButton.addActionListener(this::EditarProvaButtonPerformed);
            criarEtapaButton.addActionListener(this::editarEtapaButtonPerformed);
            voltarAtrasButton.addActionListener(this::voltarAtrasEditarButtonPerformed);

        }else {
            titulo.setText("Criar Prova");
            criarButton.addActionListener(this::criarButtonPerformed);
            criarEtapaButton.addActionListener(this::criarEtapaButtonPerformed);
            voltarAtrasButton.addActionListener(this::voltarAtrasButtonPerformed);
        }

        pack();
        setVisible(true);
    }

    public void criarButtonPerformed(ActionEvent e) {
        nome = nomeTextField.getText();
        System.out.println(nome);
        int id = DadosAplicacao.INSTANCIA.atribuitIDProva();
        Prova prova= new Prova(nome,id);
        DadosAplicacao.INSTANCIA.adicionar(prova);
        new Gestorprova();
        setVisible(false);
    }
    public void EditarProvaButtonPerformed(ActionEvent e) {
        nome = nomeTextField.getText();
        System.out.println(nome);
        int id = provaSelecionada.getProva_ID();

        provaSelecionada.editarProva(nome,id);
        new Gestorprova();
        setVisible(false);

    }

    public void criarEtapaButtonPerformed(ActionEvent e) {

    }
    public void editarEtapaButtonPerformed(ActionEvent e) {

    }


    public void voltarAtrasEditarButtonPerformed(ActionEvent e) {
        new Selecionar('P');
        dispose();

    }
    public void voltarAtrasButtonPerformed(ActionEvent e) {
        new Gestorprova();
        dispose();

    }
}
