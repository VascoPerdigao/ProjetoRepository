import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class CEprova extends JFrame{
    private JPanel panel1;
    private JButton voltarAtrasButton;
    private JButton criarButton;
    private JButton criarEtapaButton;
    private JTextField nomeTextField;
    private JLabel titulo;
    private JTable table1;
    private JButton atualizarTabelaButton;
    private String nome;
    private Prova provaSelecionada;
    private int id;

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
            id = DadosAplicacao.INSTANCIA.atribuitIDProva();
            titulo.setText("Criar Prova");
            criarButton.addActionListener(this::criarButtonPerformed);
            criarEtapaButton.addActionListener(this::criarEtapaButtonPerformed);
            voltarAtrasButton.addActionListener(this::voltarAtrasButtonPerformed);
        }
        atualizarTabelaButton.addActionListener(this::atualizarTabelaButtonPerform);


        pack();
        setVisible(true);
    }

    public void criarButtonPerformed(ActionEvent e) {
        nome = nomeTextField.getText();
        if(semNumeros(nome) == false){
            JOptionPane.showMessageDialog(new JFrame(), "Erro: Não são permitidos números no nome da prova.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {

            Prova prova = new Prova(nome, id);
            DadosAplicacao.INSTANCIA.adicionar(prova);
            new Gestorprova();
            setVisible(false);
        }
    }
    public void EditarProvaButtonPerformed(ActionEvent e) {
        nome = nomeTextField.getText();
        if(semNumeros(nome) == false){
            JOptionPane.showMessageDialog(new JFrame(), "Erro: Não são permitidos números no nome da prova.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            int id = provaSelecionada.getProva_ID();

            provaSelecionada.editarProva(nome, id);
            new Gestorprova();
            setVisible(false);
        }

    }

    public void atualizarTabelaButtonPerform(ActionEvent e) {

        new TabelaProvaEtapaModel(table1);

    }

    public void criarEtapaButtonPerformed(ActionEvent e) {
        new CEetapa('C',id);
        new TabelaProvaEtapaModel(table1);

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

    public static boolean semNumeros(String s) {
        for(char c : s.toCharArray())
            if (!Character.isLetter(c)) return false;
        return true;
    }
}
