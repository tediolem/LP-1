package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button btnSair;

    @FXML
    private void sair(){
        System.exit(0);
    }

}