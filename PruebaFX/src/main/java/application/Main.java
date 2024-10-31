package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
	  try {
		
	  FXMLLoader loader = new FXMLLoader();
	  loader.setLocation(Main.class.getResource("/views/VentanaPrincipal.fxml"));
	  
      Pane ventana = (Pane) loader.load();
      
      Scene escena = new Scene(ventana);
//      escena.getStylesheets().add(STYLESHEET_CASPIAN)
      primaryStage.setScene(escena);
      primaryStage.show();
      
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
	  
	  
	  
	}

	public static void main(String[] args) {
		launch(args);
	}
}
