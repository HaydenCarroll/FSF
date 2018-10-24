package Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EditCustomersController {
	
	Stage editCustomersStage = new Stage();
	
	public EditCustomersController() {
		
	}
	public void editCustomer() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("EditCustomers.fxml"));
			Scene scene = new Scene(root,600,300);
			editCustomersStage.setTitle("Edit Customer");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			editCustomersStage.setScene(scene);
			editCustomersStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
