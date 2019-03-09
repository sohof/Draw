package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

public class TipCalculator extends Application {

	
	@Override
	public void start(Stage stage) throws Exception{
//start method creates the GUI and attaches it to a scene and places it on the stage that method starts receives as argument. 
		Parent root = FXMLLoader.load(getClass().getResource("view/TipCalculator.fxml"));
	
		/* 
		 * The load method creates the GUIs scene graph containing layout and controls and returns a parent reference
		 * to the scene graph's root node. Which in this case is a reference to the GUIs GridPane.
		 * 
		 * Creates an object of the TipCalculatorController class that was specified in the FXML file.
		 * 
		 * Initializes controller's instance variables for the components that are manipulated programmatically
		 * 
		 * Attaches event handlers specified in the FXML to the appropriate controls. This is known as registering the
		 * event handlers and enables the controls to call the corresponding methods when the user interacts with the app
		 * 		
		 */
		Scene scene = new Scene(root); // to display GUI we must attach it to a scene.
		// by default scene size is determined by scene graphs root node. Overloaded versions of scene constructor allow us to 
		// specify scene size and fill ( a gradient,color, image) which appears in the background.
		stage.setTitle("TipCalculator");
		stage.setScene(scene); // then attach the scene to a stage that start received as argument
		stage.show();
	}
	
	
	public static void main(String [] args) {
		
		// main calls class Application's static launch method
		// launch method causes JavaFx runtime to create object of tip calculator, which is a subclass of the application
		// class and calls its start method, passing in the Stage object representing the window in which the app will be
		//displayed. JavaFX runtime creates the window.
		
		launch(args);
	}
}
