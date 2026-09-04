public class Pessoa {

    private String nome;
    private int idade;
    private String estilo;

    public Pessoa(String nome, int idade, String estilo) {
        this.nome = nome;
        this.idade = idade;
        this.estilo = estilo;
    }

    public void escolherEstilo() {
        System.out.println(nome + " escolheu o estilo: " + estilo);
    }

    public void mudarEstilo() {
        estilo = "Novo estilo";
        System.out.println(nome + " mudou o estilo do cabelo.");
    }

    public void exibirDados() {
        System.out.println("===== PESSOA =====");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Estilo: " + estilo);
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}
//UMl{
//┌──────────────────────────────────┐
//│             Pessoa               │
//├──────────────────────────────────┤
//│ - nome: String                   │
//│ - idade: int                     │
//│ - estilo: String                 │
//├──────────────────────────────────┤
//│ + escolherEstilo(): void         │
//│ + mudarEstilo(): void            │
//│ + exibirDados(): void            │
//└──────────────────────────────────┘}