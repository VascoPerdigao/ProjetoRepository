import javax.swing.*;
import java.awt.event.ActionEvent;

public class CEevento extends JFrame{
    private JPanel painelCriarEditar;
    private JTextField nomeTextField;
    private JTextField diaTextField;
    private JTextField dia2TextField;
    private JTextField localTextField;
    private JTextField paisTextField;
    private JButton associarProvaButton;
    private JButton confirmarButton;
    private JButton voltarAtrasButton;
    private JButton menuPrincipalButton;
    private JTextField mesTextField;
    private JTextField anoTextField;
    private JTextField mes2TextField;
    private JTextField ano2TextField;
    private JLabel titulo;
    private JComboBox listaProvas;
    private JTable listaProvasAssociadas;
    private int ID_evento;
    private Evento eventoSelecionado;
    private String nome, pais, local;
    private Integer anoInicio, mesInicio, diaInicio, anoFim, mesFim, diaFim;
    private int prova_a_associar;

    public CEevento(char tipoCEEvento, int eventoID) {
        if (tipoCEEvento=='E'){
            titulo.setText("Edição de Evento");
            confirmarButton.setText("Editar");
            eventoSelecionado = DadosAplicacao.INSTANCIA.getEventos().get(eventoID);
            nomeTextField.setText(String.valueOf(eventoSelecionado.getNome()));
            ID_evento = eventoID;
            diaTextField.setText(String.valueOf(eventoSelecionado.getDta_inicio().getAno()));
            mesTextField.setText(String.valueOf(eventoSelecionado.getDta_inicio().getMes()));
            anoTextField.setText(String.valueOf(eventoSelecionado.getDta_inicio().getDia()));
            dia2TextField.setText(String.valueOf(eventoSelecionado.getDta_fim().getAno()));
            mes2TextField.setText(String.valueOf(eventoSelecionado.getDta_fim().getMes()));
            ano2TextField.setText(String.valueOf(eventoSelecionado.getDta_fim().getDia()));
            localTextField.setText(eventoSelecionado.getLocal());
            paisTextField.setText(eventoSelecionado.getPaís());
            confirmarButton.addActionListener(this::editarEventoButtonPerformed);

            new TabelaProvasAssociadas(listaProvasAssociadas,eventoID);
            associarProvaButton.addActionListener(this::associarProvaButtonPerformed);
        }else {
            titulo.setText("Criação de Evento");
            confirmarButton.addActionListener(this::confirmarButtonPerformed);

            for (int i = 0; i < DadosAplicacao.INSTANCIA.contarProvas(); i++) {
                listaProvas.addItem(DadosAplicacao.INSTANCIA.getProvas().get(i).getNomeEID());
            }
            prova_a_associar = listaProvas.getSelectedIndex();
            associarProvaButton.addActionListener(this::associarProvaButtonPerformed);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelCriarEditar);
        voltarAtrasButton.addActionListener(this::voltarAtrasButtonPerformed);



        pack();
        setVisible(true);
    }

    public void editarEventoButtonPerformed(ActionEvent e) {
        nome = nomeTextField.getText();
        if(semNumeros(nome) == false){
            JOptionPane.showMessageDialog(new JFrame(), "Erro: Não são permitidos números no nome de evento.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            diaInicio = Integer.parseInt(diaTextField.getText());
            mesInicio = Integer.parseInt(mesTextField.getText());
            anoInicio = Integer.parseInt(anoTextField.getText());
            diaFim = Integer.parseInt(dia2TextField.getText());
            mesFim = Integer.parseInt(mes2TextField.getText());
            anoFim = Integer.parseInt(ano2TextField.getText());
            if(( diaInicio < 0 | diaInicio > 32)) {
                JOptionPane.showMessageDialog(new JFrame(), "Erro: O dia da data de início tem de ser um número inteiro entre 1 e 31.", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
            else if(mesInicio < 0 | mesInicio > 12){
                JOptionPane.showMessageDialog(new JFrame(), "Erro: O mês da data de início tem de ser um número inteiro entre 1 e 12.", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
            else if(anoInicio < 0 | anoInicio > 2021){
                JOptionPane.showMessageDialog(new JFrame(), "Erro: O ano da data de início tem de ser um número inteiro entre 1 e 2021.", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(( diaFim < 0 | diaFim > 32)) {
                    JOptionPane.showMessageDialog(new JFrame(), "Erro: O dia da data de término tem de ser um número inteiro entre 1 e 31.", "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                }
                else if(mesFim < 0 | mesFim > 12){
                    JOptionPane.showMessageDialog(new JFrame(), "Erro: O mês da data de término tem de ser um número inteiro entre 1 e 12.", "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                }
                else if(anoFim < 0 | anoFim > 2021){
                    JOptionPane.showMessageDialog(new JFrame(), "Erro: O ano da data de término tem de ser um número inteiro entre 1 e 2021.", "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                }
                else {
                    local = localTextField.getText();
                    if(semNumeros(local) == false){
                        JOptionPane.showMessageDialog(new JFrame(), "Erro: Não são permitidos números no local do evento.", "ERRO",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        pais = paisTextField.getText();
                        if(semNumeros(pais) == false){
                            JOptionPane.showMessageDialog(new JFrame(), "Erro: Não são permitidos números no país do evento.", "ERRO",
                                    JOptionPane.ERROR_MESSAGE);
                        }

                        Data dta_inicio = new Data(diaInicio, mesInicio, anoInicio);
                        Data dta_fim = new Data(diaFim, mesFim, anoFim);
                        int id_evento = ID_evento;
                        //System.out.println(id_evento);
                        eventoSelecionado.editarEvento(nome, id_evento, dta_inicio, dta_fim, local, pais);
                        new GestorEventos();
                        dispose();
                    }
                }

            }

        }
    }

    public void confirmarButtonPerformed(ActionEvent e) {
        nome = nomeTextField.getText();
        if(semNumeros(nome) == false){
            JOptionPane.showMessageDialog(new JFrame(), "Erro: Não são permitidos números no nome de evento.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        else{
            diaInicio = Integer.parseInt(diaTextField.getText());
            mesInicio = Integer.parseInt(mesTextField.getText());
            anoInicio = Integer.parseInt(anoTextField.getText());
            diaFim = Integer.parseInt(dia2TextField.getText());
            mesFim = Integer.parseInt(mes2TextField.getText());
            anoFim = Integer.parseInt(ano2TextField.getText());
            if(( diaInicio < 0 | diaInicio > 32)) {
                JOptionPane.showMessageDialog(new JFrame(), "Erro: O dia da data de início tem de ser um número inteiro entre 1 e 31.", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
            else if(mesInicio < 0 | mesInicio > 12){
                JOptionPane.showMessageDialog(new JFrame(), "Erro: O mês da data de início tem de ser um número inteiro entre 1 e 12.", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
            else if(anoInicio < 0 | anoInicio > 2021){
                JOptionPane.showMessageDialog(new JFrame(), "Erro: O ano da data de início tem de ser um número inteiro entre 1 e 2021.", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                if(( diaFim < 0 | diaFim > 32)) {
                    JOptionPane.showMessageDialog(new JFrame(), "Erro: O dia da data de término tem de ser um número inteiro entre 1 e 31.", "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                }
                else if(mesFim < 0 | mesFim > 12){
                    JOptionPane.showMessageDialog(new JFrame(), "Erro: O mês da data de término tem de ser um número inteiro entre 1 e 12.", "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                }
                else if(anoFim < 0 | anoFim > 2021){
                    JOptionPane.showMessageDialog(new JFrame(), "Erro: O ano da data de término tem de ser um número inteiro entre 1 e 2021.", "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                }
                else {
                    local = localTextField.getText();
                    if (semNumeros(local) == false) {
                        JOptionPane.showMessageDialog(new JFrame(), "Erro: Não são permitidos números no local do evento.", "ERRO",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        pais = paisTextField.getText();
                        if (semNumeros(pais) == false) {
                            JOptionPane.showMessageDialog(new JFrame(), "Erro: Não são permitidos números no país do evento.", "ERRO",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            Data dta_inicio = new Data(diaInicio, mesInicio, anoInicio);
                            Data dta_fim = new Data(diaFim, mesFim, anoFim);
                            int id_evento;

                            id_evento = DadosAplicacao.INSTANCIA.atribuirIDEvento();


                            // System.out.println(id_evento);
                            Evento evento = new Evento(nome, id_evento, dta_inicio, dta_fim, local, pais);

                            for (int i = 0; i < DadosAplicacao.INSTANCIA.contarProvas(); i++) {
                                if (DadosAplicacao.INSTANCIA.getProva(i).getEvento_associado() == id_evento) {
                                    evento.adicionarProva(DadosAplicacao.INSTANCIA.getProva(i));
                                }

                            }
                            DadosAplicacao.INSTANCIA.adicionar(evento);
                            new GestorEventos();
                            dispose();
                        }
                    }
                }
            }

        }
    }

    public void associarProvaButtonPerformed(ActionEvent e) {


        new TabelaProvasAssociadas(listaProvasAssociadas,ID_evento);



    }

    public void voltarAtrasButtonPerformed(ActionEvent e) {
        new GestorEventos();
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
