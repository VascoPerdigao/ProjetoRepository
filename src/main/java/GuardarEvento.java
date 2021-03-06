import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarEvento extends JFrame {

    JFileChooser saver = new JFileChooser("./");
    int returnVal = saver.showSaveDialog(this);
    File file = saver.getSelectedFile();
    BufferedWriter writer = null;


    public GuardarEvento() {


        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Dados de todos os Eventos registados atualmente na aplicação:\n");
            bw.write("-----------------------------------------------------------------------------\n");
            for (int i = 0; i < DadosAplicacao.INSTANCIA.contarEventos(); i++) {
                bw.write(DadosAplicacao.INSTANCIA.getEventos().get(i).getNomeEID() + "\n");
                bw.write("Nome do Evento: " + DadosAplicacao.INSTANCIA.getEvento(i).getNome() + "\n");
                bw.write("Data de Ínicio: " + DadosAplicacao.INSTANCIA.getEvento(i).getDta_inicio().getDia() + "/" +
                        DadosAplicacao.INSTANCIA.getEvento(i).getDta_inicio().getMes() + "/" + DadosAplicacao.INSTANCIA.getEvento(i).getDta_inicio().getAno() + "\n");
                bw.write("Data de Fim: " + DadosAplicacao.INSTANCIA.getEvento(i).getDta_fim().getDia() + "/" +
                        DadosAplicacao.INSTANCIA.getEvento(i).getDta_fim().getMes() + "/" + DadosAplicacao.INSTANCIA.getEvento(i).getDta_fim().getAno() + "\n");
                bw.write("Local: " + DadosAplicacao.INSTANCIA.getEvento(i).getLocal() + "\n");
                bw.write("País: " + DadosAplicacao.INSTANCIA.getEvento(i).getPaís() + "\n");
                bw.write("-----------------------------------------------------------------------------\n");
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        int input = JOptionPane.showConfirmDialog(null,
                "Ficheiro com os eventos registados na aplicação criado com sucesso.", "Informação", JOptionPane.DEFAULT_OPTION);


        new janelaMegaEventos("Mega Eventos");
        dispose();
    }

}
