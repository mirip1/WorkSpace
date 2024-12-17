package controlers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class VentanaPrincipalController {

    @FXML
    private Button btnPulsaAqui;

    @FXML
    private Label texto;
    
    @FXML
    private ImageView ojete;

    private String valorTexto;

    @FXML
    public void initialize() {
        texto.setText("ADIOS gilipollas");;

        valorTexto = texto.getText();
    }
    
    @FXML
    void imageClicked(MouseEvent event) {
        System.out.println("Imagen clicada");
    }

    @FXML
    void btnPressed(ActionEvent event) {
        if (!isOcultado()) {
            valorTexto = texto.getText(); // Guarda el valor actual del texto
            texto.setText(ocultar());
        } else {
            texto.setText(valorTexto);
        }
    }

    private String ocultar() {
        int numCaracteres = valorTexto.length();
        String resultado = "";

        for (int i = 0; i < numCaracteres; i++) {
            resultado += "*";
        }

        return resultado;
    }

    private boolean isOcultado() {
        // Comprueba el texto del Label, no su representación como objeto
        return texto.getText().matches("[*]+");
    }
}

