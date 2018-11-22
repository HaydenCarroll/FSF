package Manager;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EditAdvertismentsController{
	
	public TextField name;
	public TextField numUses;
	public TextField cost;
	public TextField profit;
	public TextField newLocation;
	public ListView<String> locations;
	
	
	private static String oName;
	private static int oNumUses;
	private static double oCost;
	private static double oProfit;
	private static ArrayList<String> oLocations;
	private static Ad oAd;
	
	private static ArrayList<String> curLocations;
	private static ObservableList<String> oList;
	private boolean isInitalized = false;

	static {
		curLocations=new ArrayList<String>();
		oList = FXCollections.observableArrayList();
		oName="";
		oCost=-1;
		oProfit=-1;
		oLocations=new ArrayList<String>();
		oAd=new Ad();
	}


	
	Stage editAdvertismentsStage = new Stage();
	
	public EditAdvertismentsController() {
		
	}
	public void sendInfo(Ad ad) {
		oAd=ad;
		oName=ad.getName();
		oNumUses=ad.getNumberOfUses();
		oCost=ad.getAdCost();
		oProfit=ad.getValue();
		curLocations=ad.getLocation();
		
		
	}
	public void editAdvertisments() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("EditAdvertisments.fxml"));
			Scene scene = new Scene(root,600,300);
			editAdvertismentsStage.setTitle("Edit Advertisment");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			editAdvertismentsStage.setScene(scene);
			editAdvertismentsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void refresh() {
		if(isInitalized==false) {
			initalize();
		}else {
			locations.setItems(oList);
		}
		
		
		
	}
	public void initalize() {
		oList.setAll(curLocations);
		locations.setItems(oList);
		name.setText(oName);
		numUses.setText(Integer.toString(oNumUses));
		cost.setText(Double.toString(oCost));
		profit.setText(Double.toString(oProfit));
		isInitalized=true;
	}
	
	public void insert() {
		oList.add(newLocation.getText());
		curLocations.add(newLocation.getText());
		newLocation.clear();
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
		oName="";
		oCost=-1;
		oProfit=-1;
		oLocations=new ArrayList<String>();
		oAd=new Ad();
	}
	public void enter() {
		String n = name.getText();
		int num = Integer.parseInt(numUses.getText());
		double c = Double.parseDouble(cost.getText());
		double v = Double.parseDouble(profit.getText());
		Ad ad = new Ad(n,curLocations,c,num,v);
		
		Data.replace(oAd,ad);
		cancel();
	}
	public void cancel() {
		Stage stage = (Stage) name.getScene().getWindow();
		stage.close();
		clearMem();
	}
}
