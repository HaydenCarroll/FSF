package Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EditAdvertismentsController {


	
	Stage editAdvertismentsStage = new Stage();
	
	public EditAdvertismentsController() {
		
	}
	public void editAdvertisments() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("EditAdvertisments.fxml"));
			Scene scene = new Scene(root,600,300);
			editAdvertismentsStage.setTitle("Edit Advertisment");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			editAdvertismentsStage.setScene(scene);
			editAdvertismentsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
