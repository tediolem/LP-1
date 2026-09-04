public class Cabeleireiro {

    private String nome;
    private int experiencia;
    private String especialidade;

    public Cabeleireiro(String nome, int experiencia, String especialidade) {
        this.nome = nome;
        this.experiencia = experiencia;
        this.especialidade = especialidade;
    }

    public void cortarCabelo() {
        System.out.println(nome + " está cortando o cabelo.");
    }

    public void pintarCabelo() {
        System.out.println(nome + " está pintando o cabelo.");
    }

    public void fazerPenteado() {
        System.out.println(nome + " está fazendo um penteado.");
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}

//UML{
//┌──────────────────────────────────┐
//│          Cabeleireiro            │
//├──────────────────────────────────┤
//│ - nome: String                   │
//│ - experiencia: int               │
//│ - especialidade: String          │
//├──────────────────────────────────┤
//│ + cortarCabelo(): void           │
//│ + pintarCabelo(): void           │
//│ + fazerPenteado(): void          │
//└──────────────────────────────────┘}
