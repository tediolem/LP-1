public class Artesao {

    private String nome;
    private String especialidade;
    private int experiencia;

    public Artesao(String nome, String especialidade, int experiencia) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.experiencia = experiencia;
    }

    public void fabricarMascara() {
        System.out.println(nome + " está fabricando uma máscara.");
    }

    public void pintarMascara() {
        System.out.println(nome + " está pintando uma máscara.");
    }

    public void exibirDados() {
        System.out.println("===== ARTESÃO =====");
        System.out.println("Nome: " + nome);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Experiência: " + experiencia + " anos");
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
}
//UML{
//┌──────────────────────────────────┐
//│             Artesao              │
//├──────────────────────────────────┤
//│ - nome: String                   │
//│ - especialidade: String          │
//│ - experiencia: int               │
//├──────────────────────────────────┤
//│ + fabricarMascara(): void        │
//│ + pintarMascara(): void          │
//│ + exibirDados(): void            │
//└──────────────────────────────────┘}