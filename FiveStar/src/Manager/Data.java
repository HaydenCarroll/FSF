package Manager;

import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;

//(Jimmy) Data contains the objects created by other classes.
//they need to be in linked and array lists which you can determine base on how often the list is updated
//this class is also responsible for reading and writing the files that will be saved on the client computer
//make sure to use generics to make sure that the lists can't be accessed in an improper manner
//this class will also do the calculations and other math operations, but we can talk more on what all that will be later.

public class Data implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private static ArrayList<Job> jobList;
	private static ArrayList<Customer> customerList;
	private static ArrayList<Crew> crewList;
	private static ArrayList<Address> addressList;
	private static ArrayList<Ad> adList;
	private static ArrayList<Material> materialList;
	private static ArrayList<Goal> goalList;
	private static Object temp;
	
	public Data() {
		Data.jobList = new ArrayList<Job>();
		Data.customerList = new ArrayList<Customer>();
		Data.crewList = new ArrayList<Crew>();
		Data.addressList = new ArrayList<Address>();
		Data.adList = new ArrayList<Ad>();
		Data.materialList = new ArrayList<Material>();
		Data.goalList = new ArrayList<Goal>();
		goalList.clear();
		jobList.clear();
		customerList.clear();
		crewList.clear();
		adList.clear();
		materialList.clear();
		
	}
	public Data(ArrayList<Job> jobList, ArrayList<Customer> customerList, ArrayList<Crew> crewList, ArrayList<Address> addressList, ArrayList<Ad> adList, ArrayList<Material> materialList) {
		Data.jobList = jobList;
		Data.customerList = customerList;
		Data.crewList = crewList;
		Data.addressList = addressList;
		Data.adList = adList;
		Data.materialList = materialList;
	}
	
	
	public static void setJobList(ArrayList<Job> jobList) {
		Data.jobList=jobList;
	}
	
	public static void setCustomerList(ArrayList<Customer> customerList) {
		Data.customerList=customerList;
	}
	
	public static void setCrewList(ArrayList<Crew> crewList) {
		Data.crewList=crewList;
	}
	
	public static void setAddressList(ArrayList<Address> addressList) {
		Data.addressList=addressList;
	}
	
	public static void setAdList(ArrayList<Ad> adList) {
		Data.adList=adList;
	}
	
	public static void setMaterialList(ArrayList<Material> materialList) {
		Data.materialList=materialList;
	}
	
	@SuppressWarnings("static-access")
	static void initalizeData() {
		try {
			System.out.println("Initalizing");
			File file = new File("data.dat");
			
			
			FileInputStream jobFile = new FileInputStream("job.dat");
			FileInputStream custFile = new FileInputStream("cust.dat");
			FileInputStream crewFile = new FileInputStream("crew.dat");
			FileInputStream addressFile = new FileInputStream("address.dat");
			FileInputStream adFile = new FileInputStream("ad.dat");
			FileInputStream matFile = new FileInputStream("mat.dat");
			FileInputStream goalFile = new FileInputStream("goal.dat");
			
			
			ObjectInputStream inGoal = new ObjectInputStream(goalFile);
			ObjectInputStream inJob = new ObjectInputStream(jobFile);
			ObjectInputStream inCust = new ObjectInputStream(custFile);
			ObjectInputStream inCrew = new ObjectInputStream(crewFile);
			ObjectInputStream inAddress = new ObjectInputStream(addressFile);
			ObjectInputStream inAd = new ObjectInputStream(adFile);
			ObjectInputStream inMat = new ObjectInputStream(matFile);
			
			FileInputStream dataFile = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(dataFile);
	//		Data data = (Data) in.readObject();
			ArrayList<Job> jobList= (ArrayList<Job>) inJob.readObject();
			ArrayList<Customer> custList= (ArrayList<Customer>) inCust.readObject();
			ArrayList<Crew> crewList= (ArrayList<Crew>) inCrew.readObject();
			ArrayList<Address> addressList= (ArrayList<Address>) inAddress.readObject();
			ArrayList<Ad> adList= (ArrayList<Ad>) inAd.readObject();
			ArrayList<Material> matList= (ArrayList<Material>) inMat.readObject();
			ArrayList<Goal> goalList = (ArrayList<Goal>) inGoal.readObject();
			
			
			Data.setAddressList(addressList);
			Data.setAdList(adList);
			Data.setCrewList(crewList);
			Data.setCustomerList(custList);
			Data.setMaterialList(matList);
			Data.setJobList(jobList);
			Data.setGoalList(goalList);
			in.close();
			inJob.close();
			inCust.close();
			inCrew.close();
			inAddress.close();
			inAd.close();
			inMat.close();
			dataFile.close();
			inGoal.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//not used
	/*private Data getData() {
		Data data = new Data();
		try {
			FileInputStream in = new FileInputStream("data.dat");
			ObjectInputStream oIn = new ObjectInputStream(in);
			oIn.close();
			data= (Data) oIn.readObject();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}*/
	public static void createDataFile() throws IOException{
		try {
				File file = new File("data.dat");
				/*File jobFile = new File("job.dat");
				File custFile = new File("job.dat");
				File crewFile = new File("job.dat");
				File addressFile = new File("job.dat");
				File adFile = new File("job.dat");
				File matFile = new File("job.dat");*/
				FileOutputStream dataFile = new FileOutputStream(file);
				FileOutputStream jobFile = new FileOutputStream("job.dat");
				FileOutputStream custFile = new FileOutputStream("cust.dat");
				FileOutputStream crewFile = new FileOutputStream("crew.dat");
				FileOutputStream addressFile = new FileOutputStream("address.dat");
				FileOutputStream adFile = new FileOutputStream("ad.dat");
				FileOutputStream matFile = new FileOutputStream("mat.dat");
				FileOutputStream goalFile = new FileOutputStream("goal.dat");
				Data data = new Data();
				
				ObjectOutputStream outGoal = new ObjectOutputStream(goalFile);
				ObjectOutputStream out = new ObjectOutputStream(dataFile);
				ObjectOutputStream outJob = new ObjectOutputStream(jobFile);
				ObjectOutputStream outCust = new ObjectOutputStream(custFile);
				ObjectOutputStream outCrew = new ObjectOutputStream(crewFile);
				ObjectOutputStream outAddress = new ObjectOutputStream(addressFile);
				ObjectOutputStream outAd = new ObjectOutputStream(adFile);
				ObjectOutputStream outMat = new ObjectOutputStream(matFile);
				outJob.writeObject(data.getJobList());
				outCust.writeObject(data.getCustomerList());
				outCrew.writeObject(data.getCrewList());
				outAddress.writeObject(data.getAddressList());
				outAd.writeObject(data.getAdList());
				outMat.writeObject(data.getMaterialList());
				out.writeObject(data);
				outGoal.writeObject(data.getGoalList());
				
				outJob.close();
				outCust.close();
				outCrew.close();
				outAddress.close();
				outAd.close();
				outMat.close();
				out.close();
				dataFile.close();
				outGoal.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void updateDataFile() throws IOException{
		try {
			File file = new File("data.dat");
			FileOutputStream goalFile = new FileOutputStream("goal.dat");
			FileOutputStream dataFile = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(dataFile);
			FileOutputStream jobFile = new FileOutputStream("job.dat");
			FileOutputStream custFile = new FileOutputStream("cust.dat");
			FileOutputStream crewFile = new FileOutputStream("crew.dat");
			FileOutputStream addressFile = new FileOutputStream("address.dat");
			FileOutputStream adFile = new FileOutputStream("ad.dat");
			FileOutputStream matFile = new FileOutputStream("mat.dat");
			
			
			ObjectOutputStream outGoal = new ObjectOutputStream(goalFile);
			ObjectOutputStream outJob = new ObjectOutputStream(jobFile);
			ObjectOutputStream outCust = new ObjectOutputStream(custFile);
			ObjectOutputStream outCrew = new ObjectOutputStream(crewFile);
			ObjectOutputStream outAddress = new ObjectOutputStream(addressFile);
			ObjectOutputStream outAd = new ObjectOutputStream(adFile);
			ObjectOutputStream outMat = new ObjectOutputStream(matFile);
			outJob.writeObject(Data.getJobList());
			outCust.writeObject(Data.getCustomerList());
			outCrew.writeObject(Data.getCrewList());
			outAddress.writeObject(Data.getAddressList());
			outAd.writeObject(Data.getAdList());
			outMat.writeObject(Data.getMaterialList());
			outGoal.writeObject(Data.getGoalList());
			
			Data data = new Data(Data.getJobList(),Data.getCustomerList(),Data.getCrewList(),Data.getAddressList(),Data.getAdList(),Data.getMaterialList());
			
			out.writeObject(data);
			out.close();
			dataFile.close();
			outGoal.close();
			outJob.close();
			outCust.close();
			outCrew.close();
			outAddress.close();
			outAd.close();
			outMat.close();
			System.out.println("File updated");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//for testing purposes
	/*public static void testFile() {
		try {
			FileInputStream dataFile = new FileInputStream("data.dat");
			Ad test = new Ad();
			updateAdList(test);
			updateDataFile();
			ObjectInputStream input = new ObjectInputStream(dataFile);
			Data testData = (Data)input.readObject();
			System.out.println(testData.getAdList().get(0).getName());
			input.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
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
		return Data.materialList;
	}

	public static void updateMaterialList(Material material) {
		materialList.add(material);
	}
	
	
	public static int getNextJobID() {
		if(jobList.isEmpty()||jobList.equals(null)) {
			return 0;
		}
		return jobList.size()-1;
	}
	
	public static int getNextCustomerID() {
		if(customerList.isEmpty()||customerList.equals(null)) {
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
		if(materialList.isEmpty()||materialList.equals(null)) {
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
	
	public static ArrayList<Job> getJobByDate(LocalDate start, LocalDate end){
		
		ArrayList<Job> jobListByDate=new ArrayList<Job>();
		
		for(int i=0;i<jobList.size();i++) {
			if (jobList.get(i).getDateCompleted()!=null && jobList.get(i).getDateCompleted().isBefore(end)) {
				jobListByDate.add(jobList.get(i));
			}
		}
		return jobListByDate;
	}
	
	public static double getTotalRev(ArrayList<Job> list) {
		double num =0;
		for(int i=0; i<list.size();i++) {
			num+=list.get(i).getProfit();
		}
		return num;
	}
	public static ArrayList<Goal> getGoalList() {
		return goalList;
	}
	public static void setGoalList(ArrayList<Goal> goalList) {
		Data.goalList = goalList;
	}
	public static void updateGoalList(Goal goal) {
		goalList.add(goal);
	}
	
	public static ObservableList<String> getMaterialStringList(){
		ArrayList<String> list = new ArrayList<String>();
		for (int i=0;i<Data.getMaterialList().size();i++) {
			System.out.println(Data.getMaterialList().get(i).getName());
			list.add(Data.getMaterialList().get(i).getName());
		}
		ObservableList<String> sList = FXCollections.observableArrayList();
		sList.addAll(list);
		return sList;
	}
	public static Material findMaterial(String s) {
		Material mat = null;
		for (int i=0;i<Data.getMaterialList().size();i++) {
			Material m = Data.getMaterialList().get(i);
			if(m.getName().equals(s)) {
				System.out.println("Found "+m.getName());
				mat=m;
			}
		}
		return mat;
	}
	public static Object getTemp() {
		return temp;
	}
	public static void setTemp(Object temp) {
		Data.temp = temp;
	}
	public static void clear() {
		Data.temp=null;
	}
	

}
