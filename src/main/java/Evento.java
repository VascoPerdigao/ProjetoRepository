import java.util.LinkedList;

public class Evento {
    private String nome;
    private Integer evento_ID = 0;
    private Data dta_inicio, dta_fim;
    private String Local, País;
    private LinkedList<Prova> provas;


    public Evento(String nome, Integer evento_ID, Data dta_inicio, Data dta_fim, String local, String país) {
        this.nome = nome;
        this.evento_ID = evento_ID;
        this.dta_inicio = dta_inicio;
        this.dta_fim = dta_fim;
        Local = local;
        País = país;
    }

    public void editarEvento(String nome, Integer evento_ID, Data dta_inicio, Data dta_fim, String local, String país){
        this.nome = nome;
        this.evento_ID = evento_ID;
        this.dta_inicio = dta_inicio;
        this.dta_fim = dta_fim;
        Local = local;
        País = país;
    }

    public void adicionarProva(Prova prova){
        if (prova == null || provas.contains(prova)){
            return;
        }
        provas.add(prova);
    }



    public String getNome() {
        return nome;
    }

    public Integer getEvento_ID() {
        return evento_ID;
    }

    public Data getDta_inicio() {
        return dta_inicio;
    }

    public Data getDta_fim() {
        return dta_fim;
    }

    public String getLocal() {
        return Local;
    }

    public String getPaís() {
        return País;
    }

    public String getNomeEID() {
        return String.valueOf(evento_ID).concat(" | ").concat(nome);
    }
}
