public class Mascara {

    private String material;
    private String cor;
    private String tamanho;

    public Mascara(String material, String cor, String tamanho) {
        this.material = material;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public void pintar() {
        System.out.println("A máscara está sendo pintada.");
        cor = "Colorida";
    }

    public void exibirMascara() {
        System.out.println("===== MÁSCARA =====");
        System.out.println("Material: " + material);
        System.out.println("Cor: " + cor);
        System.out.println("Tamanho: " + tamanho);
    }

    public void restaurar() {
        System.out.println("A máscara está sendo restaurada.");
    }

    // Getters e Setters

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
//UML{
//┌───────dddddd───────────────────────────┐
//│             Mascara              │
//├──────────────────────────────────┤
//│ - material: String               │
//│ - cor: String                    │
//│ - tamanho: String                │
//├──────────────────────────────────┤
//│ + pintar(): void                 │
//│ + exibirMascara(): void          │
//│ + restaurar(): void              │
//└──────────────────────────────────┘}

