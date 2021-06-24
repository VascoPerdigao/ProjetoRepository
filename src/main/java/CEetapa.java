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
