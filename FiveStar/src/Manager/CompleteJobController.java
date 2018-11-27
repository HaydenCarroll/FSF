package Manager;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CompleteJobController {
	
	//Ive cloned the job create controller now I just need to adapt it to edit jobs
	
	public MenuItem ref;
	public ChoiceBox<String> adSelector;
	public ChoiceBox<String> crewSelector;
	public ListView<String> materialSelector;
	public ChoiceBox<String> customerSelector;
	public TextField quote;
	public TextField footage;
	public TextField street;
	public TextField city;
	public TextField state;
	public TextField zipCode;
	public DatePicker date;
	public TextField laborCost;
	public TextField jobName;
	public TextField fenceStyle;
	
	public TextField matCost;
	public TextField amntCharged;
	public DatePicker endDate;
	public CheckBox repair;
	
	private static ArrayList<String> matMatch;
	private static ArrayList<Integer> matAmount;
	private static ArrayList<Material> materials;
	//list of selected materials
	protected static ArrayList<String> sMaterialArray;
	public ListView<String> materialSelected;
	public final ObservableList<String> oMatList = Data.getMaterialStringList();
	public final ObservableList<String> oAdList =Data.getAdObservableListString();
	public final ObservableList<String> oCrewList = Data.getCrewObservableListString();
	public final ObservableList<String> oCustList = Data.getCustomerObservableListString();
	
	private static double oQuote;
	private static double oFootage;
	private static String oStreet;
	private static String oCity;
	private static String oState;
	private static int oZipCode;
	private static LocalDate oDate;
	private static double oLaborCost;
	private static String oJobName;
	private static String oFenceStyle;
	private static Crew oCrew;
	private static Ad oAd;
	private static Customer oCust;
	private static Job oJob;
	private static Job nJob;
	private boolean isInitalized = false;
	private static String oMatCost;
	private static String oAmntCharged;
	private static LocalDate oEndDate;
	private static boolean oIsRepair;
	
	
	public Button cancel;
	//variables for select screen
	public Button enter;
	public TextField amount;
	public boolean isFilled=false;
	
	public static String selected;
	
	
	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		JobCreateController.selected = selected;
	}
	
	Stage selectStage = new Stage();
	
	Stage jobEditStage = new Stage();
	
	public CompleteJobController() {
		
		
		
	}
	
	static {
		selected="";
		matMatch = new ArrayList<String>();
		matAmount = new ArrayList<Integer>();
		materials = new ArrayList<Material>();
		sMaterialArray = new ArrayList<String>();
		oQuote=-1;
		oFootage=-1;
		oStreet="";
		oCity="";
		oState="";
		oZipCode=-1;
		oDate=LocalDate.now();
		oLaborCost=-1;
		oJobName="";
		oFenceStyle="";
		oJob=new Job();
		oCrew=new Crew();
		oAd=new Ad();
		oCust=new Customer();
		nJob=new Job();
		oMatCost="";
		oAmntCharged="";
		oEndDate=LocalDate.now();
		oIsRepair=false;
	}
	
	
	public void editJob() {
		try {
			
			
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("CompleteJob.fxml"));
			Scene scene = new Scene(root,800,400);
			jobEditStage.setTitle("Complete Job");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			jobEditStage.setScene(scene);
			
			jobEditStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dateEnter() {
		oDate = date.getValue();
	}
	
	public void enter() {
		Address address = new Address(street.getText(),city.getText(),state.getText(),Integer.parseInt(zipCode.getText()));
		Ad ad = Data.findAd(adSelector.getValue());
		Crew crew = Data.findCrew(crewSelector.getValue());
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
		Customer cust = Data.findCustomer(customerSelector.getValue());
		nJob.setJobID(oJob.getJobID());
		nJob.setCompletedJob(ad,crew,material,matAmount,Double.parseDouble(quote.getText()),
				Double.parseDouble(footage.getText()),address,Double.parseDouble(laborCost.getText()),date.getValue(), cust, jobName.getText(),fenceStyle.getText()
				,endDate.getValue(),Double.parseDouble(matCost.getText()),Double.parseDouble(amntCharged.getText()),repair.isSelected())  ;
		nJob.endJob(endDate.getValue(),Double.parseDouble(laborCost.getText()),Double.parseDouble(matCost.getText()),Double.parseDouble(amntCharged.getText()));
		Data.replace(oJob, nJob);
		cancel();
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
		CompleteJobController.matMatch.add(getSelected()+"\n"+amount.getText().trim());
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
	
	public void initalize() {
		materialSelector.setItems(this.oMatList);
		ObservableList<String> oList= FXCollections.observableArrayList();
		oList.setAll(sMaterialArray);
		materialSelected.setItems(oList);	
		adSelector.setItems(this.oAdList);
		crewSelector.setItems(this.oCrewList);
		customerSelector.setItems(this.oCustList);
		adSelector.setValue(oAd.getName());
		crewSelector.setValue(oCrew.getName());
		customerSelector.setValue(oCust.getName());
		quote.setText(Double.toString(oQuote));
		footage.setText(Double.toString(oFootage));
		street.setText(oStreet);
		city.setText(oCity);
		state.setText(oState);
		zipCode.setText(Integer.toString(oZipCode));
		date.setValue(oDate);
		laborCost.setText(Double.toString(oLaborCost));
		jobName.setText(oJobName);
		fenceStyle.setText(oFenceStyle);
		matCost.setText(oMatCost);
		amntCharged.setText(oAmntCharged);
		endDate.setValue(oEndDate);
		if(oIsRepair) {
			repair.setSelected(true);
		}
		
		isInitalized=true;
	}
	
	public void refresh() {
		if(isInitalized == false) {
			initalize();
		}
		else {
			materialSelector.setItems(this.oMatList);
			ObservableList<String> oList= FXCollections.observableArrayList();
			oList.addAll(sMaterialArray);
			materialSelected.setItems(oList);	
			adSelector.setItems(this.oAdList);
			crewSelector.setItems(this.oCrewList);
			customerSelector.setItems(this.oCustList);
			if(!oCust.getName().equals(customerSelector.getValue())) {
				try{
					autoFill();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	
	
	public void clearMem() {
		selected="";
		matMatch = new ArrayList<String>();
		matAmount = new ArrayList<Integer>();
		materials = new ArrayList<Material>();
		sMaterialArray = new ArrayList<String>();
		oQuote=-1;
		oFootage=-1;
		oStreet="";
		oCity="";
		oState="";
		oZipCode=-1;
		oDate=LocalDate.MIN;
		oLaborCost=-1;
		oJobName="";
		oFenceStyle="";
		oJob=new Job();
		oCrew=new Crew();
		oAd=new Ad();
		oCust=new Customer();
		nJob=new Job();
		oMatCost="";
		oAmntCharged="";
		oEndDate=LocalDate.MIN;
		oIsRepair=false;
	}
	public void autoFill() {
		if(customerSelector.getSelectionModel().getSelectedItem()!=null&&this.isFilled==false) {
			String name =customerSelector.getSelectionModel().getSelectedItem();
			Customer c = Data.findCustomer(name);
			Address a = c.getAddress();
			this.state.setText(a.getState());
			this.street.setText(a.getStreet());
			this.zipCode.setText(a.getZipcode()+"");
			this.city.setText(a.getCity());
			this.isFilled=true;
		}
		
		
	}
	
	public void sendInfo(Job job) {
		ArrayList<Material> l = job.getMatList();
		ArrayList<Integer> amnt = job.getMatUnit();
		sMaterialArray=toSMaterialArray(l,amnt);
		matMatch=toMatMatch(l,amnt);
		Address a = job.getAddress();
		oJob=job;
		oQuote=job.getQuote();
		oFootage=job.getFootage();
		oStreet=a.getStreet();
		oCity=a.getCity();
		oState=a.getState();
		oZipCode=a.getZipcode();
		oDate=job.getDate();
		oLaborCost=job.getLaborCost();
		oJobName=job.getName();
		oFenceStyle=job.getFenceName();
		oCrew=job.getCrew();
		oAd=job.getAd();
		oCust=job.getCustomer();
		oMatCost=Double.toString(job.getTotalMatCost());
		
		
		oIsRepair=job.isRepair();
		
		
		
	}
	public ArrayList<String> toSMaterialArray(ArrayList<Material> l, ArrayList<Integer> amnt) {
		
		ArrayList<String> n = new ArrayList<String>();
		for(int i=0;i<l.size();i++) {
			n.add(l.get(i).getName()+" - "+amnt.get(i));
		}
		return n;
	}
	public ArrayList<String> toMatMatch(ArrayList<Material> l, ArrayList<Integer> amnt){
		ArrayList<String> n = new ArrayList<String>();
		for(int i=0;i<l.size();i++) {
			n.add(l.get(i).getName()+"\n"+amnt.get(i));
		}
		return n;
	}

}
