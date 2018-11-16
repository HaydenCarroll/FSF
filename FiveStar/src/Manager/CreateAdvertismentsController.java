package Manager;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CreateAdvertismentsController {
	
	public TextField name;
	public TextField numUses;
	public TextField cost;
	public TextField profit;
	public TextField newLocation;
	public ListView<String> locations;
	
	private static ArrayList<String> curLocations;
	private static ObservableList<String> oList;

	static {
		curLocations=new ArrayList<String>();
		oList = FXCollections.observableArrayList();
	}
	
	Stage createAdvertismentsStage = new Stage();
	
	public CreateAdvertismentsController() {
	}
	public void newAdvertisments() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("CreateAdvertisments.fxml"));
			Scene scene = new Scene(root,600,300);
			createAdvertismentsStage.setTitle("Create Advertisment");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			createAdvertismentsStage.setScene(scene);
			createAdvertismentsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void refresh() {
		locations.setItems(oList);
	}
	
	public void insert() {
		oList.add(newLocation.getText());
		curLocations.add(newLocation.getText());
		newLocation.clear();
		refresh();
	}
	public void delete() {
		String selected = locations.getSelectionModel().getSelectedItem();
		oList.remove(selected);
		curLocations.remove(selected);
		refresh();
	}
	public void clearMem() {
		curLocations=new ArrayList<String>();
		oList = FXCollections.observableArrayList();
	}
	public void enter() {
		String n = name.getText();
		int num = Integer.parseInt(numUses.getText());
		double c = Double.parseDouble(cost.getText());
		double v = Double.parseDouble(profit.getText());
		Ad ad = new Ad(n,curLocations,c,num,v);
		Data.updateAdList(ad);
		try {
			Data.updateDataFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cancel();
	}
	public void cancel() {
		Stage stage = (Stage) name.getScene().getWindow();
		stage.close();
		clearMem();
	}
	

}
