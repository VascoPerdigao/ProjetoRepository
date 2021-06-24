import javax.swing.*;
import java.awt.event.ActionEvent;

public class CEevento extends JFrame{
    private JPanel painelCriarEditar;
    private JTextField nomeTextField;
    private JTextField diaTextField;
    private JTextField dia2TextField;
    private JTextField localTextField;
    private JTextField paisTextField;
    private JTextField textField6;
    private JList list1;
    private JButton associarProvaButton;
    private JButton confirmarButton;
    private JButton voltarAtrasButton;
    private JButton menuPrincipalButton;
    private JTextField mesTextField;
    private JTextField anoTextField;
    private JTextField mes2TextField;
    private JTextField ano2TextField;
    private JLabel titulo;
    private int ID_evento;
    private Evento eventoSelecionado;
    private String nome, pais, local;
    private Integer anoInicio, mesInicio, diaInicio, anoFim, mesFim, diaFim;

    public CEevento(char tipoCEEvento, int eventoID) {
        if (tipoCEEvento=='E'){
            titulo.setText("Edição de Evento");
            confirmarButton.setText("Editar");
            eventoSelecionado = DadosAplicacao.INSTANCIA.getEventos().get(eventoID);
            nomeTextField.setText(String.valueOf(eventoSelecionado.getNome()));
            ID_evento = eventoSelecionado.getEvento_ID();
            diaTextField.setText(String.valueOf(eventoSelecionado.getDta_inicio().getDia()));
            mesTextField.setText(String.valueOf(eventoSelecionado.getDta_inicio().getMes()));
            anoTextField.setText(String.valueOf(eventoSelecionado.getDta_inicio().getAno()));
            dia2TextField.setText(String.valueOf(eventoSelecionado.getDta_fim().getDia()));
            mes2TextField.setText(String.valueOf(eventoSelecionado.getDta_fim().getMes()));
            ano2TextField.setText(String.valueOf(eventoSelecionado.getDta_fim().getAno()));
            localTextField.setText(eventoSelecionado.getLocal());
            paisTextField.setText(eventoSelecionado.getPaís());
            confirmarButton.addActionListener(this::editarEventoButtonPerformed);
        }else {
            titulo.setText("Criação de Evento");
            confirmarButton.addActionListener(this::confirmarButtonPerformed);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelCriarEditar);
        voltarAtrasButton.addActionListener(this::voltarAtrasButtonPerformed);



        pack();
        setVisible(true);
    }

    public void editarEventoButtonPerformed(ActionEvent e) {
        nome = nomeTextField.getText();
        System.out.println(nome);
        diaInicio = Integer.parseInt(diaTextField.getText());
        mesInicio = Integer.parseInt(mesTextField.getText());
        anoInicio = Integer.parseInt(anoTextField.getText());
        diaFim = Integer.parseInt(dia2TextField.getText());
        mesFim = Integer.parseInt(mes2TextField.getText());
        anoFim = Integer.parseInt(ano2TextField.getText());
        System.out.println("Data Ínicio: "+ diaInicio + "/"+ mesInicio +"/"+ anoInicio);
        System.out.println("Data Fim: "+ diaFim + "/"+ mesFim +"/"+ anoFim);
        local = localTextField.getText();
        System.out.println(local);
        pais = paisTextField.getText();
        System.out.println(pais);
        Data dta_inicio= new Data(diaInicio,mesInicio,anoInicio);
        Data dta_fim= new Data(diaFim,mesFim,anoFim);
        int id_evento = ID_evento;
        System.out.println(id_evento);
        eventoSelecionado.editarEvento(nome,id_evento,dta_inicio, dta_fim, local, pais);


    }

    public void confirmarButtonPerformed(ActionEvent e) {
        nome = nomeTextField.getText();
        System.out.println(nome);
        diaInicio = Integer.parseInt(diaTextField.getText());
        mesInicio = Integer.parseInt(mesTextField.getText());
        anoInicio = Integer.parseInt(anoTextField.getText());
        diaFim = Integer.parseInt(dia2TextField.getText());
        mesFim = Integer.parseInt(mes2TextField.getText());
        anoFim = Integer.parseInt(ano2TextField.getText());
        System.out.println("Data Ínicio: "+ diaInicio + "/"+ mesInicio +"/"+ anoInicio);
        System.out.println("Data Fim: "+ diaFim + "/"+ mesFim +"/"+ anoFim);
        local = localTextField.getText();
        System.out.println(local);
        pais = paisTextField.getText();
        System.out.println(pais);
        Data dta_inicio= new Data(diaInicio,mesInicio,anoInicio);
        Data dta_fim= new Data(diaFim,mesFim,anoFim);
        int id_evento;

        id_evento = DadosAplicacao.INSTANCIA.atribuirIDEvento();

        System.out.println(id_evento);
        Evento evento = new Evento(nome,id_evento,dta_inicio, dta_fim, local, pais);
        DadosAplicacao.INSTANCIA.adicionarEvento(evento);

        new GestorEventos();
        dispose();

    }

    public void voltarAtrasButtonPerformed(ActionEvent e) {
        new GestorEventos();
        dispose();

    }
}
