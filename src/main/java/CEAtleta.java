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
    private JLabel titulo;
    private String nome, pais;
    private char genero;
    private Integer ano, mes, dia;
    private Long contacto;
    private int ID_atleta;
    private Atleta atletaSelecionado;




    public CEAtleta(char tipoCEAtleta, int atletaID) {
        if (tipoCEAtleta=='E'){
            titulo.setText("Editar Atleta");
            criarButton.setText("Editar");
            atletaSelecionado = DadosAplicacao.INSTANCIA.getAtletas().get(atletaID);
            nomeTextField.setText(String.valueOf(atletaSelecionado.getNome()));
            if(atletaSelecionado.getGenero()=='F'){
                fRadioButton.setSelected(true);
            }else if(atletaSelecionado.getGenero()=='M'){
                mRadioButton.setSelected(true);
            }
            ID_atleta = atletaSelecionado.getAtleta_ID();
            paisTextField.setText(atletaSelecionado.getPaís());
            diaTextField.setText(String.valueOf(atletaSelecionado.getDta_nascimento().getAno()));
            mesTextField.setText(String.valueOf(atletaSelecionado.getDta_nascimento().getMes()));
            anoTextField.setText(String.valueOf(atletaSelecionado.getDta_nascimento().getDia()));
            contactoTextField.setText(String.valueOf(atletaSelecionado.getContacto()));
            criarButton.addActionListener(this::editarButtonPerformed);
            voltarAtrasButton.addActionListener(this::voltarAtrásEditarButtonPerformed);
        }else {
            titulo.setText("Criar Atleta");
            criarButton.addActionListener(this::criarButtonPerformed);
            voltarAtrasButton.addActionListener(this::voltarAtrásButtonPerformed);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelCriarEditar);




        pack();
        setVisible(true);
    }

    public void editarButtonPerformed(ActionEvent e) {
        nome = nomeTextField.getText();
        if(semNumeros(nome) == false){
            JOptionPane.showMessageDialog(new JFrame(), "Erro: Não são permitidos números no nome de atleta.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            System.out.println(nome);
            if (mRadioButton.isSelected()) {
                genero = 'M';
            } else if (fRadioButton.isSelected()) {
                genero = 'F';
            }
            //System.out.println(genero);
            pais = paisTextField.getText();
            if(semNumeros(pais) == false){
                JOptionPane.showMessageDialog(new JFrame(), "Erro: Não são permitidos números no país do atleta.", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                // System.out.println(pais);
                dia = Integer.parseInt(diaTextField.getText());
                mes = Integer.parseInt(mesTextField.getText());
                ano = Integer.parseInt(anoTextField.getText());
                // System.out.println("Data: " + dia + "/" + mes + "/" + ano);
                contacto = Long.parseLong(contactoTextField.getText());
                if (contarDigitios(contacto) != 9) {
                    JOptionPane.showMessageDialog(new JFrame(), "Erro: Apenas são permitidos números de telemóvel com 9 dígitos.", "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    if(( dia < 0 | dia > 32)) {
                        JOptionPane.showMessageDialog(new JFrame(), "Erro: O dia da data de nascimento tem de ser um número inteiro entre 1 e 31.", "ERRO",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    else if(mes < 0 | mes > 12){
                        JOptionPane.showMessageDialog(new JFrame(), "Erro: O mês da data de nascimento tem de ser um número inteiro entre 1 e 12.", "ERRO",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    else if(ano < 0 | ano > 2021){
                        JOptionPane.showMessageDialog(new JFrame(), "Erro: O ano da data de nascimento tem de ser um número inteiro entre 1 e 2021.", "ERRO",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        //System.out.println("Contacto:" + contacto);
                        Data dta_nascimento = new Data(dia, mes, ano);
                        int id_atleta = ID_atleta;
                        // System.out.println(id_atleta);
                        atletaSelecionado.editarAtleta(nome, id_atleta, genero, pais, dta_nascimento, contacto);
                        new GerirAtleta();
                        setVisible(false);
                    }
                }
            }
        }
    }


    public void criarButtonPerformed(ActionEvent e) {
        nome = nomeTextField.getText();
        if(semNumeros(nome) == false){
            JOptionPane.showMessageDialog(new JFrame(), "Erro: Não são permitidos números no nome de atleta.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            // System.out.println(nome);
            if (mRadioButton.isSelected()) {
                genero = 'M';
            } else if (fRadioButton.isSelected()) {
                genero = 'F';
            }
            // System.out.println(genero);
            pais = paisTextField.getText();
            if(semNumeros(pais) == false){
                JOptionPane.showMessageDialog(new JFrame(), "Erro: Não são permitidos números no país do atleta.", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                //System.out.println(pais);
                dia = Integer.parseInt(diaTextField.getText());
                mes = Integer.parseInt(mesTextField.getText());
                ano = Integer.parseInt(anoTextField.getText());
                // System.out.println("Data: "+ dia + "/"+ mes +"/"+ ano);
                contacto = Long.parseLong(contactoTextField.getText());
                if (contarDigitios(contacto) != 9) {
                    JOptionPane.showMessageDialog(new JFrame(), "Erro: Apenas são permitidos números de telemóvel com 9 dígitos.", "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    // System.out.println("Contacto:" + contacto);
                    if(( dia < 0 | dia > 32)) {
                        JOptionPane.showMessageDialog(new JFrame(), "Erro: O dia da data de nascimento tem de ser um número inteiro entre 1 e 31.", "ERRO",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    else if(mes < 0 | mes > 12){
                        JOptionPane.showMessageDialog(new JFrame(), "Erro: O mês da data de nascimento tem de ser um número inteiro entre 1 e 12.", "ERRO",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    else if(ano < 0 | ano > 2021){
                        JOptionPane.showMessageDialog(new JFrame(), "Erro: O ano da data de nascimento tem de ser um número inteiro entre 1 e 2021.", "ERRO",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Data dta_nascimento = new Data(dia, mes, ano);
                        int id_atleta;
                        id_atleta = DadosAplicacao.INSTANCIA.atribuirIDAtleta();
                        //System.out.println(id_atleta);
                        Atleta atleta = new Atleta(nome, id_atleta, genero, pais, dta_nascimento, contacto);

                        DadosAplicacao.INSTANCIA.adicionar(atleta);
                        new AtribuirNumero(id_atleta);
                        setVisible(false);
                    }
                }
            }
        }
    }



    public void voltarAtrásButtonPerformed(ActionEvent e) {
        new GerirAtleta();
        dispose();

    }
    public void voltarAtrásEditarButtonPerformed(ActionEvent e) {
        new Selecionar('E');
        dispose();

    }

    int contarDigitios(long n)
    {
        int count = 0;
        while (n != 0)
        {
            n = n / 10;
            ++count;
        }
        return count;
    }

    public static boolean semNumeros(String s) {
        for(char c : s.toCharArray())
            if (!Character.isLetter(c)) return false;
        return true;
    }


}
