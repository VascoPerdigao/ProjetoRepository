import java.util.LinkedList;

public enum DadosAplicacao {
    INSTANCIA;

    private LinkedList<Evento> eventos;
    private LinkedList<Atleta> atletas;
    private int id_atleta;
    private int id_evento;

    DadosAplicacao() {
        eventos = new LinkedList<>();
        atletas = new LinkedList<>();
        id_evento=1;
        id_atleta=1;
    }


    public void adicionarEvento(Evento evento){
        if (evento == null || eventos.contains(evento)){
            return;
        }
        eventos.add(evento);
    }

    public void removerEvento(Evento evento){
        if (evento == null){
            return;
        }
        eventos.remove(evento);
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

    public Evento getEvento(int id){
        return eventos.get(id);
    }

    public LinkedList<Evento> getEventos() {
        return new LinkedList<>(eventos);
    }

    public int contarAtletas(){
        int cont=0;
        for(Atleta atleta : atletas){
            cont++;
        }
        return cont;
    }

    public int contarEventos(){
        int cont=0;
        for(Evento evento : eventos){
            cont++;
        }
        return cont;
    }

    public int atribuirIDEvento(){
        int id=id_evento++;
        return id;
    }

    public int atribuirIDAtleta(){
        int id=id_atleta++;
        return id;
    }
}
