public class Etapa {
    private Data data;
    private String dia_comp;
    private Character genero;
    private String ronda;
    private double minimos;
    private int prova_associado;
    private int id;

    public Etapa(Data data, String dia_comp, Character genero, String ronda, double minimos, int prova_associado,int id) {
        this.data = data;
        this.dia_comp = dia_comp;
        this.genero = genero;
        this.ronda = ronda;
        this.minimos = minimos;
        this.prova_associado = prova_associado;
        this.id =id;

    }

    public void editarEtapa(Data data, String dia_comp, Character genero, String ronda, double minimos, int prova_associado,int id) {
        this.data = data;
        this.dia_comp = dia_comp;
        this.genero = genero;
        this.ronda = ronda;
        this.minimos = minimos;
        this.prova_associado = prova_associado;
        this.id =id;

    }

    public Data getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public String getDia_comp() {
        return dia_comp;
    }

    public Character getGenero() {
        return genero;
    }

    public String getRonda() {
        return ronda;
    }

    public double getMinimos() {
        return minimos;
    }

    public int getProva_associado() {
        return prova_associado;
    }
}
