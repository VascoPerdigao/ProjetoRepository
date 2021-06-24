public class Inscrito {
    private String atleta;
    private String evento;
    private String prova;
    private String marca;
    private String pais;

    public Inscrito(String atleta, String evento, String prova, String marca, String pais) {
        this.atleta = atleta;
        this.evento = evento;
        this.prova = prova;
        this.marca = marca;
        this.pais = pais;
    }

    public String getAtleta() {
        return atleta;
    }

    public String getEvento() {
        return evento;
    }

    public String getProva() {
        return prova;
    }

    public String getMarca() {
        return marca;
    }

    public String getPais() {
        return pais;
    }

    public String getNomeEID() {
        return String.valueOf(atleta).concat(" | ").concat(evento).concat(" | ").concat(prova);
    }
}
