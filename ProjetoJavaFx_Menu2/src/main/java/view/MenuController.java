package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {

    @FXML private Button btnLoja;
    @FXML private Button btnTrilha;
    @FXML private Button btnMascara;
    @FXML private Button btnCabelo;
    @FXML private Button btnSair;

    @FXML public void loja() { abrirTela("Loja__.fxml", btnLoja); }
    @FXML public void trilha() { abrirTela("Trilha__.fxml", btnTrilha); }
    @FXML public void mascara() { abrirTela("Mascara__.fxml", btnMascara); }
    @FXML public void cabelo() { abrirTela("Cabelo__.fxml", btnCabelo); }

    @FXML
    private void sair() {
        System.exit(0);
    }

    private void abrirTela(String arquivo, Button botao) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(arquivo));
            Parent root = loader.load();
            Stage stage = (Stage) botao.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
