package Manager;

import java.time.LocalDate;
import java.util.LinkedList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


//Add in the chart addition feature and add in stat generator. finish newGraph.fxml
public class DataViewController {
	public TabPane tabPane;
	public Tab newTab;
	private static final ObservableList<String> GRAPHS= FXCollections.observableArrayList(
			"Area","Bar","Bubble","Line","Pie","Scatter","Stacked Area","Stacked Bar");
	//private static final ObservableList<String> 
	
	
	
	public DataViewController(){
		
	}
	
	Stage dataStage = new Stage();
	
	public void openData() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("DataView.fxml"));
			Scene scene = new Scene(root,1200,800);
			dataStage.setTitle("Data");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			dataStage.setScene(scene);
			dataStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void newTab() {
		Tab tab = new Tab();
		int tabNum = tabPane.getTabs().size()-1;
		tab.setText("   Tab "+tabNum+"   ");
		tab.setClosable(true);
		tabPane.getTabs().add(tab);
		AnchorPane a = new AnchorPane();
		tab.setContent(a);
		SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
		selectionModel.select(tab);
		
	}
	
	public void newGraph() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("DataView.fxml"));
			Scene scene = new Scene(root,1200,800);
			dataStage.setTitle("Data");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			dataStage.setScene(scene);
			dataStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
