import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TabelaAtletaModel extends DefaultTableModel {

    public TabelaAtletaModel(JTable listaAtletas){
        String [] colums = {"ID", "Nome", "Genero", "Pais", "Data Nascimento", "Contacto"};
        DefaultTableModel model = new DefaultTableModel(colums, 0);


        for (Atleta atleta: DadosAplicacao.INSTANCIA.getAtletas()) {
            Integer ID = atleta.getAtleta_ID();
            String nome = atleta.getNome();
            Character genero = atleta.getGenero();
            String pais = atleta.getPaís();
            Data dta_nascimento = atleta.getDta_nascimento();
            Long contacto = atleta.getContacto();

            Object[] objects = {ID, nome, genero, pais, dta_nascimento, contacto};

            model.addRow(objects);
        }
        listaAtletas.setModel(model);
    }
}