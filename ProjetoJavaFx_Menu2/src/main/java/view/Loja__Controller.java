package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Calsa;
import model.Camisa;
import model.Terno;

import java.text.NumberFormat;
import java.util.Locale;

public class Loja__Controller {

    @FXML private ComboBox<String> cmbProduto;
    @FXML private TextField txtCor;
    @FXML private TextField txtTamanho;
    @FXML private TextField txtPreco;
    @FXML private Label lblProduto;
    @FXML private Label lblPrecoOriginal;
    @FXML private Label lblPrecoFinal;
    @FXML private Button btnVoltar;

    private final NumberFormat moeda =
            NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

    @FXML
    public void initialize() {
        cmbProduto.getItems().addAll("Camisa", "Calça", "Terno");
        cmbProduto.setValue("Camisa");
    }

    @FXML
    public void aplicarDesconto() {
        calcular(true);
    }

    @FXML
    public void aumentarPreco() {
        calcular(false);
    }

    private void calcular(boolean desconto) {
        String produto = cmbProduto.getValue();
        String cor = txtCor.getText().trim();
        String tamanho = txtTamanho.getText().trim();

        if (cor.isEmpty() || tamanho.isEmpty()) {
            mostrarErro("Informe a cor e o tamanho do produto.");
            return;
        }

        double preco;

        try {
            String textoPreco = txtPreco.getText().trim()
                    .replace("R$", "")
                    .replace(" ", "")
                    .replace(",", ".");

            preco = Double.parseDouble(textoPreco);
        } catch (NumberFormatException e) {
            mostrarErro("Digite um preço válido. Exemplo: 89,90");
            return;
        }

        if (preco < 0) {
            mostrarErro("O preço não pode ser negativo.");
            return;
        }

        double precoFinal = 0;

        switch (produto) {

            case "Camisa":

                Camisa camisa = new Camisa();

                camisa.setCor(cor);
                camisa.setTamanho(tamanho);
                camisa.setPreco(preco);

                if (desconto) {
                    camisa.aplicarDesconto();
                } else {
                    camisa.aumentarPreco();
                }

                precoFinal = camisa.getPreco();
                break;

            case "Calça":

                Calsa calca = new Calsa();

                try {
                    calca.setTamanho(Integer.parseInt(tamanho));
                } catch (NumberFormatException e) {
                    mostrarErro("O tamanho da calça deve ser um número inteiro. Exemplo: 42");
                    return;
                }

                calca.setCor(cor);
                calca.setPreco(preco);

                if (desconto) {
                    calca.aplicarDesconto();
                } else {
                    calca.aumentarPreco();
                }

                precoFinal = calca.getPreco();
                break;

            case "Terno":

                Terno terno = new Terno();

                terno.setCor(cor);
                terno.setTamanho(tamanho);
                terno.setPreco(preco);

                if (desconto) {
                    terno.aplicarDesconto();
                } else {
                    terno.aumentarPreco();
                }

                precoFinal = terno.getPreco();
                break;
        }

        lblProduto.setText("Produto: " + produto + " - " + cor + ", tamanho " + tamanho);
        lblPrecoOriginal.setText("Preço original: " + moeda.format(preco));

        if (desconto) {
            lblPrecoFinal.setText("Depois do desconto: " + moeda.format(precoFinal));
        } else {
            lblPrecoFinal.setText("Depois do aumento: " + moeda.format(precoFinal));
        }
    }

    private void mostrarErro(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Dados inválidos");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    @FXML
    public void voltarMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Stage stage = (Stage) btnVoltar.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
