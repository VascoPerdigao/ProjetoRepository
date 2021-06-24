import java.util.LinkedList;

public enum DadosAplicacao {
    INSTANCIA;

    private LinkedList<Atleta> atletas;
    private int id_atleta;

    DadosAplicacao() {
        atletas = new LinkedList<>();
        id_atleta=1;
    }


    public void adicionar(Atleta atleta){
        if (atleta == null || atletas.contains(atleta)){
            return;
        }
        atletas.add(atleta);
    }

    public void remover(Atleta atleta){
        if (atleta == null){
            return;
        }
        atletas.remove(atleta);
    }

    public Atleta getAtleta(int id){
        return atletas.get(id);
    }

    public LinkedList<Atleta> getAtletas(){return new LinkedList<>(atletas);}

    public int contarAtletas(){
        int cont=0;
        for(Atleta atleta : atletas){
            cont++;
        }
        return cont;
    }

    public int atribuirIDAtleta(){
        int id=id_atleta++;
        return id;
    }
}
