import java.util.LinkedList;

public enum DadosAplicacao {
    INSTANCIA;

    private LinkedList<Evento> eventos;
    private LinkedList<Atleta> atletas;
    private LinkedList<Prova> provas;
    private LinkedList<Etapa> etapas;
    private int id_atleta;
    private int id_evento;
    private int id_prova;
    private int id_etapa;

    DadosAplicacao() {
        eventos = new LinkedList<>();
        atletas = new LinkedList<>();
        provas = new LinkedList<>();
        etapas = new LinkedList<>();
        id_evento=1;
        id_atleta=1;
        id_prova=1;
        id_etapa=1;
    }

    //Evento

    public void adicionar(Evento evento){
        if (evento == null || eventos.contains(evento)){
            return;
        }
        eventos.add(evento);
    }

    public void remover(Evento evento){
        if (evento == null){
            return;
        }
        eventos.remove(evento);
    }

    public Evento getEvento(int id){
        return eventos.get(id);
    }

    public LinkedList<Evento> getEventos() {
        return new LinkedList<>(eventos);
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

    //atleta

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



    //PROVA

    public Prova getProva(int id){
        return provas.get(id);
    }

    public LinkedList<Prova> getProvas() {
        return new LinkedList<>(provas);
    }



    public void adicionar(Prova prova){
        if (prova == null || provas.contains(prova)){
            return;
        }
        provas.add(prova);
    }
    public void remover(Prova prova){
        if (prova == null){
            return;
        }
        provas.remove(prova);
    }

    public int contarProvas(){
        int cont=0;
        for(Prova prova : provas){
            cont++;
        }
        return cont;
    }

    public int atribuitIDProva(){
        int id=id_prova++;
        return id;
    }

    //ETAPAS
    public LinkedList<Etapa> getEtapas() {
        return new LinkedList<>(etapas);
    }

    public Etapa getEtapa(int id){
        return etapas.get(id);
    }


    public int atribuitIDEtapa(){
        int id=id_etapa++;
        return id;
    }

    public void adicionar(Etapa etapa){
        if (etapa == null || etapas.contains(etapa)){
            return;
        }
        etapas.add(etapa);
    }

    public int contarEtapas(){
        int cont=0;
        for(Etapa etapa : etapas){
            cont++;
        }
        return cont;
    }






}
