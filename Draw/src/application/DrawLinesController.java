package application;

import java.security.SecureRandom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class DrawLinesController {

	/* names must match the fx:id specified, this variable was not initialized. When 
	 * DrawLines executes it initializes the canvas variable with the canvas object from Drawlines.fxml.
	 * The @FXML annotation indicates that the variable name can be used in the GUI's FXML
	 * file. Or that the method can be used in the FXML file to specify a control's event handler  */
    @FXML
    private Canvas canvas;

    @FXML
    void drawLinesButtonPressed(ActionEvent event)  {

    	GraphicsContext gContext = canvas.getGraphicsContext2D();
    	
    	gContext.strokeLine(getR(),getR(), canvas.getWidth(), canvas.getHeight());
    	
    	gContext.strokeLine(canvas.getWidth(), 0, 0, canvas.getHeight());
    	
    }
    

    @FXML
    void drawSmileyButtonPressed(ActionEvent event) {
    	
    	
    	GraphicsContext gContext = canvas.getGraphicsContext2D();
    	
    	//Draw the face
    	gContext.setFill(Color.YELLOW);
    	gContext.fillOval(10, 10, 280, 280);
    	gContext.strokeOval(10, 10, 280, 280);

    	//draw the eyes
    	gContext.setFill(Color.rgb(getR(),getR(),getR()));
    	gContext.fillOval(75, 85, 40, 40);
    	gContext.fillOval(185, 85, 40, 40);    	
    	
    	//draw mouth
    	gContext.setFill(Color.rgb(getR(),getR(),getR()));
    	gContext.fillOval(50, 130, 200, 120);
    	
    	gContext.setFill(Color.YELLOW);
    	gContext.fillRect(50, 130, 200, 90);
    	
    }
    	
    
    private int getR() {
    	
    	int rand = 0;
    	SecureRandom random = new SecureRandom();
    	
    	rand = random.nextInt(255);
    	return rand;
    	
    }
    

}
