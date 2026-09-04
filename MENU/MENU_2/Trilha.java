public class Trilha {

    private String nome;
    private double distancia;
    private String dificuldade;

    public Trilha(String nome, double distancia, String dificuldade) {
        this.nome = nome;
        this.distancia = distancia;
        this.dificuldade = dificuldade;
    }

    public void iniciarPercurso() {
        System.out.println("Percurso iniciado na trilha " + nome + ".");
    }

    public void finalizarPercurso() {
        System.out.println("Percurso finalizado na trilha " + nome + ".");
    }

    public void exibirInformacoes() {
        System.out.println("Trilha: " + nome);
        System.out.println("Distância: " + distancia + " km");
        System.out.println("Dificuldade: " + dificuldade);
    }

    // Métodos de acesso
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}

//UML{
//┌─────────────────────────────────┐
//│            Trilha               │
//├─────────────────────────────────┤
//│ - nome: String                  │
//│ - distancia: double             │
//│ - dificuldade: String           │
//├─────────────────────────────────┤
//│ + iniciarPercurso(): void       │
//│ + finalizarPercurso(): void     │
//│ + exibirInformacoes(): void     │
//└─────────────────────────────────┘}