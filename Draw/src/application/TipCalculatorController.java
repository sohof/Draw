package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import java.math.BigDecimal;
import java.math.RoundingMode; // used to specify how bigdecimal vales are rounded 
import java.text.NumberFormat;
import java.util.Locale;

//implement changelistener interface to respond to user when the user moves slider
//This interface's "changed" method received an object that implements the interface observable value
// that is a value that generates an event with it changes.
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue; 


public class TipCalculatorController {
	
	// formatters for currency and percentages
	private static final NumberFormat currency = NumberFormat.getInstance(new Locale("sv-SE"));
	private static final NumberFormat percent = NumberFormat.getPercentInstance();
	
	private BigDecimal tipPercentage = new BigDecimal(0.15); // 15 % default value
	
	// GUI controls defined in FXML and used by controllers code
	
    @FXML // fx:id="tipPercentageSlider"
    private Slider tipPercentageSlider; // Value injected by FXMLLoader

    @FXML // fx:id="amountTextField"
    private TextField amountTextField; // Value injected by FXMLLoader

    @FXML // fx:id="tipTextField"
    private TextField tipTextField; // Value injected by FXMLLoader

    @FXML // fx:id="totalTextField"
    private TextField totalTextField; // Value injected by FXMLLoader

    @FXML // fx:id="tipPercentageLabel"
    private Label tipPercentageLabel; // Value injected by FXMLLoader

    
    // The @FXML annotation indicates that the variable name can be used in the GUI's FXML
    // file. Or that the method can be used in the FXML file to specify a control's event handler 
   // For a control that generates an action event (as is the case for many javafx controls)
    // the event handling method must return void and receive an ActionEvent paramater.
    @FXML
    private void calculateButtonPressed(ActionEvent event) {
   
    	try {
    		
    		BigDecimal amount = new BigDecimal(amountTextField.getText());
    		BigDecimal tip = amount.multiply(tipPercentage);
    		BigDecimal total = amount.add(tip);
    		
    		tipTextField.setText(currency.format(tip));
    		totalTextField.setText(currency.format(total));
    		
    	}
    	catch(NumberFormatException ex) {
    		amountTextField.setText("Enter amount");
    		amountTextField.selectAll();
    		amountTextField.requestFocus();
    	}
    	
    }

    // When FXML loader creates a controller class object it determines whether the class contains a 
    // initialize method with no parameters, if so, it calls that method to initialize the controller before 
    //GUI is displayed. Called by FXMLLoader to initialize controller
    public void initialize() {
    	
    	// is suppose round but doesnt seem to work.
    	currency.setRoundingMode(RoundingMode.HALF_UP);
    	
    	// lister for changes to tipPercentageSliders value
    	tipPercentageSlider.valueProperty().addListener(new ChangeListener<Number>() {
    		
    		@Override
    		public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
    			tipPercentage = BigDecimal.valueOf(newValue.intValue() /100.0);
    			tipPercentageLabel.setText(percent.format(tipPercentage));
    		}
    	});
    	
    }
}
