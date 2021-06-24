import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarAtleta extends JFrame {

    JFileChooser saver = new JFileChooser("./");
    int returnVal = saver.showSaveDialog(this);
    File file = saver.getSelectedFile();
    BufferedWriter writer = null;



    public GuardarAtleta() {

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Dados de todos os Atletas registados atualmente na aplicação:\n");
            bw.write("-----------------------------------------------------------------------------\n");
            for (int i = 0; i < DadosAplicacao.INSTANCIA.contarAtletas(); i++) {
                bw.write(DadosAplicacao.INSTANCIA.getAtletas().get(i).getNomeEID()  + "\n");
                bw.write("Nome do Atleta: " + DadosAplicacao.INSTANCIA.getAtleta(i).getNome() + "\n");
                if(DadosAplicacao.INSTANCIA.getAtleta(i).getGenero() == 'M'){
                    bw.write("Género: Masculino \n");
                }
                else if(DadosAplicacao.INSTANCIA.getAtleta(i).getGenero() == 'F'){
                    bw.write("Género: Feminino \n");
                }
                bw.write("Data de Nascimento: " + DadosAplicacao.INSTANCIA.getAtleta(i).getDta_nascimento().getDia() +"/" +
                        DadosAplicacao.INSTANCIA.getAtleta(i).getDta_nascimento().getMes() +"/" + DadosAplicacao.INSTANCIA.getAtleta(i).getDta_nascimento().getAno() +"\n");
                bw.write("País: " + DadosAplicacao.INSTANCIA.getAtleta(i).getPaís() + "\n");
                bw.write("Contacto: " + DadosAplicacao.INSTANCIA.getAtleta(i).getContacto() + "\n");
                bw.write("-----------------------------------------------------------------------------\n");
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        int input = JOptionPane.showConfirmDialog(null,
                "Ficheiro com os atletas registados na aplicação criado com sucesso.", "Informação", JOptionPane.DEFAULT_OPTION);


        new janelaMegaEventos("Mega Eventos");
        dispose();

    }

}
