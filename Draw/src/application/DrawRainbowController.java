package application;


import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class DrawRainbowController {

    @FXML
    private Canvas canvas;
    
    private final Color[] colors = { Color.WHITE, Color.VIOLET, Color.INDIGO, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED
    };
    

    @FXML
    void drawRainbowButtonPressed(ActionEvent event) {

    	GraphicsContext gContext = canvas.getGraphicsContext2D();
    	
    	final int RADIUS = 20;
    	
    	final double centerX = canvas.getWidth() / 2;
    	final double maxY = canvas.getHeight() - 10;
    	
    	for (int counter = colors.length; counter > 0; counter--) {
    		gContext.setFill(colors[counter-1]);
    		  	
        	gContext.fillArc(centerX - counter * RADIUS, maxY - counter*RADIUS, counter*RADIUS*2, counter*RADIUS*2,
        			0, 180, ArcType.OPEN) ;       			
    	}
    	
    	
    }

    
}
