package Manager;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//(Jimmy) Data contains the objects created by other classes.
//they need to be in linked and array lists which you can determine base on how often the list is updated
//this class is also responsible for reading and writing the files that will be saved on the client computer
//make sure to use generics to make sure that the lists can't be accessed in an improper manner
//this class will also do the calculations and other math operations, but we can talk more on what all that will be later.

public class Data {
	private static ArrayList<Job> jobList;
	private static ArrayList<Customer> customerList;
	private static ArrayList<Crew> crewList;
	private static ArrayList<Address> addressList;
	private static ArrayList<Ad> adList;
	private static ArrayList<Material> materialList;
	
	public static ObservableList<Job> getJobObservableList(){
		ObservableList<Job> jobList = FXCollections.observableArrayList();
		jobList.addAll(Data.getJobList());
		return jobList;
	}
	
	public static ObservableList<Customer> getCustomerObservableList(){
		ObservableList<Customer> customerList = FXCollections.observableArrayList();
		customerList.addAll(Data.getCustomerList());
		return customerList;
	}
	
	public static ObservableList<Crew> getCrewObservableList(){
		ObservableList<Crew> crewList = FXCollections.observableArrayList();
		crewList.addAll(Data.getCrewList());
		return crewList;
	}
	
	public static ObservableList<Material> getMaterialObservableList(){
		ObservableList<Material> materialList = FXCollections.observableArrayList();
		materialList.addAll(Data.getMaterialList());
		return materialList;
	}
	
	public static ArrayList<Job> getJobList() {
		return jobList;
	}

	public static void updateJobList(Job job) {
		jobList.add(job);
	}
	

	public static ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public static void updateCustomerList(Customer customer) {
		customerList.add(customer);
	}
	

	public static ArrayList<Crew> getCrewList() {
		return crewList;
	}

	public static void updateCrewList(Crew crew) {
		crewList.add(crew);
	}
	

	public static ArrayList<Address> getAddressList() {
		return addressList;
	}

	public static void updateAddressList(Address address) {
		addressList.add(address);
	}
	

	public static ArrayList<Ad> getAdList() {
		return adList;
	}

	public static void updateAdList(Ad ad) {
		adList.add(ad);
	}
	

	public static ArrayList<Material> getMaterialList() {
		return materialList;
	}

	public static void updateMaterialList(Material material) {
		materialList.add(material);
	}
	
	
	public static int getNextJobID() {
		if(jobList.isEmpty()) {
			return 0;
		}
		return jobList.size()-1;
	}
	
	public static int getNextCustomerID() {
		if(customerList.isEmpty()) {
			return 0;
		} else {
		return customerList.size()-1;
		}
	}
	
	public static int getNextCrewID() {
		if(crewList.isEmpty()) {
			return 0;
		}
		return crewList.size()-1;
	}
	
	public static int getNextAddressID() {
		if(addressList.isEmpty()){
			return 0;
		}
		return addressList.size()-1;
	}
	
	public static int getNextAdID() {
		if(adList.isEmpty()) {
			return 0;
		}
		return adList.size()-1;
	}
	
	public static int getNextMaterialID() {
		if(materialList.isEmpty()) {
			return 0;
		}
		return materialList.size()-1;
	}

}
