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

    // CADASTRAR

    @FXML
    public void cadastrar() {

        try {

            String nomePessoa = txtNomePessoa.getText().trim();
            String idadeTexto = txtIdade.getText().trim();
            String estilo = txtEstilo.getText().trim();

            String tipo = txtTipo.getText().trim();
            String corCabelo = txtCorCabelo.getText().trim();
            String comprimentoTexto = txtComprimento.getText().trim();

            String nomeCabeleireiro = txtNomeCabeleireiro.getText().trim();
            String experienciaTexto = txtExperiencia.getText().trim();
            String especialidade = txtEspecialidade.getText().trim();

            // Verificar campos vazios

            if (nomePessoa.isEmpty()
                    || idadeTexto.isEmpty()
                    || estilo.isEmpty()
                    || tipo.isEmpty()
                    || corCabelo.isEmpty()
                    || comprimentoTexto.isEmpty()
                    || nomeCabeleireiro.isEmpty()
                    || experienciaTexto.isEmpty()
                    || especialidade.isEmpty()) {

                mostrarErro("Preencha todos os campos antes de cadastrar.");
                return;
            }

            // Converter os valores numéricos

            int idade = Integer.parseInt(idadeTexto);

            int experiencia = Integer.parseInt(experienciaTexto);

            double comprimento = Double.parseDouble(
                    comprimentoTexto.replace(",", ".")
            );

            // Validar números negativos

            if (idade < 0 || experiencia < 0 || comprimento < 0) {

                mostrarErro(
                        "Idade, experiência e comprimento não podem ser negativos."
                );

                return;
            }

            // Criar os objetos

            pessoa = new Pessoa(
                    nomePessoa,
                    idade,
                    estilo
            );

            cabelo = new Cabelo(
                    tipo,
                    corCabelo,
                    comprimento
            );

            cabeleireiro = new Cabeleireiro(
                    nomeCabeleireiro,
                    experiencia,
                    especialidade
            );

            // Habilitar as ações

            boxAcoes.setDisable(false);

            // Limpar o histórico

            txtLog.clear();

            // Exibir os dados cadastrados

            exibirPessoa();

            exibirCabelo();

            exibirCabeleireiro();

            registrar("Cadastro realizado com sucesso!");

        } catch (NumberFormatException e) {

            mostrarErro(
                    "Verifique os campos numéricos.\n\n"
                            + "Idade e experiência devem ser números inteiros.\n"
                            + "Comprimento deve ser um número válido."
            );

        }
    }

    // VERIFICAR CADASTRO

    private boolean cadastroRealizado() {

        if (pessoa == null || cabelo == null || cabeleireiro == null) {

            mostrarErro(
                    "Realize o cadastro antes de executar esta ação."
            );

            return false;
        }

        return true;
    }

    // PESSOA

    @FXML
    public void exibirPessoa() {

        if (!cadastroRealizado()) {
            return;
        }

        registrar("===== PESSOA =====");

        registrar("Nome: " + pessoa.getNome());

        registrar("Idade: " + pessoa.getIdade());

        registrar("Estilo: " + pessoa.getEstilo());

        registrar("");
    }

    @FXML
    public void escolherEstilo() {

        if (!cadastroRealizado()) {
            return;
        }

        pessoa.escolherEstilo();

        registrar(
                pessoa.getNome()
                        + " escolheu o estilo: "
                        + pessoa.getEstilo()
        );
    }

    @FXML
    public void mudarEstilo() {

        if (!cadastroRealizado()) {
            return;
        }

        pessoa.mudarEstilo();

        registrar(
                pessoa.getNome()
                        + " mudou o estilo do cabelo."
        );

        registrar(
                "Novo estilo: "
                        + pessoa.getEstilo()
        );
    }

    // CABELO

    @FXML
    public void exibirCabelo() {

        if (!cadastroRealizado()) {
            return;
        }

        registrar("===== CABELO =====");

        registrar("Tipo: " + cabelo.getTipo());

        registrar("Cor: " + cabelo.getCor());

        registrar(
                "Comprimento: "
                        + cabelo.getComprimento()
                        + " cm"
        );

        registrar("");
    }

    @FXML
    public void cortar() {

        if (!cadastroRealizado()) {
            return;
        }

        cabelo.cortar();

        registrar("O cabelo foi cortado.");

        registrar(
                "Novo comprimento: "
                        + cabelo.getComprimento()
                        + " cm"
        );
    }

    @FXML
    public void pintar() {

        if (!cadastroRealizado()) {
            return;
        }

        cabelo.pintar();

        registrar("O cabelo foi pintado.");

        registrar(
                "Nova cor: "
                        + cabelo.getCor()
        );
    }

    @FXML
    public void pentear() {

        if (!cadastroRealizado()) {
            return;
        }

        cabelo.pentear();

        registrar("O cabelo foi penteado.");
    }

    // CABELEIREIRO

    @FXML
    public void exibirCabeleireiro() {

        if (!cadastroRealizado()) {
            return;
        }

        registrar("===== CABELEIREIRO =====");

        registrar("Nome: " + cabeleireiro.getNome());

        registrar(
                "Experiência: "
                        + cabeleireiro.getExperiencia()
                        + " anos"
        );

        registrar(
                "Especialidade: "
                        + cabeleireiro.getEspecialidade()
        );

        registrar("");
    }

    @FXML
    public void cortarCabelo() {

        if (!cadastroRealizado()) {
            return;
        }

        cabeleireiro.cortarCabelo();

        registrar(
                cabeleireiro.getNome()
                        + " está cortando o cabelo."
        );
    }

    @FXML
    public void pintarCabelo() {

        if (!cadastroRealizado()) {
            return;
        }

        cabeleireiro.pintarCabelo();

        registrar(
                cabeleireiro.getNome()
                        + " está pintando o cabelo."
        );
    }

    @FXML
    public void fazerPenteado() {

        if (!cadastroRealizado()) {
            return;
        }

        cabeleireiro.fazerPenteado();

        registrar(
                cabeleireiro.getNome()
                        + " está fazendo um penteado."
        );
    }

    // REGISTRAR MENSAGENS

    private void registrar(String mensagem) {

        if (txtLog != null) {
            txtLog.appendText(mensagem + "\n");
        }
    }

    // MOSTRAR ERROS

    private void mostrarErro(String mensagem) {

        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("Dados inválidos");

        alerta.setHeaderText(null);

        alerta.setContentText(mensagem);

        alerta.showAndWait();
    }

    // VOLTAR AO MENU

    @FXML
    public void voltarMenu() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("Menu.fxml")
            );

            Parent root = loader.load();

            Stage stage = (Stage) btnVoltar
                    .getScene()
                    .getWindow();

            stage.setScene(new Scene(root));

            stage.show();

        } catch (Exception e) {

            e.printStackTrace();

            mostrarErro(
                    "Não foi possível abrir o menu.\n"
                            + "Verifique se o arquivo Menu.fxml existe."
            );
        }
    }
}