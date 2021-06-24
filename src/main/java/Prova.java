import java.util.LinkedList;

public class Prova {
    private String nome;
    private int prova_ID;


    public Prova(String nome, Integer prova_ID) {
        this.nome = nome;
        this.prova_ID = prova_ID;

    }

    public void editarProva(String nome, Integer prova_ID){
        this.nome = nome;
        this.prova_ID = prova_ID;
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
