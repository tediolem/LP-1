package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private Button btnSair;

    @FXML
    private void sair(){
        System.exit(0);
    }

    @FXML
    private Button btnViagem;

    @FXML
    private Button btnAluguel;

    @FXML
    public void aluguel() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("Aluguel__.fxml")
            );
            Parent root = loader.load();
            Stage stage = (Stage) btnAluguel.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void viagem() {
        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("Viagem__.fxml")
            );
            Parent root = loader.load();
            Stage stage = (Stage) btnViagem.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}