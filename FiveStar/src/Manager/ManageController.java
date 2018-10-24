package Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ManageController {
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
