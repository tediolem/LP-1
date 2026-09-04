public class Terno {

    private String cor;
    private String tamanho;
    private double preco;

    public void exibirDados() {
        System.out.println("=== TERNO ===");
        System.out.println("Cor: " + cor);
        System.out.println("Tamanho: " + tamanho);
        System.out.println("Preço: R$ " + preco);
    }

    public void aplicarDesconto() {
        preco = preco - (preco * 0.15);
    }

    public void aumentarPreco() {
        preco = preco + (preco * 0.5);
    }

    public void setCor(String c) {
        cor = c;
    }

    public void setTamanho(String t) {
        tamanho = t;
    }

    public void setPreco(double p) {
        preco = p;
    }
}