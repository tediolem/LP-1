public class Ciclista {

    private String nome;
    private int idade;
    private double velocidade;

    public Ciclista(String nome, int idade, double velocidade) {
        this.nome = nome;
        this.idade = idade;
        this.velocidade = velocidade;
    }

    public void pedalar() {
        System.out.println(nome + " está pedalando.");
    }

    public void frear() {
        velocidade -= 5;

        if (velocidade < 0) {
            velocidade = 0;
        }

        System.out.println(nome + " freou. Velocidade: "
                + velocidade + " km/h");
    }

    public void aumentarVelocidade() {
        velocidade += 5;
        System.out.println(nome + " aumentou a velocidade para "
                + velocidade + " km/h.");
    }

    // Métodos de acesso
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

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
}
//UML{
//┌─────────────────────────────────┐
//│           Ciclista              │
//├─────────────────────────────────┤
//│ - nome: String                  │
//│ - idade: int                    │
//│ - velocidade: double            │
//├─────────────────────────────────┤
//│ + pedalar(): void               │
//│ + frear(): void                 │
//│ + aumentarVelocidade(): void    │
//└─────────────────────────────────┘}

