package Manager;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CreateCustomersController {
	public TextField name;
	public TextField numJobs;
	public TextField street;
	public TextField city;
	public TextField state;
	public TextField zip;
	public TextField email;
	public TextField phoneNum;
	public ChoiceBox<String> refrence;
	private boolean isRefreshed=false;
	
	
	
	Stage createCustomersStage = new Stage();
	
	public CreateCustomersController() {
		
	}
	public void newCustomer() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("CreateCustomers.fxml"));
			Scene scene = new Scene(root,600,300);
			createCustomersStage.setTitle("Create Customer");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			createCustomersStage.setScene(scene);
			createCustomersStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void refresh() {
		if(isRefreshed==false) {
			refrence.setItems(Data.getRefrences());
			isRefreshed=true;
		}
		
	}
	public void enter() {
		Address a = new Address(street.getText(),city.getText(),state.getText(),Integer.parseInt(zip.getText()));
		if (refrence.getSelectionModel().isEmpty()) {
			
			System.out.println(phoneNum.getText());
			
			Customer c = new Customer(name.getText(),a,Integer.parseInt(numJobs.getText()),email.getText(),phoneNum.getText());
			System.out.println(c.toString());
			Data.updateCustomerList(c);
			System.out.println("Customer added");
		}
		else {
			String ref = null;
			
			if(Data.findAd(refrence.getSelectionModel().getSelectedItem())!=null) {
				ref=Data.findAd(refrence.getSelectionModel().getSelectedItem()).getName();
				Ad ad = Data.findAd(refrence.getSelectionModel().getSelectedItem());
				ad.updateAdUse();
				Data.replace(ad, ad);
			}
			else {
				ref=Data.findCustomer(refrence.getSelectionModel().getSelectedItem()).getName();
			}

			
			System.out.println(phoneNum.getText());
			
			Customer c = new Customer(ref,name.getText(),a,Integer.parseInt(numJobs.getText()),email.getText(),phoneNum.getText());
			System.out.println(c.toString());
			Data.updateCustomerList(c);
			System.out.println("Customer added");
		}
		

		try {
			System.out.println("Updating file");
			Data.updateDataFile();
			cancel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cancel() {
		Stage stage = (Stage)name.getScene().getWindow();
		stage.close();
	}

}
