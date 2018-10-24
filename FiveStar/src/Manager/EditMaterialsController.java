package Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EditMaterialsController {

	
	Stage editMaterialsStage = new Stage();
	
	public EditMaterialsController() {
		
	}
	public void editMaterials() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("EditMaterials.fxml"));
			Scene scene = new Scene(root,600,300);
			editMaterialsStage.setTitle("Edit Material");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			editMaterialsStage.setScene(scene);
			editMaterialsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
