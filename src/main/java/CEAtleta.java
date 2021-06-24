import javax.swing.*;
import java.awt.event.ActionEvent;

public class CEAtleta extends JFrame{
    private JPanel painelCriarEditar;
    private JTextField nomeTextField;
    private JButton voltarAtrasButton;
    private JButton criarButton;
    private JTextField paisTextField;
    private JTextField diaTextField;
    private JTextField contactoTextField;
    private JRadioButton mRadioButton;
    private JRadioButton fRadioButton;
    private JTextField mesTextField;
    private JTextField anoTextField;
    private String nome, pais;
    private char genero;
    private Integer ano, mes, dia;
    private Long contacto;
    private int ID_atleta;
    private Atleta atletaSelecionado;




    public CEAtleta(char tipoCEAtleta, int atletaID) {
        if (tipoCEAtleta=='E'){
            atletaSelecionado = DadosAplicacao.INSTANCIA.getAtletas().get(atletaID);
            nomeTextField.setText(String.valueOf(atletaSelecionado.getNome()));
            if(atletaSelecionado.getGenero()=='F'){
                fRadioButton.setSelected(true);
            }else if(atletaSelecionado.getGenero()=='M'){
                mRadioButton.setSelected(true);
            }
            ID_atleta = atletaSelecionado.getAtleta_ID();
            paisTextField.setText(atletaSelecionado.getPaís());
            diaTextField.setText(String.valueOf(atletaSelecionado.getDta_nascimento().getDia()));
            mesTextField.setText(String.valueOf(atletaSelecionado.getDta_nascimento().getMes()));
            anoTextField.setText(String.valueOf(atletaSelecionado.getDta_nascimento().getAno()));
            contactoTextField.setText(String.valueOf(atletaSelecionado.getContacto()));
            criarButton.addActionListener(this::editarButtonPerformed);
        }else {

            criarButton.addActionListener(this::criarButtonPerformed);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelCriarEditar);
        voltarAtrasButton.addActionListener(this::voltarAtrásButtonPerformed);



        pack();
        setVisible(true);
    }

    public void editarButtonPerformed(ActionEvent e) {
        nome = nomeTextField.getText();
        System.out.println(nome);
        if(mRadioButton.isSelected()){
            genero = 'M';
        }
        else if(fRadioButton.isSelected()){
            genero = 'F';
        }
        System.out.println(genero);
        pais = paisTextField.getText();
        System.out.println(pais);
        dia = Integer.parseInt(diaTextField.getText());
        mes = Integer.parseInt(mesTextField.getText());
        ano = Integer.parseInt(anoTextField.getText());
        System.out.println("Data: "+ dia + "/"+ mes +"/"+ ano);
        contacto = Long.parseLong(contactoTextField.getText());
        System.out.println("Contacto:" + contacto);
        Data dta_nascimento= new Data(dia,mes,ano);
        int id_atleta = ID_atleta;
        System.out.println(id_atleta);
        atletaSelecionado.editarAtleta(nome,id_atleta,genero,pais,dta_nascimento,contacto);


    }


    public void criarButtonPerformed(ActionEvent e) {
        nome = nomeTextField.getText();
        System.out.println(nome);
        if(mRadioButton.isSelected()){
            genero = 'M';
        }
        else if(fRadioButton.isSelected()){
            genero = 'F';
        }
        System.out.println(genero);
        pais = paisTextField.getText();
        System.out.println(pais);
        dia = Integer.parseInt(diaTextField.getText());
        mes = Integer.parseInt(mesTextField.getText());
        ano = Integer.parseInt(anoTextField.getText());
        System.out.println("Data: "+ dia + "/"+ mes +"/"+ ano);
        contacto = Long.parseLong(contactoTextField.getText());
        System.out.println("Contacto:" + contacto);
        Data dta_nascimento= new Data(dia,mes,ano);
        int id_atleta;

            id_atleta = DadosAplicacao.INSTANCIA.contarAtletas() + 1;

        System.out.println(id_atleta);
        Atleta atleta = new Atleta(nome,id_atleta,genero,pais,dta_nascimento,contacto);
        DadosAplicacao.INSTANCIA.adicionar(atleta);

    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new GerirAtleta();
        dispose();

    }



}
