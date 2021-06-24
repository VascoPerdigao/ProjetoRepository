import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TabelaProvaEtapaModel {

    public TabelaProvaEtapaModel(JTable listaEtapas,int id_prova){
        String [] colums = {"ID","ID da Prova","dia"};
        DefaultTableModel model = new DefaultTableModel(colums, 0);


        for (Etapa etapa: DadosAplicacao.INSTANCIA.getEtapas()) {
            if(etapa.getProva_associado()==id_prova) {
                Integer ID = etapa.getId();
                String dia_comp = etapa.getDia_comp();
                Integer ID_Prova = etapa.getProva_associado();


                Object[] objects = {ID,ID_Prova, dia_comp};

                model.addRow(objects);
            }
        }
        listaEtapas.setModel(model);
    }

}
