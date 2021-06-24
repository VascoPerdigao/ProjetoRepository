import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TabelaProvasAssociadas extends DefaultTableModel {

    public TabelaProvasAssociadas(JTable listaProvas, int evento_associado){
        String [] colums = {"Número de Prova","Prova"};
        DefaultTableModel model = new DefaultTableModel(colums, 0);


        for (Prova prova: DadosAplicacao.INSTANCIA.getProvas()) {
            if(prova.getEvento_associado()==evento_associado) {
                Integer ID = prova.getProva_ID();
                String nome = prova.getNome();

                Object[] objects = {ID, nome};

                model.addRow(objects);
            }
        }
        listaProvas.setModel(model);
    }
}