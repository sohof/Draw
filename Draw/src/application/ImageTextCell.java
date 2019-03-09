package application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class ImageTextCell extends ListCell<Book>{

	private VBox vbox = new VBox(8.0); // 8 points of gap between controls
	private ImageView thumbImageView = new ImageView();
	private Label label = new Label();
	
	public ImageTextCell() {
		vbox.setAlignment(Pos.CENTER); // center vbox content horizontally
		thumbImageView.setPreserveRatio(true);
		thumbImageView.setFitHeight(100.0);
		vbox.getChildren().add(thumbImageView);
		
		label.setWrapText(true); // wrap if text to wide to fit in label
		label.setTextAlignment(TextAlignment.CENTER); // center text
		vbox.getChildren().add(label);
		
		setPrefWidth(USE_PREF_SIZE);

	}

	@Override
	protected void updateItem(Book item, boolean empty) {
		super.updateItem(item, empty);
		
		if(empty || item == null) {
				setGraphic(null);
		}
		else {
			
			thumbImageView.setImage(new Image(item.getThumbImage()));
			label.setText(item.getTitle());
			setGraphic(vbox);
		}
				
		
	}
	
	
}
