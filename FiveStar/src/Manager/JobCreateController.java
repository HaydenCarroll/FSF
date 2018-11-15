package Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class JobCreateController{
	public MenuItem ref;
	public ComboBox<Ad> adSelector;
	public ComboBox<Crew> crewSelector;
	public ListView<String> materialSelector;
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
	private static ArrayList<String> matMatch;
	private static ArrayList<Integer> matAmount;
	private static ArrayList<Material> materials;
	//list of selected materials
	protected static ArrayList<String> sMaterialArray;
	public ListView<String> materialSelected;
	public final ObservableList<String> oMatList = Data.getMaterialStringList();
	public Button cancel;
	//variables for select screen
	public Button enter;
	public TextField amount;
	public boolean isRefreshed=false;
	
	public static String selected;
	
	
	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		JobCreateController.selected = selected;
	}

	Stage selectStage = new Stage();
	Stage jobStage = new Stage();
	
	
	public JobCreateController() {
		
		
		

	}
	
	static {
		selected="";
		matMatch = new ArrayList<String>();
		matAmount = new ArrayList<Integer>();
		materials = new ArrayList<Material>();
		sMaterialArray = new ArrayList<String>();
	}
	
	public void initalize() {
		materialSelector.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		materialSelector.setItems(Data.getMaterialStringList());
		
	}
	public void newJob() {
		try {
			
			
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("JobCreate.fxml"));
			Scene scene = new Scene(root,800,400);
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
		System.out.println(sMaterialArray.size());
		ArrayList<Material> material = new ArrayList<Material>();
		for (int i=0;i<sMaterialArray.size();i++) {
			String m = sMaterialArray.get(i);
			Scanner in = new Scanner(m);
			m=in.next();
			in.close();
			System.out.println("finding "+m);
			
			Material mat = Data.findMaterial(m);
			if(mat!=null) {
				System.out.println("adding "+mat.getName());
				material.add(mat);
			}
			
		}
		match(material);
		Customer cust = customerSelector.getValue();
		Job job = new Job(ad,crew,material,matAmount,Double.parseDouble(quote.getText()),Double.parseDouble(footage.getText()),address,Double.parseDouble(laborCost.getText()),date.getValue(), cust, jobName.getText());
		Data.updateJobList(job);
		try {
			Data.updateDataFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clearMem();
	}
	
	public void match(ArrayList<Material> material) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<matMatch.size();i++) {
			Scanner in = new Scanner(matMatch.get(i));
			String mat=in.nextLine();
			int amnt = Integer.parseInt(in.nextLine());
			in.close();
			for(int j=0;j<material.size();j++) {
				if(mat.equals(material.get(j).getName())) {
					list.add(amnt);
					System.out.println(material.get(j).getName()+" = "+amnt);
				}
			}
		}
		matAmount=list;
	}
	
	public void selectAmount() {
		setSelected(materialSelector.getFocusModel().getFocusedItem());
		System.out.println("Selected= "+JobCreateController.selected);
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AmountSelector.fxml"));
			Scene scene = new Scene(root,250,150);
			selectStage.setTitle("Select Amount");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			selectStage.setScene(scene);
			selectStage.show();
			System.out.println("got to 1");
			setSelected(materialSelector.getFocusModel().getFocusedItem());
			System.out.println("Selected= "+JobCreateController.selected);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("got to 2");
		}
		
		
		
	}
	
	public void selectEnter() {
		System.out.println("Selected = "+getSelected());
		JobCreateController.matMatch.add(getSelected()+"\n"+amount.getText().trim());
		System.out.println("Adding "+amount.getText().trim()+" "+JobCreateController.selected);

		JobCreateController.sMaterialArray.add(getSelected()+" - "+amount.getText().trim());
		System.out.println("Added "+JobCreateController.selected);
		
		Stage stage = (Stage) enter.getScene().getWindow();
		stage.close();
		setSelected("");
	}
	
	public void cancel() {
		selected="";
		Stage stage = (Stage) cancel.getScene().getWindow();
		stage.close();
		clearMem();
		
	}
	
	public void remove() {
		String remove = materialSelected.getFocusModel().getFocusedItem();
		for(int i=0;i<sMaterialArray.size();i++) {
			if(sMaterialArray.get(i).equals(remove)) {
				sMaterialArray.remove(i);
			}
		}

		refresh();
		
	}
	
	public void refresh() {
		//if(!this.isRefreshed) {

			materialSelector.setItems(this.oMatList);
			ObservableList<String> oList= FXCollections.observableArrayList();
			oList.addAll(sMaterialArray);
			materialSelected.setItems(oList);
			this.isRefreshed=true;
	//	}
		System.out.println("klsadjf");

	}
	
	public void clearMem() {
		selected="";
		matMatch = new ArrayList<String>();
		matAmount = new ArrayList<Integer>();
		materials = new ArrayList<Material>();
		sMaterialArray = new ArrayList<String>();
	
		
	}


	

}
