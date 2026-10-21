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
import model.Artesao;
import model.Colecao;
import model.Mascara;

public class Mascara__Controller {

    @FXML private TextField txtMaterial;
    @FXML private TextField txtCor;
    @FXML private TextField txtTamanho;
    @FXML private TextField txtNomeArtesao;
    @FXML private TextField txtEspecialidade;
    @FXML private TextField txtExperiencia;
    @FXML private TextField txtNomeColecao;
    @FXML private TextField txtQuantidade;
    @FXML private TextField txtOrigem;
    @FXML private TextArea txtLog;
    @FXML private VBox boxAcoes;
    @FXML private Button btnVoltar;

    private Mascara mascara;
    private Artesao artesao;
    private Colecao colecao;

    @FXML
    public void cadastrar() {
        try {
            String material = txtMaterial.getText().trim();
            String cor = txtCor.getText().trim();
            String tamanho = txtTamanho.getText().trim();

            String nomeArtesao = txtNomeArtesao.getText().trim();
            String especialidade = txtEspecialidade.getText().trim();
            int experiencia = Integer.parseInt(txtExperiencia.getText().trim());

            String nomeColecao = txtNomeColecao.getText().trim();
            int quantidade = Integer.parseInt(txtQuantidade.getText().trim());
            String origem = txtOrigem.getText().trim();

            if (material.isEmpty() || cor.isEmpty() || tamanho.isEmpty()
                    || nomeArtesao.isEmpty() || especialidade.isEmpty()
                    || nomeColecao.isEmpty() || origem.isEmpty()) {
                mostrarErro("Preencha todos os campos de texto.");
                return;
            }

            if (experiencia < 0 || quantidade < 0) {
                mostrarErro("Experiência e quantidade não podem ser negativas.");
                return;
            }

            mascara = new Mascara(material, cor, tamanho);
            artesao = new Artesao(nomeArtesao, especialidade, experiencia);
            colecao = new Colecao(nomeColecao, quantidade, origem);

            boxAcoes.setDisable(false);
            txtLog.clear();

            exibirArtesao();
            exibirMascara();
            exibirColecao();

        } catch (NumberFormatException e) {
            mostrarErro("Experiência e quantidade devem ser números inteiros.");
        }
    }

    // ARTESÃO

    @FXML
    public void exibirArtesao() {
        registrar("===== ARTESÃO =====");
        registrar("Nome: " + artesao.getNome());
        registrar("Especialidade: " + artesao.getEspecialidade());
        registrar("Experiência: " + artesao.getExperiencia() + " anos");
    }

    @FXML
    public void fabricarMascara() {
        artesao.fabricarMascara();
        registrar(artesao.getNome() + " está fabricando uma máscara.");
    }

    @FXML
    public void pintarMascara() {
        artesao.pintarMascara();
        registrar(artesao.getNome() + " está pintando uma máscara.");
    }

    // MÁSCARA

    @FXML
    public void exibirMascara() {
        registrar("===== MÁSCARA =====");
        registrar("Material: " + mascara.getMaterial());
        registrar("Cor: " + mascara.getCor());
        registrar("Tamanho: " + mascara.getTamanho());
    }

    @FXML
    public void pintar() {
        mascara.pintar();
        registrar("A máscara está sendo pintada.");
        registrar("Nova cor: " + mascara.getCor());
    }

    @FXML
    public void restaurar() {
        mascara.restaurar();
        registrar("A máscara está sendo restaurada.");
    }

    // COLEÇÃO

    @FXML
    public void exibirColecao() {
        registrar("===== COLEÇÃO =====");
        registrar("Nome: " + colecao.getNome());
        registrar("Quantidade de máscaras: " + colecao.getQuantidade());
        registrar("Origem: " + colecao.getOrigem());
    }

    @FXML
    public void adicionarMascara() {
        colecao.adicionarMascara();
        registrar("Máscara adicionada à coleção.");
        registrar("Quantidade de máscaras: " + colecao.getQuantidade());
    }

    @FXML
    public void removerMascara() {
        boolean vazia = colecao.getQuantidade() == 0;

        colecao.removerMascara();

        if (vazia) {
            registrar("A coleção está vazia.");
        } else {
            registrar("Máscara removida da coleção.");
            registrar("Quantidade de máscaras: " + colecao.getQuantidade());
        }
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
