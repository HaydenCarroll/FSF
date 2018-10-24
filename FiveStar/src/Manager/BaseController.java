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
	TableColumn<Job, Integer> saleNo;
	TableColumn<Job, String> date;
	TableColumn<Job, String> name;
	TableColumn<Job, String> city;
	TableColumn<Job, Material> fenceStyle;
	TableColumn<Job, Double> feet;
	TableColumn<Job, Double> quote;
	TableColumn<Job, String> reference;
	TableColumn<Job, String> crew;
	TableColumn<Job, Boolean> sold;
	TableColumn<Job, String> profit;
	TableView<Job> tv;
	
	public void newJob() {
		JobCreateController startNewJob =new JobCreateController();
		startNewJob.newJob();
	}
	
	public void openManage() {
		ManageController manage = new ManageController();
		manage.openManageController();
	}
	
	public static void main(String[] args) {
		
	}
	
	
	public void initalize() {
		ObservableList<Job> jobList = Data.getJobObservableList();
		saleNo.setCellValueFactory(
				new PropertyValueFactory<Job, Integer>("jobID"));
		date.setCellValueFactory(
				new PropertyValueFactory<Job, String>("sDate"));
		tv.setItems(jobList);
		
	}
	
}
