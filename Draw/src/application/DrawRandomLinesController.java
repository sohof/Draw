package application;

import java.security.SecureRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class DrawRandomLinesController {
	/* names must match the fx:id specified, this variable was not initialized. When 
	 * DrawLines executes it initializes the canvas variable with the canvas object from Drawlines.fxml.
	 * The @FXML annotation indicates that the variable name can be used in the GUI's FXML
	 * file. Or that the method can be used in the FXML file to specify a control's event handler  */
	
	private static final SecureRandom randomNumbers = new SecureRandom();
	
    @FXML
    private Canvas canvas;

    @FXML
    void drawLinesButtonPressed(ActionEvent event)  {

    	GraphicsContext gContext = canvas.getGraphicsContext2D();

    	ArrayList<MyLine> lines = new ArrayList<>();
    	
    	final int width = (int) canvas.getWidth();
    	final int height = (int) canvas.getHeight();
    	
    	for (int i=0; i < 100; ++i) {
    		
    		double x1 = randomNumbers.nextInt(width);
    		double y1 = randomNumbers.nextInt(height);
    		double x2 = randomNumbers.nextInt(width);
    		double y2 = randomNumbers.nextInt(height);
    		Color color = Color.rgb(randomNumbers.nextInt(256), randomNumbers.nextInt(256), randomNumbers.nextInt(256));
    		lines.add(new MyLine(x1,y1,x2,y2,color));
    	}
    	gContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    	
    	for(MyLine line : lines)
    		line.draw(gContext);
    	
    }
    

    @FXML
    void drawSmileyButtonPressed(ActionEvent event) {
    	
    	
    	GraphicsContext gContext = canvas.getGraphicsContext2D();
    	gContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
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
