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
import model.Cabeleireiro;
import model.Cabelo;
import model.Pessoa;

public class Cabelo__Controller {

    @FXML private TextField txtNomePessoa;
    @FXML private TextField txtIdade;
    @FXML private TextField txtEstilo;
    @FXML private TextField txtTipo;
    @FXML private TextField txtCorCabelo;
    @FXML private TextField txtComprimento;
    @FXML private TextField txtNomeCabeleireiro;
    @FXML private TextField txtExperiencia;
    @FXML private TextField txtEspecialidade;
    @FXML private TextArea txtLog;
    @FXML private VBox boxAcoes;
    @FXML private Button btnVoltar;

    private Pessoa pessoa;
    private Cabelo cabelo;
    private Cabeleireiro cabeleireiro;

    @FXML
    public void cadastrar() {
        try {
            String nomePessoa = txtNomePessoa.getText().trim();
            int idade = Integer.parseInt(txtIdade.getText().trim());
            String estilo = txtEstilo.getText().trim();

            String tipo = txtTipo.getText().trim();
            String corCabelo = txtCorCabelo.getText().trim();
            double comprimento = Double.parseDouble(txtComprimento.getText().trim().replace(",", "."));

            String nomeCabeleireiro = txtNomeCabeleireiro.getText().trim();
            int experiencia = Integer.parseInt(txtExperiencia.getText().trim());
            String especialidade = txtEspecialidade.getText().trim();

            if (nomePessoa.isEmpty() || estilo.isEmpty() || tipo.isEmpty()
                    || corCabelo.isEmpty() || nomeCabeleireiro.isEmpty()
                    || especialidade.isEmpty()) {
                mostrarErro("Preencha todos os campos de texto.");
                return;
            }

            if (idade < 0 || experiencia < 0 || comprimento < 0) {
                mostrarErro("Idade, experiência e comprimento não podem ser negativos.");
                return;
            }

            pessoa = new Pessoa(nomePessoa, idade, estilo);
            cabelo = new Cabelo(tipo, corCabelo, comprimento);
            cabeleireiro = new Cabeleireiro(nomeCabeleireiro, experiencia, especialidade);

            boxAcoes.setDisable(false);
            txtLog.clear();

            exibirPessoa();
            exibirCabelo();
            exibirCabeleireiro();

        } catch (NumberFormatException e) {
            mostrarErro("Idade e experiência devem ser números inteiros; comprimento deve ser um número.");
        }
    }

    // PESSOA

    @FXML
    public void exibirPessoa() {
        registrar("===== PESSOA =====");
        registrar("Nome: " + pessoa.getNome());
        registrar("Idade: " + pessoa.getIdade());
        registrar("Estilo: " + pessoa.getEstilo());
    }

    @FXML
    public void escolherEstilo() {
        pessoa.escolherEstilo();
        registrar(pessoa.getNome() + " escolheu o estilo: " + pessoa.getEstilo());
    }

    @FXML
    public void mudarEstilo() {
        pessoa.mudarEstilo();
        registrar(pessoa.getNome() + " mudou o estilo do cabelo.");
        registrar("Novo estilo: " + pessoa.getEstilo());
    }

    // CABELO

    @FXML
    public void exibirCabelo() {
        registrar("===== CABELO =====");
        registrar("Tipo: " + cabelo.getTipo());
        registrar("Cor: " + cabelo.getCor());
        registrar("Comprimento: " + cabelo.getComprimento() + " cm");
    }

    @FXML
    public void cortar() {
        cabelo.cortar();
        registrar("O cabelo foi cortado.");
        registrar("Novo comprimento: " + cabelo.getComprimento() + " cm");
    }

    @FXML
    public void pintar() {
        cabelo.pintar();
        registrar("O cabelo foi pintado.");
        registrar("Nova cor: " + cabelo.getCor());
    }

    @FXML
    public void pentear() {
        cabelo.pentear();
        registrar("O cabelo foi penteado.");
    }

    // CABELEIREIRO

    @FXML
    public void exibirCabeleireiro() {
        registrar("===== CABELEIREIRO =====");
        registrar("Nome: " + cabeleireiro.getNome());
        registrar("Experiência: " + cabeleireiro.getExperiencia() + " anos");
        registrar("Especialidade: " + cabeleireiro.getEspecialidade());
    }

    @FXML
    public void cortarCabelo() {
        cabeleireiro.cortarCabelo();
        registrar(cabeleireiro.getNome() + " está cortando o cabelo.");
    }

    @FXML
    public void pintarCabelo() {
        cabeleireiro.pintarCabelo();
        registrar(cabeleireiro.getNome() + " está pintando o cabelo.");
    }

    @FXML
    public void fazerPenteado() {
        cabeleireiro.fazerPenteado();
        registrar(cabeleireiro.getNome() + " está fazendo um penteado.");
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
