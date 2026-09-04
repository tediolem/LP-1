public class Calsa {

    private String cor;
    private int tamanho;
    private double preco;

    public void exibirDados() {
        System.out.println("=== CALÇA ===");
        System.out.println("Cor: " + cor);
        System.out.println("Tamanho: " + tamanho);
        System.out.println("Preço: R$ " + preco);
    }

    public void aplicarDesconto() {
        preco = preco - (preco * 0.10);
    }

    public void aumentarPreco() {
        preco = preco + (preco * 0.05);
    }

    public void setCor(String c) {
        cor = c;
    }

    public void setTamanho(int t) {
        tamanho = t;
    }

    public void setPreco(double p) {
        preco = p;
    }
}