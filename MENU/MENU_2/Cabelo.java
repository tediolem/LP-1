public class Cabelo {

    private String tipo;
    private String cor;
    private double comprimento;

    public Cabelo(String tipo, String cor, double comprimento) {
        this.tipo = tipo;
        this.cor = cor;
        this.comprimento = comprimento;
    }

    public void cortar() {
        if (comprimento > 2) {
            comprimento -= 2;
        }

        System.out.println("O cabelo foi cortado.");
        System.out.println("Novo comprimento: " + comprimento + " cm");
    }

    public void pintar() {
        cor = "Colorido";
        System.out.println("O cabelo foi pintado.");
    }

    public void pentear() {
        System.out.println("O cabelo foi penteado.");
    }

    // Getters e Setters

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }
}
//UML{
//┌──────────────────────────────────┐
//│             Cabelo               │
//├──────────────────────────────────┤
//│ - tipo: String                   │
//│ - cor: String                    │
//│ - comprimento: double            │
//├──────────────────────────────────┤
//│ + cortar(): void                 │
//│ + pintar(): void                 │
//│ + pentear(): void                │
//└──────────────────────────────────┘}