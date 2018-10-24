package Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CreateCustomersController {
	
	Stage createCustomersStage = new Stage();
	
	public CreateCustomersController() {
		
	}
	public void newCustomer() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("CreateCustomers.fxml"));
			Scene scene = new Scene(root,600,300);
			createCustomersStage.setTitle("Create Customer");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			createCustomersStage.setScene(scene);
			createCustomersStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
