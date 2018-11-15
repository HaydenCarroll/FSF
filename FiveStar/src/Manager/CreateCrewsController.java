package Manager;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CreateCrewsController {
	public TextField name;
	public TextField numJobs;
	Stage createCrewsStage = new Stage();
	
	public CreateCrewsController() {
		
	}
	public void newCrew() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("CreateCrews.fxml"));
			Scene scene = new Scene(root,400,200);
			createCrewsStage.setTitle("Create Crew");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			createCrewsStage.setScene(scene);
			createCrewsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enter() {
		if(numJobs.getText().isEmpty()) {
			Crew crew = new Crew(name.getText());
			Data.updateCrewList(crew);
			System.out.println("Material Created");
			try {
				System.out.println("Updating file");
				Data.updateDataFile();
				cancel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			Crew crew = new Crew(name.getText(),Integer.parseInt(numJobs.getText()));
			Data.updateCrewList(crew);
			System.out.println("Material Created");
			try {
				System.out.println("Updating file");
				Data.updateDataFile();
				cancel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void cancel() {
		Stage stage = (Stage) name.getScene().getWindow();
		stage.close();
	}

}
