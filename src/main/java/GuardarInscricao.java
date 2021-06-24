import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarInscricao extends JFrame {

    JFileChooser saver = new JFileChooser("./");
    int returnVal = saver.showSaveDialog(this);
    File file = saver.getSelectedFile();
    BufferedWriter writer = null;



    public GuardarInscricao() {

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Dados de todas as Inscrições registados atualmente na aplicação:\n");
            bw.write("-----------------------------------------------------------------------------\n");
            for (int i = 0; i < DadosAplicacao.INSTANCIA.contarInscritos(); i++) {
                bw.write("Atleta:" + DadosAplicacao.INSTANCIA.getInscrito(i).getAtleta()  + "\n");
                bw.write("Evento:" + DadosAplicacao.INSTANCIA.getInscrito(i).getEvento() + "\n");
                bw.write("Prova: " + DadosAplicacao.INSTANCIA.getInscrito(i).getProva() + "/n");
                bw.write("Marca alcançada: " + DadosAplicacao.INSTANCIA.getInscrito(i).getMarca() + "\n");
                bw.write("País: " + DadosAplicacao.INSTANCIA.getInscrito(i).getPais() + "\n");
                bw.write("-----------------------------------------------------------------------------\n");
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        int input = JOptionPane.showConfirmDialog(null,
                "Ficheiro com as inscrições registadas na aplicação criado com sucesso.", "Informação", JOptionPane.DEFAULT_OPTION);


        new janelaMegaEventos("Mega Eventos");
        dispose();

    }

}