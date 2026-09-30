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
import model.Aluguel__;


public class Aluguel__Controller {

    @FXML
    private TextField txtDia;

    @FXML
    private TextField txtKm;

    @FXML
    private Label lblAdicional;

    @FXML
    private Label lblTotal;

    @FXML
    private Button btnCalcularAluguel;

    @FXML
    void CalcularAluguel() {

        int dia = Integer.parseInt(txtDia.getText());
        double km = Double.parseDouble(txtKm.getText());

        Aluguel__ aluguel = new Aluguel__();

        aluguel.setDias(dia);
        aluguel.setKm_rodado(km);
        aluguel.setAluguel_Carro();
        aluguel.setPreco_Km();
        aluguel.setKm_MaxD();

        aluguel.calculoKm();
        aluguel.calculoTotal();

        IO.println(aluguel.getTotal());

        lblAdicional.setText("Adicional: "+aluguel.getAdicional());
        lblTotal.setText("Total: "+aluguel.getTotal());

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
