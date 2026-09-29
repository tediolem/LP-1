package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import model.Viagem__;

public class Viagen__Controller {

    @FXML
    private TextField txtDistan;

    @FXML
    private TextField txtComb;

    @FXML
    private Label lblGasto;

    @FXML
    private Label lblDesc;

    @FXML
    private Label lblTotal;

    @FXML
    public void calcular() {
        double distancia = Double.parseDouble(txtDistan.getText());
        double combustivel = Double.parseDouble(txtComb.getText());

        Viagem__ viagem = new Viagem__();

        viagem.setDist(distancia);
        viagem.setPreco(combustivel);
        viagem.setCons();

        viagem.calculoGasto_Comb();
        viagem.calculoDesc();
        viagem.calculoTotal();


        lblGasto.setText("Consumo de combustível: "+viagem.getGasto_Comb());
        lblDesc.setText("Desconto: "+viagem.getDesc());
        lblTotal.setText("Total gasto: "+viagem.getTotal());

        System.out.println("Gasto combustível: " + viagem.getGasto_Comb());
        System.out.println("Desconto: " + viagem.getDesc());
        System.out.println("Total: " + viagem.getTotal());
    }
    @FXML
    public Button btnVoltar;

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
