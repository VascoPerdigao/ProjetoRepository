import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TabelaProvasAssociadas extends DefaultTableModel {

    public TabelaProvasAssociadas(JTable listaProvas){
        String [] colums = {"Número de Prova","Prova"};
        DefaultTableModel model = new DefaultTableModel(colums, 0);


        for (Prova prova: DadosAplicacao.INSTANCIA.getProvas()) {
            Integer ID = prova.getProva_ID();
            String nome = prova.getNome();

            Object[] objects = {ID, nome};

            model.addRow(objects);
        }
        listaProvas.setModel(model);
    }
}