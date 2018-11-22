package Manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

import com.sun.corba.se.impl.orbutil.graph.Graph;

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
	public ChoiceBox<String> category;
	public ChoiceBox<String> profitOrSpending;
	public ChoiceBox<String> spacing;
	public TextField title;
	public DatePicker start;
	public DatePicker end;
	
	
	private static LinkedList<Tab> tabs;
	private static LinkedList<Chart> graphs;
	
	private static final ObservableList<String> CATEGORIES = FXCollections.observableArrayList("Job","Ad","Crew","Customer","Materials");
	
	private static final ObservableList<String> POS = FXCollections.observableArrayList("Profit","Spendature");
	
	private static final ObservableList<String> DMY = FXCollections.observableArrayList("Day","Month","Year");
	
	static {
		tabs = new LinkedList<Tab>();
		graphs=new LinkedList<Chart>();
	}
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
		tabs.add(tab);
		tab.setOnClosed(e->{
			System.out.println("removing "+tab.getText());
			tabs.remove(tab);
		});
		
		
	}
	
	public void newGraph() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("NewGraph.fxml"));
			Scene scene = new Scene(root,800,600);
			dataStage.setTitle("New Graph");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			dataStage.setScene(scene);
			dataStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initGraph() {
		category.setItems(CATEGORIES);
		profitOrSpending.setItems(POS);
		spacing.setItems(DMY);
	}
	
	
	
	/*private static final ObservableList<String> PROFIT = FXCollections.observableArrayList("Overall Profit","Job","Ad","Crew","Customer");
	private static final ObservableList<String> SPENDATURE = FXCollections.observableArrayList("Overall Spending","Job","Ad","Crew","Customer");*/
	
	public void generateGraph() {
		
		String cat = category.getValue();
		String proSpen = profitOrSpending.getValue();
		switch (proSpen) {
		case "Profit":
			
			switch(cat) {
			case "Job":
				
				break;
				
			case "Ad":
				break;
				
			case "Crew":
				break;
				
			case "Customer":
				break;
				
			case "Materials":
				break;
				
			}
			
			break;
		
		case "Spendature":
			
			switch(cat) {
			case "Job":
				
				break;
				
			case "Ad":
				break;
				
			case "Crew":
				break;
				
			case "Customer":
				break;
				
			case "Materials":
				break;
				
			}
			break;
		}
	}
	
	public void getJobChart(LocalDate s, LocalDate e, String dmy, String proSpend) {
		
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		XYChart.Series series = new XYChart.Series();
		series.setName("Jobs");
		ArrayList<Job> list = Data.getJobByDate(s, e);
		int start = -1;
		int end = -1;
		switch (dmy) {
		case "Day":
			start = s.getDayOfYear();
			end = e.getDayOfYear();
			xAxis.setLabel("Day Of Year");
			for(int i=0;i<list.size();i++) {
				int comp = list.get(i).getDateCompleted().getDayOfYear();
				double prof = list.get(i).getProfit();
				series.getData().add(new XYChart.Data(comp,prof));
			}
			break;
			
		case "Month":
			start = s.getMonthValue();
			end = e.getMonthValue();
			xAxis.setLabel("Number Of Month");
			for(int i=0;i<list.size();i++) {
				int comp = list.get(i).getDateCompleted().getMonthValue();
				double prof = list.get(i).getProfit();
				series.getData().add(new XYChart.Data(comp,prof));
			}
			break;
			    
		case "Year":
			start = s.getYear();
			end = e.getYear();
			xAxis.setLabel("Year");
			for(int i=0;i<list.size();i++) {
				int comp = list.get(i).getDateCompleted().getYear();
				double prof = list.get(i).getProfit();
				series.getData().add(new XYChart.Data(comp,prof));
			}
			break;
		}
		
		
		
		LineChart<Number,Number> chart = new LineChart<Number,Number>(xAxis,yAxis);
		chart.getData().add(series);
		
		
	}

}
