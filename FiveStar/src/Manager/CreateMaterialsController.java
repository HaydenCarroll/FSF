package Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CreateMaterialsController {

	
	Stage createMaterialsStage = new Stage();
	
	public CreateMaterialsController() {
		
	}
	public void newMaterials() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("CreateMaterials.fxml"));
			Scene scene = new Scene(root,600,300);
			createMaterialsStage.setTitle("Create Material");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			createMaterialsStage.setScene(scene);
			createMaterialsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
