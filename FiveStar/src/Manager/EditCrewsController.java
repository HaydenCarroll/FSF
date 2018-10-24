package Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EditCrewsController {

	
	Stage editCrewsStage = new Stage();
	
	public EditCrewsController() {
		
	}
	public void editCrew() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("EditCrews.fxml"));
			Scene scene = new Scene(root,400,200);
			editCrewsStage.setTitle("Edit Crew");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			editCrewsStage.setScene(scene);
			editCrewsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
