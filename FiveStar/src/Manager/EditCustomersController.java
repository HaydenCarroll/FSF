package Manager;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EditCustomersController {
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
	
	Stage editCustomersStage = new Stage();
	
	private static String oName;
	private static String oNumJobs;
	private static String oStreet;
	private static String oCity;
	private static String oState;
	private static String oZip;
	private static String oEmail;
	private static String oPhoneNum;
	private static String oRefrence;
	private static Customer oCust;
	
	static {
		oCust=new Customer();
		oName="";
		oNumJobs="";
		oStreet="";
		oCity="";
		oState="";
		oZip="";
		oEmail="";
		oPhoneNum="";
		oRefrence="";
	}
	public EditCustomersController() {
		
	}
	public void editCustomer() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("EditCustomers.fxml"));
			Scene scene = new Scene(root,600,300);
			editCustomersStage.setTitle("Edit Customer");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			editCustomersStage.setScene(scene);
			editCustomersStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendData(Customer c) {
		Address a = c.getAddress();
		oName=c.getName();
		oNumJobs=Integer.toString(c.getNumOfJobs());
		oStreet=a.getStreet();
		oCity=a.getCity();
		oState=a.getState();
		oZip=Integer.toString(a.getZipcode());
		oEmail=c.getEmail();
		oPhoneNum=c.getPhone();
		oRefrence=c.getRefrence();
	}
	
	public void initalize() {
		
	}
	public void refresh() {
		if(isRefreshed==false) {
			refrence.setItems(Data.getRefrences());
			isRefreshed=true;
			name.setText(oName);
			numJobs.setText(oNumJobs);
			street.setText(oStreet);
			city.setText(oCity);
			state.setText(oState);
			zip.setText(oZip);
			email.setText(oEmail);
			phoneNum.setText(oPhoneNum);
			refrence.setValue(oRefrence);
		}
		
	}
	public void enter() {
		Address a = new Address(street.getText(),city.getText(),state.getText(),Integer.parseInt(zip.getText()));
		if (refrence.getSelectionModel().isEmpty()) {
			
			System.out.println(phoneNum.getText());
			
			Customer c = new Customer(name.getText(),a,Integer.parseInt(numJobs.getText()),email.getText(),phoneNum.getText());
			System.out.println(c.toString());
			Data.replace(oCust, c);
			System.out.println("Customer added");
		}
		else {
			String ref = null;
			
			if(Data.findAd(refrence.getSelectionModel().getSelectedItem())!=null) {
				ref=Data.findAd(refrence.getSelectionModel().getSelectedItem()).getName();
			}
			else {
				ref=Data.findCustomer(refrence.getSelectionModel().getSelectedItem()).getName();
			}

			
			System.out.println(phoneNum.getText());
			
			Customer c = new Customer(ref,name.getText(),a,Integer.parseInt(numJobs.getText()),email.getText(),phoneNum.getText());
			System.out.println(c.toString());
			Data.replace(oCust, c);
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
