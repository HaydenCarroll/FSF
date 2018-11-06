package Manager;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JobCreateController {
	public ComboBox<Ad> adSelector;
	public ComboBox<Crew> crewSelector;
	public ComboBox<Material> materialSelector;
	public ComboBox<Customer> customerSelector;
	public TextField quote;
	public TextField footage;
	public TextField street;
	public TextField city;
	public TextField state;
	public TextField zipCode;
	public DatePicker date;
	public TextField laborCost;
	public TextField jobName;
	
	Stage jobStage = new Stage();
	
	
	public JobCreateController() {
		
	}
	
	
	public void newJob() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("JobCreate.fxml"));
			Scene scene = new Scene(root,600,300);
			jobStage.setTitle("Create Job");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			jobStage.setScene(scene);
			jobStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enter() {
		Address address = new Address(street.getText(),city.getText(),state.getText(),Integer.parseInt(zipCode.getText()));
		Ad ad = adSelector.getValue();
		Crew crew = crewSelector.getValue();
		Material material = materialSelector.getValue();
		Customer cust = customerSelector.getValue();
		Job job = new Job(ad,crew,material,Integer.parseInt(quote.getText()),Integer.parseInt(footage.getText()),address,Double.parseDouble(laborCost.getText()),date.getValue(), cust, jobName.getText());
		Data.updateJobList(job);
		try {
			Data.updateDataFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cancel() {
		jobStage.close();
	}

}
