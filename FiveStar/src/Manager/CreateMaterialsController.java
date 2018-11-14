package Manager;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CreateMaterialsController {
	
	public TextField name;
	public TextField price;
	public TextField cost;
	public TextField amtSpent;
	public TextField footageUsed;
	public TextField amtSold;

	
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
	
	public void enter() {
		Material mat = new Material(name.getText(),Double.parseDouble(price.getText()), Double.parseDouble(cost.getText()), Double.parseDouble(amtSpent.getText()), Double.parseDouble(amtSold.getText()));
		Data.updateMaterialList(mat);
		System.out.println("Material Created");
		try {
			System.out.println("Updating file");
			Data.updateDataFile();
			cancel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cancel() {
		createMaterialsStage.close();
	}

}
