import java.util.LinkedList;

public class Atleta {
    private String nome;
    private Integer atleta_ID = 0;
    private Character genero;
    private String País;
    private Data dta_nascimento;
    private Long contacto;


    public Atleta(String nome, Integer atleta_ID, Character genero, String país, Data dta_nascimento, Long contacto) {
        this.nome = nome;
        this.atleta_ID = atleta_ID;
        this.genero = genero;
        País = país;
        this.dta_nascimento = dta_nascimento;
        this.contacto = contacto;
    }

    public void editarAtleta(String nome, Integer atleta_ID, Character genero, String país, Data dta_nascimento, Long contacto){
        this.nome = nome;
        this.atleta_ID = atleta_ID;
        this.genero = genero;
        País = país;
        this.dta_nascimento = dta_nascimento;
        this.contacto = contacto;
    }



    public String getNome() {
        return nome;
    }

    public Integer getAtleta_ID() {
        return atleta_ID;
    }

    public Character getGenero() {
        return genero;
    }

    public String getPaís() {
        return País;
    }

    public Data getDta_nascimento() {
        return dta_nascimento;
    }

    public Long getContacto() {
        return contacto;
    }
}
