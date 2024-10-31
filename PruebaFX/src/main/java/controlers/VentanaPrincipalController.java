package controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VentanaPrincipalController {

    @FXML
    private Button btnPulsaAqui;

    @FXML
    private Label texto;

    @FXML
    void btnPressed(ActionEvent event) {
      texto.setText(null);
    }

}
