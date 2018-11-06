package Manager;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ManageController {
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
	
	
	public TableView<Customer> custTable;
	public TableColumn<Customer, String> cuName;
	public TableColumn<Customer, String> cuAddress;
	public TableColumn<Customer, Integer> cuNumOfJobs;
	public TableColumn<Customer, String> cuEmail;
	
	
	public TableView<Crew> crewTable;
	public TableColumn<Crew, String> crName;
	public TableColumn<Crew, Integer> crNumOfJobs;
	public TableColumn<Crew, String> crJobsList;
	
	public TableView<Ad> adTable;
	public TableView<Material> matTable;
	public TableColumn<Material, String> matName;
	public TableColumn<Material, Double> matPrice;
	public TableColumn<Material, Double> matCost;
	public TableColumn<Material, Double> matSpent;
	public TableColumn<Material, Double> matUsed;
	public TableColumn<Material, Double> matSold;
	
	
	Stage manageStage = new Stage();
	
	
	public ManageController() {
		
	}
	
	public void openManageController() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Manage.fxml"));
			Scene scene = new Scene(root,1200,800);
			manageStage.setTitle("Manage Data");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			manageStage.setScene(scene);
			manageStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void jobsTab(){
		try {
		ObservableList<Job> jobList = Data.getJobObservableList();
		saleNo.setCellValueFactory(
				new PropertyValueFactory<Job, Integer>("jobID"));
		date.setCellValueFactory(
				new PropertyValueFactory<Job, String>("sDate"));
		name.setCellValueFactory(
				new PropertyValueFactory<Job, String>("jobName"));
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
	
	public void customersTab() {
		ObservableList<Customer> custList = Data.getCustomerObservableList();
		cuName.setCellValueFactory(
				new PropertyValueFactory<Customer, String>("name"));
		cuAddress.setCellValueFactory(
				new PropertyValueFactory<Customer, String>("sAddress"));
		cuNumOfJobs.setCellValueFactory(
				new PropertyValueFactory<Customer, Integer>("numOfJobs"));
		cuEmail.setCellValueFactory(
				new PropertyValueFactory<Customer, String>("email"));
		custTable.setItems(custList);
	}
	
	
	public void crewsTab() {
		ObservableList<Crew> crewList = Data.getCrewObservableList();
		crName.setCellValueFactory(
				new PropertyValueFactory<Crew, String>("name"));
		crNumOfJobs.setCellValueFactory(
				new PropertyValueFactory<Crew, Integer>("numOfJobs"));
		crJobsList.setCellValueFactory(
				new PropertyValueFactory<Crew, String>("sJobsList"));
		crewTable.setItems(crewList);
	}
	
	//do ad tab
	
	public void materialTab() {
		try {
		ObservableList<Material> materialList = Data.getMaterialObservableList();
		matName.setCellValueFactory(
				new PropertyValueFactory<Material, String>("name"));
		matPrice.setCellValueFactory(
				new PropertyValueFactory<Material, Double>("pricePF"));
		matCost.setCellValueFactory(
				new PropertyValueFactory<Material, Double>("costPU"));
		matSpent.setCellValueFactory(
				new PropertyValueFactory<Material, Double>("totalAmtSpent"));
		matUsed.setCellValueFactory(
				new PropertyValueFactory<Material, Double>("totalFootage"));
		matSold.setCellValueFactory(
				new PropertyValueFactory<Material, Double>("totalAmtSold"));
		matTable.setItems(materialList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void openEditJobs() {
		EditJobsController editJobs = new EditJobsController();
		editJobs.newJob();
	}
	
	public void newJob() {
		JobCreateController startNewJob =new JobCreateController();
		startNewJob.newJob();
	}
	
	
	public void openEditCustomers() {
		EditCustomersController editCustomers = new EditCustomersController();
		editCustomers.editCustomer();
	}
	
	public void openCreateCustomers() {
		CreateCustomersController createCustomers = new CreateCustomersController();
		createCustomers.newCustomer();
	}
	
	
	public void openEditCrews() {
		EditCrewsController editCrews = new EditCrewsController();
		editCrews.editCrew();
	}
	
	public void openCreateCrews() {
		CreateCrewsController createCrews = new CreateCrewsController();
		createCrews.newCrew();
	}
	
	
	public void openEditAdvertisments() {
		EditAdvertismentsController editAdvertisments = new EditAdvertismentsController();
		editAdvertisments.editAdvertisments();
	}
	
	public void openCreateAdvertisments() {
		CreateAdvertismentsController createAdvertisments = new CreateAdvertismentsController();
		createAdvertisments.newAdvertisments();
	}
	
	
	public void openEditMaterials() {
		EditMaterialsController editMaterials = new EditMaterialsController();
		editMaterials.editMaterials();
	}
	
	public void openCreateMaterials() {
		CreateMaterialsController createMaterials = new CreateMaterialsController();
		createMaterials.newMaterials();
	}

}
