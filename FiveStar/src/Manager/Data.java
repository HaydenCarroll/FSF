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
	
	public static Ad getMostSeenAd(ArrayList<Ad> ads) {
		int maxUses = ads.get(0).getNumberOfUses();
		Ad bestAd = ads.get(0);
		for(int i = 1; i < ads.size(); i++) {
			if( ads.get(i).getNumberOfUses() > maxUses) {
				maxUses = ads.get(i).getNumberOfUses();
				bestAd = ads.get(i);
			}
		}
		return bestAd;
	}
	
	public static Ad getMostValueAd(ArrayList<Ad> ads) {
		Ad bestAd = ads.get(0);
		double value = ads.get(0).getNumberOfUses() / ads.get(0).getAdCost();
		for(int i = 1; i < ads.size(); i++) {
			if (ads.get(i).getNumberOfUses() / ads.get(i).getAdCost() > value) {
				value = ads.get(i).getNumberOfUses() / ads.get(i).getAdCost();
				bestAd = ads.get(i);
			}
		}
		return bestAd;
	}
	
	public static Ad getMostSoldAd(ArrayList<Ad> ads) {
		Ad bestAd = ads.get(0);
		double value = ads.get(0).getAmtSold() / ads.get(0).getAdCost();
		for (int i = 1; i < ads.size(); i++) {
			if (ads.get(i).getAmtSold() / ads.get(i).getAdCost() > value) {
				value = ads.get(i).getAmtSold() / ads.get(i).getAdCost();
				bestAd = ads.get(i);
			}
		}
		return bestAd;
	}
		
	public static Ad getLeastSeenAd(ArrayList<Ad> ads) {
		int minUses = ads.get(0).getNumberOfUses();
		Ad worstAd = ads.get(0);
		for(int i = 1; i < ads.size(); i++) {
			if( ads.get(i).getNumberOfUses() < minUses) {
				minUses = ads.get(i).getNumberOfUses();
				worstAd = ads.get(i);
			}
		}
		return worstAd;
	}
	
	public static Ad getLeastValueAd(ArrayList<Ad> ads) {
		Ad worstAd = ads.get(0);
		double value = ads.get(0).getNumberOfUses() / ads.get(0).getAdCost();
		for(int i = 1; i < ads.size(); i++) {
			if (ads.get(i).getNumberOfUses() / ads.get(i).getAdCost() > value) {
				value = ads.get(i).getNumberOfUses() / ads.get(i).getAdCost();
				worstAd = ads.get(i);
			}
		}
		return worstAd;
	}
	
	public static Ad getLeastSoldAd(ArrayList<Ad> ads) {
		Ad worstAd = ads.get(0);
		double value = ads.get(0).getAmtSold() / ads.get(0).getAdCost();
		for (int i = 1; i < ads.size(); i++) {
			if (ads.get(i).getAmtSold() / ads.get(i).getAdCost() > value) {
				value = ads.get(i).getAmtSold() / ads.get(i).getAdCost();
				worstAd = ads.get(i);
			}
		}
		return worstAd;
	}
	
	public static Job getMostlaborJob(ArrayList<Job> jobs) {
		Job mostLabor = jobs.get(0);
		double maxLabor = jobs.get(0).getLaborCost();
		for (int i = 1; i < jobs.size(); i++) {
			if (jobs.get(i).getLaborCost() > maxLabor) {
				mostLabor = jobs.get(i);
				maxLabor = jobs.get(i).getLaborCost();
			}
		}
		return mostLabor;
	}
	
	public static Job getMinlaborJob(ArrayList<Job> jobs) {
		Job leastLabor = jobs.get(0);
		double minLabor = jobs.get(0).getLaborCost();
		for (int i = 1; i < jobs.size(); i++) {
			if (jobs.get(i).getLaborCost() > minLabor) {
				leastLabor = jobs.get(i);
				minLabor = jobs.get(i).getLaborCost();
			}
		}
		return leastLabor;
	}

}
