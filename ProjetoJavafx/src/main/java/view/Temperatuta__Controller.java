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
import model.Temperatuta__;

public class Temperatuta__Controller {

    @FXML private TextField txtJaneiro;
    @FXML private TextField txtFevereiro;
    @FXML private TextField txtMarco;
    @FXML private TextField txtAbril;
    @FXML private TextField txtMaio;
    @FXML private TextField txtJunho;
    @FXML private TextField txtJulho;
    @FXML private TextField txtAgosto;
    @FXML private TextField txtSetembro;
    @FXML private TextField txtOutubro;
    @FXML private TextField txtNovembro;
    @FXML private TextField txtDezembro;

    @FXML private Label lblJaneiro;
    @FXML private Label lblFevereiro;
    @FXML private Label lblMarco;
    @FXML private Label lblAbril;
    @FXML private Label lblMaio;
    @FXML private Label lblJunho;
    @FXML private Label lblJulho;
    @FXML private Label lblAgosto;
    @FXML private Label lblSetembro;
    @FXML private Label lblOutubro;
    @FXML private Label lblNovembro;
    @FXML private Label lblDezembro;
    @FXML private Label lblResultadoAno;
    @FXML private Button btnVoltar;

    @FXML
    public void calcularTemperatura() {
        TextField[] txtTemperaturas = {
            txtJaneiro, txtFevereiro, txtMarco, txtAbril,
            txtMaio, txtJunho, txtJulho, txtAgosto,
            txtSetembro, txtOutubro, txtNovembro, txtDezembro
        };

        Label[] lblResultados = {
            lblJaneiro, lblFevereiro, lblMarco, lblAbril,
            lblMaio, lblJunho, lblJulho, lblAgosto,
            lblSetembro, lblOutubro, lblNovembro, lblDezembro
        };

        String[] meses = {
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
            "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        };

        int[] temperaturas = new int[12];

        // Confere todos os campos antes de realizar os cálculos.
        for (int i = 0; i < txtTemperaturas.length; i++) {
            try {
                temperaturas[i] = Integer.parseInt(txtTemperaturas[i].getText().trim());
            } catch (NumberFormatException e) {
                mostrarErro("Informe uma temperatura inteira válida para " + meses[i] + ".");
                txtTemperaturas[i].requestFocus();
                return;
            }
        }

        // Um novo objeto inicia a contagem anual do zero a cada cálculo.
        Temperatuta__ temp = new Temperatuta__();

        for (int i = 0; i < temperaturas.length; i++) {
            temp.setTemperatura(temperaturas[i]);
            temp.calculoMes();
            temp.calculoAno();

            if (temp.getVerificador_Mes() == 1) {
                lblResultados[i].setText("Temperatura agradável");
            } else {
                lblResultados[i].setText("Frio");
            }
        }

        if (temp.getVerificador_Ano() > 0) {
            lblResultadoAno.setText("Em geral, a temperatura de São José dos Campos é agradável.");
        } else if (temp.getVerificador_Ano() < 0) {
            lblResultadoAno.setText("Em geral, em São José dos Campos faz frio.");
        } else {
            lblResultadoAno.setText("O ano teve a mesma quantidade de meses frios e agradáveis.");
        }
    }

    private void mostrarErro(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Temperatura inválida");
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
            mostrarErro("Não foi possível voltar ao menu.");
            e.printStackTrace();
        }
    }
}
