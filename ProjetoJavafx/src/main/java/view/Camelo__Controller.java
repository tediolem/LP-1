package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Camelo__;

public class Camelo__Controller {

    @FXML
    private Button btnCalcularCamelo;

    @FXML
    private Button btnVoltar;

    @FXML
    private Label lblPrimeiro;

    @FXML
    private Label lblSegundo;

    @FXML
    private Label lblSobra;

    @FXML
    private Label lblTerceiro;

    @FXML
    private TextField txtCamelo;

    @FXML
    void CalcularCamelo() {

        int Quant_Camelos = Integer.parseInt(txtCamelo.getText());

        IO.println(Quant_Camelos);

        Camelo__ camelo = new Camelo__();

        camelo.setQuant_Camelos(Quant_Camelos);

        camelo.calculoCamelos();
        camelo.calculoIrmaos();

        lblPrimeiro.setText("Primeiro: "+camelo.getPrimeiro()+" camelos");
        lblSegundo.setText("Segundo: "+camelo.getSegundo()+" camelos");
        lblTerceiro.setText("Terceiro: "+camelo.getTerceiro()+" camelos");
        lblSobra.setText("Sobra: "+camelo.getSobra()+" camelos");

    }

    @FXML
    public void voltarMenu(){
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("Menu.fxml")
            );
            Parent root = loader.load();
            Stage stage = (Stage) btnVoltar.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
