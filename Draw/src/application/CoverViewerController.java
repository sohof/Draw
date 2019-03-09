package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Callback;

public class CoverViewerController {

	@FXML   private ListView<Book> booksListView;

	@FXML   private ImageView coverImageView;

	private final ObservableList<Book> books = FXCollections.observableArrayList();

	public void initialize() {

		books.add(new Book("Android How to Program", "application/view/images/small/androidhtp.jpg", "application/view/images/large/androidhtp.jpg"));
		books.add(new Book("C++ How to Program", "application/view/images/small/cpphtp.jpg", "application/view/images/large/cpphtp.jpg"));
		books.add(new Book("Java How to Program", "application/view/images/small/jhtp.jpg", "application/view/images/large/jhtp.jpg"));
		books.add(new Book("C How to Program", "application/view/images/small/chtp.jpg", "application/view/images/large/chtp.jpg"));
		books.add(new Book("Visual C# How to Program", "application/view/images/small/vcshtp.jpg", "application/view/images/large/vcshtp.jpg"));
		books.add(new Book("Internet and World Wide Web How to Program", "application/view/images/small/iw3htp.jpg", "application/view/images/large/iw3htp.jpg"));

		booksListView.setItems(books);


		booksListView.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Book>() {
					@Override
					public void changed(ObservableValue<? extends Book> ov, Book oldValue, Book newValue) {
						coverImageView.setImage(new Image(newValue.getLargeImage())); 

					}
				}
				);
		
		booksListView.setCellFactory(
			new Callback<ListView<Book>, ListCell<Book>>() {
			@Override	
			public ListCell<Book> call(ListView<Book> listView) {
				return new ImageTextCell();
			}
		
			}
		
				);
	}
}
