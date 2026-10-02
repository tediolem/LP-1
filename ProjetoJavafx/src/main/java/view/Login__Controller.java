package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import model.Login__;

public class Login__Controller {

    @FXML
    private Button btnEntrar;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtUsuario;

    @FXML
    public void entrar() {

        String senhaDigitada = txtSenha.getText();

        Login__ login = new Login__();

        login.setSenha(senhaDigitada);
        login.setSenha_Correta();

        login.verificacaoSenha();

        IO.println(login.getVerificador());

        if (login.getVerificador() != 0) {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("Menu.fxml")
                );
                Parent root = loader.load();
                Stage stage = (Stage) btnEntrar.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
