package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Multiplo__;

public class Multiplo__Controller {
    @FXML private TextField txtNumero1;
    @FXML private TextField txtNumero2;
    @FXML private Label lblResultado;
    @FXML private Button btnVoltar;

    @FXML public void verificarMultiplo() {
        try {
            int numero1 = Integer.parseInt(txtNumero1.getText().trim());
            int numero2 = Integer.parseInt(txtNumero2.getText().trim());
            if (numero2 == 0) { mostrarErro("O segundo número não pode ser zero."); return; }
            Multiplo__ multiplo = new Multiplo__();
            multiplo.setNumero1(numero1); multiplo.setNumero2(numero2); multiplo.Verificacao();
            lblResultado.setText(multiplo.getVerificador() == 1 ? numero1 + " é múltiplo de " + numero2 + "." : numero1 + " não é múltiplo de " + numero2 + ".");
        } catch (NumberFormatException e) { mostrarErro("Digite números inteiros nos dois campos."); }
    }
    @FXML public void voltarMenu() { abrirTela("Menu.fxml"); }
    private void mostrarErro(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.ERROR); alerta.setTitle("Dados inválidos"); alerta.setHeaderText(null); alerta.setContentText(mensagem); alerta.showAndWait();
    }
    private void abrirTela(String arquivo) {
        try { Parent root = FXMLLoader.load(getClass().getResource(arquivo)); Stage stage = (Stage) btnVoltar.getScene().getWindow(); stage.setScene(new Scene(root)); }
        catch (Exception e) { e.printStackTrace(); }
    }
}
