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
import javafx.util.StringConverter;


//Add in the chart addition feature and add in stat generator. finish newGraph.fxml
public class DataViewController {
	public TabPane tabPane;
	public Tab newTab;
	public ChoiceBox<String> category;
	public ChoiceBox<String> profitOrSpending;
	
	public ChoiceBox<String> spacingJob;
	public DatePicker startJob;
	public DatePicker endJob;
	
	public ChoiceBox<String> spacingAd;
	public DatePicker startAd;
	public DatePicker endAd;
	
	public ChoiceBox<String> spacingCustomer;
	public DatePicker startCustomer;
	public DatePicker endCustomer;
	
	public ChoiceBox<String> spacingCrew;
	public DatePicker startCrew;
	public DatePicker endCrew;
	
	public ChoiceBox<String> spacingMaterial;
	public DatePicker startMaterial;
	public DatePicker endMaterial;
	
	public LineChart<Number,Number> jobProfitChart;
	public LineChart<Number,Number> jobSpendingChart;
	public NumberAxis xAxisProfitJob;
	public NumberAxis yAxisProfitJob;
	public NumberAxis xAxisSpendingJob;
	public NumberAxis yAxisSpendingJob;
	
	public LineChart<Number,Number> adProfitChart;
	public LineChart<Number,Number> adSpendingChart;
	public NumberAxis xAxisProfitAd;
	public NumberAxis yAxisProfitAd;
	public NumberAxis xAxisSpendingAd;
	public NumberAxis yAxisSpendingAd;
	public Label MSAD;
	public Label MVAD;
	public Label LSAD;
	public Label LVAD;
	
	public LineChart<Number,Number> customerProfitChart;
	public LineChart<Number,Number> customerSpendingChart;
	public NumberAxis xAxisProfitCustomer;
	public NumberAxis yAxisProfitCustomer;
	public NumberAxis xAxisSpendingCustomer;
	public NumberAxis yAxisSpendingCustomer;
	
	public LineChart<Number,Number> crewProfitChart;
	public LineChart<Number,Number> crewSpendingChart;
	public NumberAxis xAxisProfitCrew;
	public NumberAxis yAxisProfitCrew;
	public NumberAxis xAxisSpendingCrew;
	public NumberAxis yAxisSpendingCrew;
	
	public LineChart<Number,Number> materialProfitChart;
	public LineChart<Number,Number> materialSpendingChart;
	public NumberAxis xAxisProfitMaterial;
	public NumberAxis yAxisProfitMaterial;
	public NumberAxis xAxisSpendingMaterial;
	public NumberAxis yAxisSpendingMaterial;
	
	
	//private static final ObservableList<String> CATEGORIES = FXCollections.observableArrayList("Job","Ad","Crew","Customer","Materials");
	
	//private static final ObservableList<String> POS = FXCollections.observableArrayList("Profit","Spendature");
	
	private static final ObservableList<String> DMY = FXCollections.observableArrayList("Day","Month","Year");
	
	public DataViewController(){
		
	}
	
	Stage dataStage = new Stage();
	
	public void openData() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("DataView.fxml"));
			Scene scene = new Scene(root,1600,900);
			dataStage.setTitle("Data");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			dataStage.setScene(scene);
			dataStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initalize() {
		spacingJob.setItems(DMY);
		spacingAd.setItems(DMY);
		spacingCustomer.setItems(DMY);
		spacingCrew.setItems(DMY);
		spacingMaterial.setItems(DMY);
	}
	
	
	
	public void getJobCharts() {
		LocalDate s = startJob.getValue();
		LocalDate e = endJob.getValue();
		String dmy = spacingJob.getValue();

		XYChart.Series profitSeries = new XYChart.Series();
		XYChart.Series spendingSeries = new XYChart.Series();
		profitSeries.setName("Jobs");
		spendingSeries.setName("Jobs");
		ArrayList<Job> list = Data.getJobByDate(s, e);
		int start = -1;
		int end = -1;
		switch (dmy) {
		case "Day":
			start = s.getDayOfYear();
			end = e.getDayOfYear();
			xAxisSpendingJob.setLabel("Day Of Year");
			xAxisProfitJob.setLabel("Day Of Year");
			for(int i=0;i<list.size();i++) {
				int comp = list.get(i).getDateCompleted().getDayOfYear();
				double prof = list.get(i).getProfit();
				double spend = list.get(i).getSpending();
				spendingSeries.getData().add(new XYChart.Data(comp,spend));
				profitSeries.getData().add(new XYChart.Data(comp,prof));
			}
			break;
			
		case "Month":
			start = s.getMonthValue();
			end = e.getMonthValue();
			xAxisSpendingJob.setLabel("Number Of Month");
			xAxisProfitJob.setLabel("Number Of Month");
			for(int i=0;i<list.size();i++) {
				int comp = list.get(i).getDateCompleted().getMonthValue();
				double prof = list.get(i).getProfit();
				double spend = list.get(i).getSpending();
				spendingSeries.getData().add(new XYChart.Data(comp,spend));
				profitSeries.getData().add(new XYChart.Data(comp,prof));
			}
			break;
			    
		case "Year":
			start = s.getYear();
			end = e.getYear();
			xAxisSpendingJob.setLabel("Year");
			xAxisProfitJob.setLabel("Year");
			for(int i=0;i<list.size();i++) {
				int comp = list.get(i).getDateCompleted().getYear();
				double prof = list.get(i).getProfit();
				double spend = list.get(i).getSpending();
				spendingSeries.getData().add(new XYChart.Data(comp,spend));
				profitSeries.getData().add(new XYChart.Data(comp,prof));
			}
			break;
		}
		
		jobSpendingChart.getData().add(spendingSeries);
		jobProfitChart.getData().add(profitSeries);
		
		
		
	}
	
	public void clearJobCharts() {
		jobSpendingChart.getData().clear();
		jobProfitChart.getData().clear();
	}
	
	public void getAdCharts() {
		LocalDate s = startAd.getValue();
		LocalDate e = endAd.getValue();
		String dmy = spacingAd.getValue();
		XYChart.Series profitSeries = new XYChart.Series();
		XYChart.Series spendingSeries = new XYChart.Series();
		profitSeries.setName("Ads");
		spendingSeries.setName("Ads");
		ArrayList<Job> list = Data.getJobByDate(s, e);
		ArrayList<Ad> adList = new ArrayList<Ad>();
		int start = -1;
		int end = -1;
		switch (dmy) {
		case "Day":
			start = s.getDayOfYear();
			end = e.getDayOfYear();
			xAxisSpendingAd.setLabel("Day Of Year");
			xAxisProfitAd.setLabel("Day Of Year");
			for(int i=0;i<list.size();i++) {
				Ad ad = list.get(i).getAd();
				adList.add(ad);
				int comp = list.get(i).getDateCompleted().getDayOfYear();
				double prof = ad.getValue();
				double spend = ad.getAdCost();
				spendingSeries.getData().add(new XYChart.Data(comp,spend));
				profitSeries.getData().add(new XYChart.Data(comp,prof));
			}
			break;
			
		case "Month":
			start = s.getMonthValue();
			end = e.getMonthValue();
			xAxisSpendingAd.setLabel("Number Of Month");
			xAxisProfitAd.setLabel("Number Of Month");
			for(int i=0;i<list.size();i++) {
				Ad ad = list.get(i).getAd();
				adList.add(ad);
				int comp = list.get(i).getDateCompleted().getMonthValue();
				double prof = ad.getValue();
				double spend = ad.getAdCost();
				spendingSeries.getData().add(new XYChart.Data(comp,spend));
				profitSeries.getData().add(new XYChart.Data(comp,prof));
			}
			break;
			    
		case "Year":
			start = s.getYear();
			end = e.getYear();
			xAxisSpendingAd.setLabel("Year");
			xAxisProfitAd.setLabel("Year");
			for(int i=0;i<list.size();i++) {
				Ad ad = list.get(i).getAd();
				adList.add(ad);
				int comp = list.get(i).getDateCompleted().getYear();
				double prof = ad.getValue();
				double spend = ad.getAdCost();
				spendingSeries.getData().add(new XYChart.Data(comp,spend));
				profitSeries.getData().add(new XYChart.Data(comp,prof));
			}
			break;
		}
		adSpendingChart.getData().add(spendingSeries);
		adProfitChart.getData().add(profitSeries);
		MSAD.setText(Data.getMostSeenAd(adList).getName());
		MVAD.setText(Data.getMostValueAd(adList).getName());
		LSAD.setText(Data.getLeastSeenAd(adList).getName());
		LVAD.setText(Data.getLeastValueAd(adList).getName());
		
		
	}
	
	public void clearAdCharts() {
		adSpendingChart.getData().clear();
		adProfitChart.getData().clear();
	}
	
	public void getCustomerCharts() {
		LocalDate s = startAd.getValue();
		LocalDate e = endAd.getValue();
		String dmy = spacingAd.getValue();
		XYChart.Series profitSeries = new XYChart.Series();
		XYChart.Series spendingSeries = new XYChart.Series();
		profitSeries.setName("Customers");
		spendingSeries.setName("Customers");
		ArrayList<Job> list = Data.getJobByDate(s, e);
		int start = -1;
		int end = -1;
		switch (dmy) {
		case "Day":
			start = s.getDayOfYear();
			end = e.getDayOfYear();
			xAxisSpendingCustomer.setLabel("Day Of Year");
			xAxisProfitCustomer.setLabel("Day Of Year");
			for(int i=0;i<list.size();i++) {
				Customer cust = list.get(i).getCustomer();
				int comp = list.get(i).getDateCompleted().getDayOfYear();
				double prof = Data.getTotalRev(Data.getJobListByCustomer(cust));
				double spend = Data.getTotalSpend(Data.getJobListByCustomer(cust));
				spendingSeries.getData().add(new XYChart.Data(comp,spend));
				profitSeries.getData().add(new XYChart.Data(comp,prof));
			}
			break;
			
		case "Month":
			start = s.getMonthValue();
			end = e.getMonthValue();
			xAxisSpendingCustomer.setLabel("Number Of Month");
			xAxisProfitCustomer.setLabel("Number Of Month");
			for(int i=0;i<list.size();i++) {
				Customer cust = list.get(i).getCustomer();
				int comp = list.get(i).getDateCompleted().getDayOfYear();
				double prof = Data.getTotalRev(Data.getJobListByCustomer(cust));
				double spend = Data.getTotalSpend(Data.getJobListByCustomer(cust));
				spendingSeries.getData().add(new XYChart.Data(comp,spend));
				profitSeries.getData().add(new XYChart.Data(comp,prof));
			}
			break;
			    
		case "Year":
			start = s.getYear();
			end = e.getYear();
			xAxisSpendingCustomer.setLabel("Year");
			xAxisProfitCustomer.setLabel("Year");
			for(int i=0;i<list.size();i++) {
				Customer cust = list.get(i).getCustomer();
				int comp = list.get(i).getDateCompleted().getDayOfYear();
				double prof = Data.getTotalRev(Data.getJobListByCustomer(cust));
				double spend = Data.getTotalSpend(Data.getJobListByCustomer(cust));
				spendingSeries.getData().add(new XYChart.Data(comp,spend));
				profitSeries.getData().add(new XYChart.Data(comp,prof));
			}
			break;
		}
		
		customerSpendingChart.getData().add(spendingSeries);
		customerProfitChart.getData().add(profitSeries);
		
	}
	
	public void clearCustomerCharts() {
		customerSpendingChart.getData().clear();
		customerProfitChart.getData().clear();
	}
	
	public void getCrewCharts() {
		LocalDate s = startAd.getValue();
		LocalDate e = endAd.getValue();
		String dmy = spacingAd.getValue();
		XYChart.Series profitSeries = new XYChart.Series();
		XYChart.Series spendingSeries = new XYChart.Series();
		profitSeries.setName("Crew");
		spendingSeries.setName("Crew");
		ArrayList<Job> list = Data.getJobByDate(s, e);
		int start = -1;
		int end = -1;
		switch (dmy) {
		case "Day":
			start = s.getDayOfYear();
			end = e.getDayOfYear();
			xAxisSpendingCrew.setLabel("Day Of Year");
			xAxisProfitCrew.setLabel("Day Of Year");
			for(int i=0;i<list.size();i++) {
				Crew cr = list.get(i).getCrew();
				int comp = list.get(i).getDateCompleted().getDayOfYear();
				double prof = Data.getTotalRev(cr.getJobList());
				double spend = Data.getTotalSpend(cr.getJobList());
				spendingSeries.getData().add(new XYChart.Data(comp,spend));
				profitSeries.getData().add(new XYChart.Data(comp,prof));
			}
			break;
			
		case "Month":
			start = s.getMonthValue();
			end = e.getMonthValue();
			xAxisSpendingCrew.setLabel("Number Of Month");
			xAxisProfitCrew.setLabel("Number Of Month");
			for(int i=0;i<list.size();i++) {
				Crew cr = list.get(i).getCrew();
				int comp = list.get(i).getDateCompleted().getDayOfYear();
				double prof = Data.getTotalRev(cr.getJobList());
				double spend = Data.getTotalSpend(cr.getJobList());
				spendingSeries.getData().add(new XYChart.Data(comp,spend));
				profitSeries.getData().add(new XYChart.Data(comp,prof));
			}
			break;
			    
		case "Year":
			start = s.getYear();
			end = e.getYear();
			xAxisSpendingCrew.setLabel("Year");
			xAxisProfitCrew.setLabel("Year");
			for(int i=0;i<list.size();i++) {
				Crew cr = list.get(i).getCrew();
				int comp = list.get(i).getDateCompleted().getDayOfYear();
				double prof = Data.getTotalRev(cr.getJobList());
				double spend = Data.getTotalSpend(cr.getJobList());
				spendingSeries.getData().add(new XYChart.Data(comp,spend));
				profitSeries.getData().add(new XYChart.Data(comp,prof));
			}
			break;
		}
		
		crewSpendingChart.getData().add(spendingSeries);
		crewProfitChart.getData().add(profitSeries);
		
	}
	
	public void clearCrewCharts() {
		crewSpendingChart.getData().clear();
		crewProfitChart.getData().clear();
	}
	
	public void getMaterialCharts() {
		LocalDate s = startAd.getValue();
		LocalDate e = endAd.getValue();
		String dmy = spacingAd.getValue();
		XYChart.Series profitSeries = new XYChart.Series();
		XYChart.Series spendingSeries = new XYChart.Series();
		profitSeries.setName("Material");
		spendingSeries.setName("Material");
		ArrayList<Job> list = Data.getJobByDate(s, e);
		int start = -1;
		int end = -1;
		switch (dmy) {
		case "Day":
			start = s.getDayOfYear();
			end = e.getDayOfYear();
			xAxisSpendingMaterial.setLabel("Day Of Year");
			xAxisProfitMaterial.setLabel("Day Of Year");
			for(int i=0;i<list.size();i++) {
				ArrayList<Material> mList = list.get(i).getMatList();
				for(int j=0;j<mList.size();j++) {
					Material m=mList.get(j);
					int comp = list.get(i).getDateCompleted().getDayOfYear();
					double prof = m.getTotalAmtSold();
					double spend = m.getTotalAmtSpent();
					spendingSeries.getData().add(new XYChart.Data(comp,spend));
					profitSeries.getData().add(new XYChart.Data(comp,prof));
				}
				
			}
			break;
			
		case "Month":
			start = s.getMonthValue();
			end = e.getMonthValue();
			xAxisSpendingMaterial.setLabel("Number Of Month");
			xAxisProfitMaterial.setLabel("Number Of Month");
			for(int i=0;i<list.size();i++) {
				ArrayList<Material> mList = list.get(i).getMatList();
				for(int j=0;j<mList.size();j++) {
					Material m=mList.get(j);
					int comp = list.get(i).getDateCompleted().getDayOfYear();
					double prof = m.getTotalAmtSold();
					double spend = m.getTotalAmtSpent();
					spendingSeries.getData().add(new XYChart.Data(comp,spend));
					profitSeries.getData().add(new XYChart.Data(comp,prof));
				}
			}
			break;
			    
		case "Year":
			start = s.getYear();
			end = e.getYear();
			xAxisSpendingMaterial.setLabel("Year");
			xAxisProfitMaterial.setLabel("Year");
			for(int i=0;i<list.size();i++) {
				ArrayList<Material> mList = list.get(i).getMatList();
				for(int j=0;j<mList.size();j++) {
					Material m=mList.get(j);
					int comp = list.get(i).getDateCompleted().getDayOfYear();
					double prof = m.getTotalAmtSold();
					double spend = m.getTotalAmtSpent();
					spendingSeries.getData().add(new XYChart.Data(comp,spend));
					profitSeries.getData().add(new XYChart.Data(comp,prof));
				}
			}
			break;
		}
		
		materialSpendingChart.getData().add(spendingSeries);
		materialProfitChart.getData().add(profitSeries);
		
	}
	
	public void clearMaterialCharts() {
		materialSpendingChart.getData().clear();
		materialProfitChart.getData().clear();
	}

}
