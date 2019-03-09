package application;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PainterController {

	private enum PenSize{
		SMALL(2),
		MEDIUM(4),
		Large(6);
		
		private final int radius;
		PenSize(int rad) {radius = rad;} // enum constructor
		
		public int getRadius() {return radius;}
	}
	
	@FXML	private Pane drawingAreaPane;
	@FXML	private RadioButton blackRadioButton;
    @FXML	private ToggleGroup colorToggleGroup;
    @FXML	private RadioButton redRadioButton;
    @FXML	private RadioButton greenRadioButton;
    @FXML	private RadioButton blueRadioButton;
    @FXML	private RadioButton smallRadioButton;
    @FXML   private ToggleGroup sizeToggleGroup;
    @FXML   private RadioButton mediumRadioButton;
    @FXML   private RadioButton largeRadioButton;
    @FXML   private Button undoButton;
    @FXML   private Button clearButton;

    
    // instance variables for managaing Painter state
    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;
    
    // Called by FXMLLoader to initialize controller
    public void initialize() {
    	// each javafx control has setUserData method that receives an Object. Any object can be stored
    	// and associated with that control. These object can then be used when handling events
    	blackRadioButton.setUserData(Color.BLACK);
    	redRadioButton.setUserData(Color.RED);
    	greenRadioButton.setUserData(Color.GREEN);
    	blueRadioButton.setUserData(Color.BLUE);
    	smallRadioButton.setUserData(PenSize.SMALL);
    	mediumRadioButton.setUserData(PenSize.MEDIUM);
    	largeRadioButton.setUserData(PenSize.Large);
    }

    
    // Class RadioButton is one of several controls that implement interface Toggle.
    // we use the toggle's getUserData to get the user data object that was associated with the corresponding
    // RadioButton in method Initialize. 
    // handles color RadioButton's ActionEvents
    @FXML
    void colorRadioButtonSelected(ActionEvent event) {
    	//user data for each color RadioButton is the corresponding Color
    	brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
    }
    
    // handles size RadioButton's ActionEvents
    @FXML
    void sizeRadioButtonSelected(ActionEvent event) {
       	//user data for each size RadioButton is the corresponding PenSize
    	radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }

    // handles drawingArea's onMouseDragged MouseEvent
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	
    	Circle newCircle = new Circle(event.getX(), event.getY(), radius.getRadius(), brushColor);
    	drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void undoButtonPressed(ActionEvent event) {
    	int count = drawingAreaPane.getChildren().size();
    	
    	// if there are any shapes remove the last one
    	if (count > 0) drawingAreaPane.getChildren().remove(count-1);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
}
