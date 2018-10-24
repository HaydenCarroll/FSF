package Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CreateAdvertismentsController {

	
	Stage createAdvertismentsStage = new Stage();
	
	public CreateAdvertismentsController() {
		
	}
	public void newAdvertisments() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("CreateAdvertisments.fxml"));
			Scene scene = new Scene(root,600,300);
			createAdvertismentsStage.setTitle("Create Advertisment");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			createAdvertismentsStage.setScene(scene);
			createAdvertismentsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
