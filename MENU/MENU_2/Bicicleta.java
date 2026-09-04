public class Bicicleta {

    private String marca;
    private int aro;
    private double velocidade;

    public Bicicleta(String marca, int aro, double velocidade) {
        this.marca = marca;
        this.aro = aro;
        this.velocidade = velocidade;
    }

    public void acelerar() {
        velocidade += 5;
        System.out.println("A bicicleta " + marca
                + " acelerou para " + velocidade + " km/h.");
    }

    public void frear() {
        velocidade -= 5;

        if (velocidade < 0) {
            velocidade = 0;
        }

        System.out.println("A bicicleta " + marca
                + " freou. Velocidade: " + velocidade + " km/h.");
    }

    public void trocarMarcha(int marcha) {
        System.out.println("A bicicleta " + marca
                + " mudou para a marcha " + marcha + ".");
    }

    // Métodos de acesso
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAro() {
        return aro;
    }

    public void setAro(int aro) {
        this.aro = aro;
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
//│          Bicicleta              │
//├─────────────────────────────────┤
//│ - marca: String                 │
//│ - aro: int                      │
//│ - velocidade: double            │
//├─────────────────────────────────┤
//│ + acelerar(): void              │
//│ + frear(): void                 │
//│ + trocarMarcha(marcha: int):void│
//└─────────────────────────────────┘}