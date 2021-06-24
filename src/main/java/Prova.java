import java.util.LinkedList;


public class Prova {
    private String nome;
    private int prova_ID;
    private LinkedList<Etapa> etapas;
    private int evento_associado=0;


    public Prova(String nome, Integer prova_ID,int evento_associado) {
        this.nome = nome;
        this.prova_ID = prova_ID;
        etapas = new LinkedList<>();
        this.evento_associado=evento_associado;

    }

    public void editarProva(String nome, Integer prova_ID){
        this.nome = nome;
        this.prova_ID = prova_ID;
    }

    public void associarEvento(Integer evento_associado){
        this.evento_associado=evento_associado;
    }

    public void adicionarEtapa(Etapa etapa){
        if (etapa == null || etapas.contains(etapa)){
            return;
        }
        etapas.add(etapa);
    }

    public int getEvento_associado() {
        return evento_associado;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeEID() {
        return String.valueOf(prova_ID).concat(" | ").concat(nome);
    }

    public Integer getProva_ID() {
        return prova_ID;
    }


}
