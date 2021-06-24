import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NomeFicheiro extends JFrame {
    private JPanel painelNomeFicheiro;
    private JButton menuPrincipalButton;

    JFileChooser saver = new JFileChooser("./");
    int returnVal = saver.showSaveDialog(this);
    File file = saver.getSelectedFile();
    BufferedWriter writer = null;



    public NomeFicheiro() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelNomeFicheiro);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < DadosAplicacao.INSTANCIA.contarEventos(); i++) {
                bw.write("Dados de todos os eventos registados atualmente na aplicação:\n");
                bw.write(DadosAplicacao.INSTANCIA.getEventos().get(i).getNomeEID()  + "\n");
                bw.write("Nome Evento: " + DadosAplicacao.INSTANCIA.getEvento(i).getNome() + "\n");
                bw.write("Data de Ínicio: " + DadosAplicacao.INSTANCIA.getEvento(i).getDta_inicio().getDia() +"/" +
                        DadosAplicacao.INSTANCIA.getEvento(i).getDta_inicio().getMes() +"/" + DadosAplicacao.INSTANCIA.getEvento(i).getDta_inicio().getAno() +"\n");
                bw.write("Data de Fim: " + DadosAplicacao.INSTANCIA.getEvento(i).getDta_fim().getDia() +"/" +
                        DadosAplicacao.INSTANCIA.getEvento(i).getDta_fim().getMes() +"/" + DadosAplicacao.INSTANCIA.getEvento(i).getDta_fim().getAno() +"\n");
                bw.write("Local: " + DadosAplicacao.INSTANCIA.getEvento(i).getLocal() + "\n");
                bw.write("País: " + DadosAplicacao.INSTANCIA.getEvento(i).getPaís() + "\n");
                bw.write("-----------------------------------------------------------------------------\n");
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        menuPrincipalButton.addActionListener(this::menuPrincipalButtonPerformed);

        pack();
        setVisible(true);
    }

    public void menuPrincipalButtonPerformed(ActionEvent e) {
        new janelaMegaEventos("Mega Eventos");
        dispose();
    }

}
