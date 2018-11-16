package Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ConfirmationWindowController {
	
	
	Stage confirmStage = new Stage();
	public Label confirmLabel;
	
	
	private static Object obj;
	
	public ConfirmationWindowController(Object o) {
		obj=o;
		
	}
	public ConfirmationWindowController() {
		
	}
	
	public void confirmWindow() {
		
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("ConfirmationWindow.fxml"));
			Scene scene = new Scene(root,400,200);
			confirmStage.setTitle("Are You Sure?");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			confirmStage.setScene(scene);
			
			confirmStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void confirm() {
		decline();
		Data.remove(obj);
	}
	
	public void refresh() {
		String name = Data.getName(obj);
		confirmLabel.setText("Are you sure you want to delete "+name+"?");
	}
	
	public void decline() {
		Stage stage = (Stage) this.confirmLabel.getScene().getWindow();
		stage.close();
	}

}
