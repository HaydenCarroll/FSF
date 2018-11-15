package Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AmountSelectorController {
	
	public Button enter;
	public TextField amount;
	Stage selectStage = new Stage();
	public String sAmount;
	private String material;
	
	public AmountSelectorController() {
	}
	public void setMaterial(Material mat) {
		this.material=mat.getName();
		sAmount=(this.material+"\n0");
	}
	
	public void newAmount() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AmountSelector.fxml"));
			Scene scene = new Scene(root,250,150);
			selectStage.setTitle("Select Amount");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			selectStage.setScene(scene);
			selectStage.show();
			System.out.println("got to 1");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("got to 2");
		}
	}
	
	public void enter() {
		this.sAmount = this.material+"\n"+amount.getText().trim();
		selectStage.close();
	}

}
