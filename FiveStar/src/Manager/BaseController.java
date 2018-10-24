package Manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BaseController {
	
	public void newJob() {
		JobCreateController startNewJob =new JobCreateController();
		startNewJob.newJob();
	}
	
	public void openManage() {
		ManageController manage = new ManageController();
		manage.openManageController();
	}
	
}
