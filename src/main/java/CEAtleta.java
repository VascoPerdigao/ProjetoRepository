import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.util.LinkedList;

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
    //LinkedList<Atleta> atletas = new LinkedList<>();

    public CEAtleta() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelCriarEditar);

        voltarAtrasButton.addActionListener(this::voltarAtrásButtonPerformed);
        criarButton.addActionListener(this::criarButtonPerformed);

        pack();
        setVisible(true);
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
      //  Atleta atleta = new Atleta(nome, )
    }

    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new GerirAtleta();
        dispose();

    }

    /*public Integer atribuirAtleta_ID(){
        for(Atleta atleta : atletas){
            atleta_ID++;
        }


        return atleta_ID;
    }*/

}
