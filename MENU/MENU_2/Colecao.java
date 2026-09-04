public class Colecao {

    private String nome;
    private int quantidade;
    private String origem;

    public Colecao(String nome, int quantidade, String origem) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.origem = origem;
    }

    public void adicionarMascara() {
        quantidade++;
        System.out.println("Máscara adicionada à coleção.");
    }

    public void removerMascara() {

        if (quantidade > 0) {
            quantidade--;
            System.out.println("Máscara removida da coleção.");
        } else {
            System.out.println("A coleção está vazia.");
        }
    }

    public void exibirColecao() {
        System.out.println("===== COLEÇÃO =====");
        System.out.println("Nome: " + nome);
        System.out.println("Quantidade de máscaras: " + quantidade);
        System.out.println("Origem: " + origem);
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
}
//UML{
//┌──────────────────────────────────┐
//│             Colecao              │
//├──────────────────────────────────┤
//│ - nome: String                   │
//│ - quantidade: int                │
//│ - origem: String                 │
//├──────────────────────────────────┤
//│ + adicionarMascara(): void       │
//│ + removerMascara(): void         │
//│ + exibirColecao(): void          │
//└──────────────────────────────────┘}