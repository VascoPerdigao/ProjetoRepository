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
    private int id_etapa;
    private char genero='M';
    private Etapa etapaSelecionada;

    public CEetapa(char tipoCEEtapa, int ID_prova,int ID_etapa) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelCEetapa);
        id_prova = ID_prova;
        if(tipoCEEtapa=='E') {

            etapaSelecionada = DadosAplicacao.INSTANCIA.getEtapa(ID_etapa);
            minimosTextField.setText(String.valueOf(etapaSelecionada.getMinimos()));
            diaTextField.setText(String.valueOf(etapaSelecionada.getData().getDia()));
            mesTextField.setText(String.valueOf(etapaSelecionada.getData().getMes()));
            anoTextField.setText(String.valueOf(etapaSelecionada.getData().getAno()));
            compTextField.setText(etapaSelecionada.getDia_comp());
            rondaTextField.setText(etapaSelecionada.getRonda());
            CEtitulo.setText("Criar Etapa");
            id_etapa=etapaSelecionada.getId();
            System.out.println("etapa "+id_etapa);
            System.out.println("Prova" + id_prova);
            criar_editarButton.addActionListener(this::editarButtonPerformed);
            voltarAtrasButton.addActionListener(this::voltarAtrasButtonPerformed);
        }
        else{


            CEtitulo.setText("Criar Etapa");
            criar_editarButton.addActionListener(this::criarButtonPerformed);
            voltarAtrasButton.addActionListener(this::voltarAtrasButtonPerformed);
        }

        pack();
        setVisible(true);
    }

    public void voltarAtrasButtonPerformed(ActionEvent e) {
        setVisible(false);

    }

    public void criarButtonPerformed(ActionEvent e){

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

    public void editarButtonPerformed(ActionEvent e){

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

        etapaSelecionada.editarEtapa(data,comp,genero,ronda,minimos,id_prova,id_etapa);

        setVisible(false);
    }
}
