import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TabelaProvaEtapaModel {

    public TabelaProvaEtapaModel(JTable listaEtapas){
        String [] colums = {"ID","dia"};
        DefaultTableModel model = new DefaultTableModel(colums, 0);


        for (Etapa etapa: DadosAplicacao.INSTANCIA.getEtapas()) {
            Integer ID = etapa.getId();
            String dia_comp = etapa.getDia_comp();


            Object[] objects = {ID, dia_comp};

            model.addRow(objects);
        }
        listaEtapas.setModel(model);
    }

}
