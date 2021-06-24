import javax.swing.*;
import java.awt.event.ActionEvent;

public class CEetapa extends JFrame {
    private JPanel painelCEetapa;
    private JButton voltarAtrasButton;
    private JButton criar_editarButton;
    private JTextField diaTextField;
    private JTextField horaTextField;
    private JTextField rondaTextField;
    private JTextField minimosTextField;
    private JRadioButton mRadioButton;
    private JRadioButton fRadioButton;
    private JTextField minTextField;
    private JTextField mesTextField;
    private JTextField anoTextField;
    private JLabel CEtitulo;
    private JTextField compTextField;
    private int id_prova;

    public CEetapa(char tipoCEEtapa, int ID_prova) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelCEetapa);
        id_prova=ID_prova;
        CEtitulo.setText("Criar Etapa");
        criar_editarButton.addActionListener(this::criarButtonPerformed);
        voltarAtrasButton.addActionListener(this::voltarAtrasButtonPerformed);


        pack();
        setVisible(true);
    }

    public void voltarAtrasButtonPerformed(ActionEvent e) {
        setVisible(false);

    }

    public void criarButtonPerformed(ActionEvent e){
        char genero='M';
       Data data = new Data(Integer.parseInt(diaTextField.getText()),Integer.parseInt(mesTextField.getText()),Integer.parseInt(anoTextField.getText()));
        if(( Integer.parseInt(diaTextField.getText()) < 0 | Integer.parseInt(diaTextField.getText())  > 32)) {
            JOptionPane.showMessageDialog(new JFrame(), "Erro: O dia da data de etapa tem de ser um número inteiro entre 1 e 31.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        else if(Integer.parseInt(mesTextField.getText()) < 0 | Integer.parseInt(mesTextField.getText()) > 12){
            JOptionPane.showMessageDialog(new JFrame(), "Erro: O mês da data de etapa tem de ser um número inteiro entre 1 e 12.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        else if(Integer.parseInt(anoTextField.getText()) < 0 | Integer.parseInt(anoTextField.getText()) > 2021){
            JOptionPane.showMessageDialog(new JFrame(), "Erro: O ano da data de etapa tem de ser um número inteiro entre 1 e 2021.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
       String comp = compTextField.getText();
        if(mRadioButton.isSelected()){
             genero = 'M';
        }
        else if(fRadioButton.isSelected()){
             genero = 'F';
        }
        String ronda = rondaTextField.getText();
        Double minimos = Double.parseDouble(minimosTextField.getText());
        int id = DadosAplicacao.INSTANCIA.atribuitIDEtapa();
        Etapa etapa = new Etapa(data,comp,genero,ronda,minimos,id_prova,id);
        DadosAplicacao.INSTANCIA.adicionar(etapa);
        setVisible(false);
    }
}
