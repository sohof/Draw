package application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;


public class ColorChooser extends Application {

	@Override
	public void start (Stage stage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("view/ColorChooser.fxml"));
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Color Chooser");
		stage.show();
	}

	
	public static void main(String [] args) {
		
		launch(args);
	}
}
