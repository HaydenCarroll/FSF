package Manager;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BaseController {
	
	public TableView<Job> jobsTable;
	public TableColumn<Job, Integer> saleNo;
	public TableColumn<Job, String> date;
	public TableColumn<Job, String> name;
	public TableColumn<Job, String> city;
	public TableColumn<Job, String> fenceStyle;
	public TableColumn<Job, Double> feet;
	public TableColumn<Job, Double> quote;
	public TableColumn<Job, String> reference;
	public TableColumn<Job, String> crew;
	public TableColumn<Job, Boolean> sold;
	public TableColumn<Job, Double> profit;
	
	public void newJob() {
		JobCreateController startNewJob =new JobCreateController();
		startNewJob.newJob();
	}
	
	public void openManage() {
		ManageController manage = new ManageController();
		manage.openManageController();
	}
	
	public void endJob() {
		CompleteJobController complete = new CompleteJobController();
		complete.sendInfo(jobsTable.getSelectionModel().getSelectedItem());
		complete.editJob();
		complete=null;
	}
	
	public void dataTab() {
		DataViewController data = new DataViewController();
		data.openData();
	}
	
	public void jobsTab(){
		try {
		ObservableList<Job> jobList = Data.getJobObservableList();
		saleNo.setCellValueFactory(
				new PropertyValueFactory<Job, Integer>("jobID"));
		date.setCellValueFactory(
				new PropertyValueFactory<Job, String>("sDate"));
		name.setCellValueFactory(
				new PropertyValueFactory<Job, String>("name"));
		city.setCellValueFactory(
				new PropertyValueFactory<Job, String>("cityName"));
		fenceStyle.setCellValueFactory(
				new PropertyValueFactory<Job, String>("fenceName"));
		feet.setCellValueFactory(
				new PropertyValueFactory<Job, Double>("footage"));
		quote.setCellValueFactory(
				new PropertyValueFactory<Job, Double>("quote"));
		reference.setCellValueFactory(
				new PropertyValueFactory<Job, String>("sAd"));
		crew.setCellValueFactory(
				new PropertyValueFactory<Job, String>("sCrew"));
		sold.setCellValueFactory(
				new PropertyValueFactory<Job, Boolean>("completed"));
		profit.setCellValueFactory(
				new PropertyValueFactory<Job, Double>("profit"));
		jobsTable.setItems(jobList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void genQuote() {
		FSF f = new FSF();
		f.sendData(jobsTable.getSelectionModel().getSelectedItem());
		f.editJob();
		f=null;
	}
	
}
