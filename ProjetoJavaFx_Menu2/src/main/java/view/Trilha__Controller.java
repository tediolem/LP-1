package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Bicicleta;
import model.Ciclista;
import model.Trilha;

public class Trilha__Controller {

    @FXML private TextField txtNomeCiclista;
    @FXML private TextField txtIdade;
    @FXML private TextField txtVelocidade;
    @FXML private TextField txtMarca;
    @FXML private TextField txtAro;
    @FXML private TextField txtNomeTrilha;
    @FXML private TextField txtDistancia;
    @FXML private TextField txtDificuldade;
    @FXML private TextField txtMarcha;
    @FXML private TextArea txtLog;
    @FXML private VBox boxAcoes;
    @FXML private Button btnVoltar;

    private Ciclista ciclista;
    private Bicicleta bicicleta;
    private Trilha trilha;

    @FXML
    public void cadastrar() {
        try {
            String nome = txtNomeCiclista.getText().trim();
            int idade = Integer.parseInt(txtIdade.getText().trim());
            double velocidade = Double.parseDouble(txtVelocidade.getText().trim().replace(",", "."));

            String marca = txtMarca.getText().trim();
            int aro = Integer.parseInt(txtAro.getText().trim());

            String nomeTrilha = txtNomeTrilha.getText().trim();
            double distancia = Double.parseDouble(txtDistancia.getText().trim().replace(",", "."));
            String dificuldade = txtDificuldade.getText().trim();

            if (nome.isEmpty() || marca.isEmpty() || nomeTrilha.isEmpty() || dificuldade.isEmpty()) {
                mostrarErro("Preencha todos os campos de texto.");
                return;
            }

            // A velocidade inicial informada vale para o ciclista e para a bicicleta
            ciclista = new Ciclista(nome, idade, velocidade);
            bicicleta = new Bicicleta(marca, aro, velocidade);
            trilha = new Trilha(nomeTrilha, distancia, dificuldade);

            boxAcoes.setDisable(false);
            txtLog.clear();
            exibirInformacoes();

        } catch (NumberFormatException e) {
            mostrarErro("Idade e aro devem ser números inteiros; velocidade e distância devem ser números.");
        }
    }

    @FXML
    public void pedalar() {
        ciclista.pedalar();
        registrar(ciclista.getNome() + " está pedalando.");
    }

    @FXML
    public void aumentarVelocidade() {
        ciclista.aumentarVelocidade();
        registrar(ciclista.getNome() + " aumentou a velocidade para "
                + ciclista.getVelocidade() + " km/h.");
    }

    @FXML
    public void frearCiclista() {
        ciclista.frear();
        registrar(ciclista.getNome() + " freou. Velocidade: "
                + ciclista.getVelocidade() + " km/h");
    }

    @FXML
    public void acelerar() {
        bicicleta.acelerar();
        registrar("A bicicleta " + bicicleta.getMarca()
                + " acelerou para " + bicicleta.getVelocidade() + " km/h.");
    }

    @FXML
    public void frearBicicleta() {
        bicicleta.frear();
        registrar("A bicicleta " + bicicleta.getMarca()
                + " freou. Velocidade: " + bicicleta.getVelocidade() + " km/h.");
    }

    @FXML
    public void trocarMarcha() {
        try {
            int marcha = Integer.parseInt(txtMarcha.getText().trim());

            bicicleta.trocarMarcha(marcha);
            registrar("A bicicleta " + bicicleta.getMarca()
                    + " mudou para a marcha " + marcha + ".");
        } catch (NumberFormatException e) {
            mostrarErro("Digite a marcha como número inteiro.");
        }
    }

    @FXML
    public void iniciarPercurso() {
        trilha.iniciarPercurso();
        registrar("Percurso iniciado na trilha " + trilha.getNome() + ".");
    }

    @FXML
    public void finalizarPercurso() {
        trilha.finalizarPercurso();
        registrar("Percurso finalizado na trilha " + trilha.getNome() + ".");
    }

    @FXML
    public void exibirInformacoes() {
        registrar("===== INFORMAÇÕES =====");
        registrar("Ciclista: " + ciclista.getNome());
        registrar("Idade: " + ciclista.getIdade());
        registrar("Velocidade: " + ciclista.getVelocidade() + " km/h");
        registrar("Bicicleta: " + bicicleta.getMarca());
        registrar("Aro: " + bicicleta.getAro());
        registrar("Trilha: " + trilha.getNome());
        registrar("Distância: " + trilha.getDistancia() + " km");
        registrar("Dificuldade: " + trilha.getDificuldade());
    }

    private void registrar(String mensagem) {
        txtLog.appendText(mensagem + "\n");
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
