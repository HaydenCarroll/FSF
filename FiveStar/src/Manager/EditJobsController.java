package Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EditJobsController {
	
	Stage jobEditStage = new Stage();
	
	public EditJobsController() {
		
	}
	
	public void newJob() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("EditJobs.fxml"));
			Scene scene = new Scene(root,600,300);
			jobEditStage.setTitle("Edit Job");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			jobEditStage.setScene(scene);
			jobEditStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
