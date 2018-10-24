package Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CreateCrewsController {
	
	Stage createCrewsStage = new Stage();
	
	public CreateCrewsController() {
		
	}
	public void newCrew() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("CreateCrews.fxml"));
			Scene scene = new Scene(root,400,200);
			createCrewsStage.setTitle("Create Crew");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			createCrewsStage.setScene(scene);
			createCrewsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
