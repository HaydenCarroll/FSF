package Manager;

import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;

//(Jimmy) Data contains the objects created by other classes.
//they need to be in linked and array lists which you can determine base on how often the list is updated
//this class is also responsible for reading and writing the files that will be saved on the client computer
//make sure to use generics to make sure that the lists can't be accessed in an improper manner
//this class will also do the calculations and other math operations, but we can talk more on what all that will be later.

/**
 * @author Hayden, Jimmy
 *
 */
public class Data implements Serializable{
	
	private static final long serialVersionUID = 2L;
	private static ArrayList<Job> jobList;
	private static ArrayList<Customer> customerList;
	private static ArrayList<Crew> crewList;
	private static ArrayList<Address> addressList;
	private static ArrayList<Ad> adList;
	private static ArrayList<Material> materialList;
	private static ArrayList<Goal> goalList;
	private static Object temp;
	
	/**
	 * 
	 */
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
	/**
	 * @param jobList
	 * @param customerList
	 * @param crewList
	 * @param addressList
	 * @param adList
	 * @param materialList
	 */
	public Data(ArrayList<Job> jobList, ArrayList<Customer> customerList, ArrayList<Crew> crewList, ArrayList<Address> addressList, ArrayList<Ad> adList, ArrayList<Material> materialList) {
		Data.jobList = jobList;
		Data.customerList = customerList;
		Data.crewList = crewList;
		Data.addressList = addressList;
		Data.adList = adList;
		Data.materialList = materialList;
	}
	
	
	/**
	 * @param jobList
	 */
	public static void setJobList(ArrayList<Job> jobList) {
		Data.jobList=jobList;
	}
	
	/**
	 * @param customerList
	 */
	public static void setCustomerList(ArrayList<Customer> customerList) {
		Data.customerList=customerList;
	}
	
	/**
	 * @param crewList
	 */
	public static void setCrewList(ArrayList<Crew> crewList) {
		Data.crewList=crewList;
	}
	
	/**
	 * @param addressList
	 */
	public static void setAddressList(ArrayList<Address> addressList) {
		Data.addressList=addressList;
	}
	
	/**
	 * @param adList
	 */
	public static void setAdList(ArrayList<Ad> adList) {
		Data.adList=adList;
	}
	
	/**
	 * @param materialList
	 */
	public static void setMaterialList(ArrayList<Material> materialList) {
		Data.materialList=materialList;
	}
	
	/**
	 * 
	 */
	@SuppressWarnings({ "static-access", "unchecked" })
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

	/**
	 * @throws IOException
	 */
	public static void createDataFile() throws IOException{
		try {
				File file = new File("data.dat");

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
	/**
	 * @throws IOException
	 */
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

	
	/**
	 * @return
	 */
	public static ObservableList<Job> getJobObservableList(){
		ObservableList<Job> jobList = FXCollections.observableArrayList();
		jobList.addAll(Data.getJobList());
		return jobList;
	}
	
	/**
	 * @return
	 */
	public static ObservableList<Job> getCurrentJobObservableList(){
		ObservableList<Job> jobList = FXCollections.observableArrayList();
		jobList.addAll(Data.getJobList());
		for(int i=0;i<jobList.size();i++) {
			if(jobList.get(i).isCompleted()) {
				jobList.remove(i);
			}
		}
		return jobList;
	}
	
	/**
	 * @return
	 */
	public static ObservableList<Customer> getCustomerObservableList(){
		ObservableList<Customer> customerList = FXCollections.observableArrayList();
		customerList.addAll(Data.getCustomerList());
		return customerList;
	}
	
	/**
	 * @return
	 */
	public static ObservableList<Crew> getCrewObservableList(){
		ObservableList<Crew> crewList = FXCollections.observableArrayList();
		crewList.addAll(Data.getCrewList());
		return crewList;
	}
	
	/**
	 * @return
	 */
	public static ObservableList<Material> getMaterialObservableList(){
		ObservableList<Material> materialList = FXCollections.observableArrayList();
		materialList.addAll(Data.getMaterialList());
		return materialList;
	}
	
	/**
	 * @return
	 */
	public static ObservableList<Ad> getAdObservableList(){
		ObservableList<Ad> adList = FXCollections.observableArrayList();
		adList.addAll(Data.getAdList());
		return adList;
	}
	
	/**
	 * @return
	 */
	public static ArrayList<Job> getJobList() {
		return jobList;
	}

	/**
	 * @param job
	 */
	public static void updateJobList(Job job) {
		jobList.add(job);
	}
	

	

	/**
	 * @return
	 */
	public static ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	/**
	 * @param customer
	 */
	public static void updateCustomerList(Customer customer) {
		customerList.add(customer);
	}
	

	/**
	 * @return
	 */
	public static ArrayList<Crew> getCrewList() {
		return crewList;
	}

	/**
	 * @param crew
	 */
	public static void updateCrewList(Crew crew) {
		crewList.add(crew);
	}
	

	/**
	 * @return
	 */
	public static ArrayList<Address> getAddressList() {
		return addressList;
	}

	/**
	 * @param address
	 */
	public static void updateAddressList(Address address) {
		addressList.add(address);
	}
	

	/**
	 * @return
	 */
	public static ArrayList<Ad> getAdList() {
		return adList;
	}

	/**
	 * @param ad
	 */
	public static void updateAdList(Ad ad) {
		adList.add(ad);
	}
	

	/**
	 * @return
	 */
	public static ArrayList<Material> getMaterialList() {
		return Data.materialList;
	}

	/**
	 * @param material
	 */
	public static void updateMaterialList(Material material) {
		materialList.add(material);
	}
	
	
	/**
	 * @return
	 */
	public static int getNextJobID() {
		if(Data.getJobList().size()==0) {
			return 0;
		}
		return Data.getJobList().get(Data.getJobList().size()-1).getJobID()+1;
	}
	
	/**
	 * @return
	 */
	public static int getNextCustomerID() {
		if(Data.getCustomerList().isEmpty()) {
			return 0;
		} else {
		return Data.getCustomerList().size();
		}
	}
	
	/**
	 * @return
	 */
	public static int getNextCrewID() {
		if(Data.getCrewList().isEmpty()) {
			return 0;
		}
		return Data.getCrewList().size();
	}
	
	/**
	 * @return
	 */
	public static int getNextAddressID() {
		if(Data.getAddressList().isEmpty()){
			return 0;
		}
		return Data.getAddressList().size();
	}
	
	/**
	 * @return
	 */
	public static int getNextAdID() {
		if(Data.getAdList().isEmpty()) {
			return 0;
		}
		return Data.getAdList().size();
	}
	
	/**
	 * @return
	 */
	public static int getNextMaterialID() {
		if(Data.getMaterialList().isEmpty()) {
			return 0;
		}
		return Data.getMaterialList().size();
	}

	/**
	 * @param ads
	 * @return
	 */
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
	
	/**
	 * @param ads
	 * @return
	 */
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
	
	/**
	 * @param ads
	 * @return
	 */
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
	
	/**
	 * @param ad
	 * @return
	 */
	public static double getAdValue(Ad ad) {
		double value = 0;
		for(int i=0; i<jobList.size();i++) {
			if(jobList.get(i).getAd().getName().equals(ad.getName())) {
				value+=jobList.get(i).getProfit();
			}
		}
		return value;
	}
		
	/**
	 * @param ads
	 * @return
	 */
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
	
	/**
	 * @param ads
	 * @return
	 */
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
	
	/**
	 * @param ads
	 * @return
	 */
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
	
	/**
	 * @param jobs
	 * @return
	 */
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
	
	/**
	 * @param jobs
	 * @return
	 */
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
	
	/**
	 * @param start
	 * @param end
	 * @return
	 */
	public static ArrayList<Job> getJobByDate(LocalDate start, LocalDate end){
		
		ArrayList<Job> jobListByDate=new ArrayList<Job>();
		
		for(int i=0;i<jobList.size();i++) {
			if (jobList.get(i).getDateCompleted()!=null && jobList.get(i).getDateCompleted().isBefore(end)&& jobList.get(i).getDateCompleted().isAfter(start)) {
				jobListByDate.add(jobList.get(i));
			}
		}
		return jobListByDate;
	}
	
	/**
	 * @param list
	 * @return
	 */
	public static double getTotalRev(ArrayList<Job> list) {
		double num =0;
		for(int i=0; i<list.size();i++) {
			num+=list.get(i).getProfit();
		}
		return num;
	}
	
	/**
	 * @param list
	 * @return
	 */
	public static double getTotalSpend(ArrayList<Job> list) {
		double num =0;
		for(int i=0; i<list.size();i++) {
			num+=list.get(i).getLaborCost()+list.get(i).getTotalMatCost();
		}
		return num;
	}
	
	/**
	 * @param c
	 * @return
	 */
	public static ArrayList<Job> getJobListByCustomer(Customer c) {
		ArrayList<Job> list = new ArrayList<Job>();
		ArrayList<Job> jList = Data.getJobList();
		for(int i=0;i<jList.size();i++) {
			if(jList.get(i).getCustomer().getName().equals(c.getName())) {
				list.add(jList.get(i));
			}
		}
		return list;
	}
	
	/**
	 * @param c
	 * @return
	 */
	public static ArrayList<Job> getJobListByCrew(Crew c) {
		ArrayList<Job> list = new ArrayList<Job>();
		ArrayList<Job> jList = Data.getJobList();
		for(int i=0;i<jList.size();i++) {
			if(jList.get(i).getCrew().getName().equals(c.getName())) {
				list.add(jList.get(i));
			}
		}
		return list;
	}
	/**
	 * @param m
	 */
	public static void updateMaterial(Material m) {
		Material newM = m;
		ArrayList<Job> jList = Data.getJobList();
		double cost=m.getCostPU();
		double price=m.getPricePF();
		double amntUsed=0;
		double amntSold=0;
		double amntSpent=0;
		
		for(int i=0;i<jList.size();i++) {
			Job job = jList.get(i);
			ArrayList<Material> mList = job.getMatList();
			ArrayList<Integer> uList = job.getMatUnit();
			for(int j=0;j<mList.size();j++) {
				if(mList.get(j).getName().equals(newM.getName())) {
					amntUsed+=uList.get(j);
				}
			}
		}
		
		amntSpent=amntUsed*cost;
		amntSold=amntUsed*price;
		
		m.setTotalAmtSold(amntSold);
		m.setTotalFootage(amntUsed);
		m.setTotalAmtSpent(amntSpent);
		
		Data.replace(m, newM);
		
	}
	
	/**
	 * @param list
	 * @return
	 */
	public static Job getEarliestJob(ArrayList<Job> list) {
		if(list==null||list.size()<1) {
			return null;
		}
		Job j = list.get(0);
		for(int i=1; i<list.size();i++) {
			if(j.getDateCompleted().isAfter(list.get(i).getDateCompleted())) {
				j=list.get(i);
			}
		}
		return j;
	}
	
	/**
	 * @param list
	 * @return
	 */
	public static Job getLatestJob(ArrayList<Job> list) {
		if(list==null||list.size()<1) {
			return null;
		}
		Job j = list.get(0);
		for(int i=1; i<list.size();i++) {
			if(j.getDateCompleted().isBefore(list.get(i).getDateCompleted())) {
				j=list.get(i);
			}
		}
		return j;
	}
	
	
	/**
	 * @return
	 */
	public static ArrayList<Goal> getGoalList() {
		return goalList;
	}
	/**
	 * @param goalList
	 */
	public static void setGoalList(ArrayList<Goal> goalList) {
		Data.goalList = goalList;
	}
	/**
	 * @param goal
	 */
	public static void updateGoalList(Goal goal) {
		goalList.add(goal);
	}
	
	/**
	 * @return
	 */
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
	/**
	 * @param s
	 * @return
	 */
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
	/**
	 * @param s
	 * @return
	 */
	public static Address findCustomerAddress(String s) {
		Address a = null;
		for (int i=0;i<Data.getCustomerList().size();i++) {
			String name = Data.getCustomerList().get(i).getName();
			if(name.equals(s)) {
				a=Data.getCustomerList().get(i).getAddress();
			}
		}
		return a;
	}
	/**
	 * @param ad
	 * @return
	 */
	public static Ad findAd(String ad) {
		Ad a = null;
		for (int i=0;i<adList.size();i++) {
			if(adList.get(i).getName().equals(ad)) {
				a=adList.get(i);
			}
		}
		return a;
	}
	/**
	 * @param s
	 * @return
	 */
	public static Customer findCustomer(String s) {
		Customer c = null;
		for (int i=0;i<customerList.size();i++) {
			if(customerList.get(i).getName().equals(s)) {
				c=customerList.get(i);
			}
		}
		return c;
	}
	
	/**
	 * @param s
	 * @return
	 */
	public static Crew findCrew(String s) {
		Crew c=null;
		for(int i=0;i<crewList.size();i++) {
			if(crewList.get(i).getName().equals(s)) {
				c=crewList.get(i);
			}
		}
		return c;
	}
	/**
	 * @return
	 */
	public static ObservableList<String> getRefrences(){
		ObservableList<String> list = FXCollections.observableArrayList();
		for(int i=0; i<adList.size();i++) {
			list.add(adList.get(i).getName());
		}
		for(int i=0;i<customerList.size();i++) {
			list.add(customerList.get(i).getName());
		}
		return list;
	}
	
	/**
	 * @return
	 */
	public static ObservableList<String> getAdObservableListString(){
		ArrayList<String> sList = new ArrayList<String>();
		for (int i=0;i<Data.getAdList().size();i++) {
			System.out.println(Data.getAdList().get(i).getName());
			sList.add(Data.getAdList().get(i).getName());
		}
		ObservableList<String> list = FXCollections.observableArrayList();
		list.addAll(sList);
		return list;
	}
	/**
	 * @return
	 */
	public static ObservableList<String> getCrewObservableListString(){
		ArrayList<String> sList = new ArrayList<String>();
		for (int i=0;i<Data.getCrewList().size();i++) {
			System.out.println(Data.getCrewList().get(i).getName());
			sList.add(Data.getCrewList().get(i).getName());
		}
		ObservableList<String> list = FXCollections.observableArrayList();
		list.addAll(sList);
		return list;
	}
	/**
	 * @return
	 */
	public static ObservableList<String> getJobObservableListString(){
		ArrayList<String> sList = new ArrayList<String>();
		for (int i=0;i<Data.getJobList().size();i++) {
			System.out.println(Data.getJobList().get(i).getName());
			sList.add(Data.getJobList().get(i).getName());
		}
		ObservableList<String> list = FXCollections.observableArrayList();
		list.addAll(sList);
		return list;
	}
	/**
	 * @return
	 */
	public static ObservableList<String> getMaterialObservableListString(){
		ArrayList<String> sList = new ArrayList<String>();
		for (int i=0;i<Data.getMaterialList().size();i++) {
			System.out.println(Data.getMaterialList().get(i).getName());
			sList.add(Data.getMaterialList().get(i).getName());
		}
		ObservableList<String> list = FXCollections.observableArrayList();
		list.addAll(sList);
		return list;
	}
	/**
	 * @return
	 */
	public static ObservableList<String> getCustomerObservableListString(){
		ArrayList<String> sList = new ArrayList<String>();
		for (int i=0;i<Data.getCustomerList().size();i++) {
			System.out.println(Data.getCustomerList().get(i).getName()+"*****");
			sList.add(Data.getCustomerList().get(i).getName());
		}
		ObservableList<String> list = FXCollections.observableArrayList();
		list.addAll(sList);
		return list;
	}
	
	/**
	 * @param o
	 */
	public static void remove(Object o) {
		
		switch (o.getClass().getSimpleName()) {
		case "Job":
			Job j = (Job)o;
			for (int i=0;i<getJobList().size();i++) {
				if(j.getName().equals(getJobList().get(i).getName())) {
					System.out.println("Deleting "+j.getName());
					getJobList().remove(i);
				}
			}
			break;
		case "Customer":
			Customer c = (Customer)o;
			for (int i=0;i<customerList.size();i++) {
				if(c.getName().equals(customerList.get(i).getName())) {
					System.out.println("Deleting "+c.getName());
					customerList.remove(i);
				}
			}
			break;
		case "Material":
			Material m = (Material)o;
			for (int i=0; i<materialList.size();i++) {
				if(m.getName().equals(materialList.get(i).getName())) {
					System.out.println("Deleting "+m.getName());
					materialList.remove(i);
				}
			}
			break;
		case "Ad":
			Ad a = (Ad)o;
			for (int i=0;i<adList.size();i++) {
				if(a.getName().equals(adList.get(i).getName())) {
					System.out.println("Deleting "+a.getName());
					adList.remove(i);
				}
			}
			break;
		case "Crew":
			Crew cr = (Crew)o;
			for (int i=0;i<crewList.size();i++) {
				if(cr.getName().equals(crewList.get(i).getName())) {
					System.out.println("Deleting "+cr.getName());
					crewList.remove(i);
				}
			}
			break;
		default:
			break;
		}
		try {
			updateDataFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param o
	 * @param n
	 */
	public static void replace(Object o,Object n) {
		
		switch (o.getClass().getSimpleName()) {
		case "Job":
			Job j = (Job)n;
			Job oj = (Job)o;
			for (int i=0;i<getJobList().size();i++) {
				if(oj.getName().equals(getJobList().get(i).getName())) {
					System.out.println("Replacing "+oj.getName());
					getJobList().set(i, j);
				}
			}
			break;
		case "Customer":
			Customer c = (Customer)n;
			Customer oc = (Customer)o;
			for (int i=0;i<customerList.size();i++) {
				if(oc.getName().equals(customerList.get(i).getName())) {
					System.out.println("Replacing "+oc.getName());
					customerList.set(i, c);
				}
			}
			break;
		case "Material":
			Material m = (Material)n;
			Material om = (Material)o;
			for (int i=0; i<materialList.size();i++) {
				if(om.getName().equals(materialList.get(i).getName())) {
					System.out.println("Replacing "+om.getName());
					materialList.set(i, m);
				}
			}
			break;
		case "Ad":
			Ad a = (Ad)n;
			Ad oa = (Ad)o;
			for (int i=0;i<adList.size();i++) {
				if(oa.getName().equals(adList.get(i).getName())) {
					System.out.println("Replacing "+oa.getName());
					adList.set(i, a);
				}
			}
			break;
		case "Crew":
			Crew cr = (Crew)n;
			Crew ocr = (Crew)o;
			for (int i=0;i<crewList.size();i++) {
				if(ocr.getName().equals(crewList.get(i).getName())) {
					System.out.println("Replacing "+ocr.getName());
					crewList.set(i, cr);
				}
			}
			break;
		default:
			break;
		}
		try {
			updateDataFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param o
	 * @return
	 */
	public static String getName(Object o) {
		String name = "";
		switch (o.getClass().getSimpleName()) {
		case "Job":
			Job j = (Job)o;
			for (int i=0;i<getJobList().size();i++) {
				if(j.getName().equals(getJobList().get(i).getName())) {
					name = getJobList().get(i).getName();
				}
			}
			break;
		case "Customer":
			Customer c = (Customer)o;
			for (int i=0;i<customerList.size();i++) {
				if(c.getName().equals(customerList.get(i).getName())) {
					name = customerList.get(i).getName();
				}
			}
			break;
		case "Material":
			Material m = (Material)o;
			for (int i=0; i<materialList.size();i++) {
				if(m.getName().equals(materialList.get(i).getName())) {
					name = materialList.get(i).getName();
				}
			}
			break;
		case "Ad":
			Ad a = (Ad)o;
			for (int i=0;i<adList.size();i++) {
				if(a.getName().equals(adList.get(i).getName())) {
					name = adList.get(i).getName();
				}
			}
			break;
		case "Crew":
			Crew cr = (Crew)o;
			for (int i=0;i<crewList.size();i++) {
				if(cr.getName().equals(crewList.get(i).getName())) {
					name = crewList.get(i).getName();
				}
			}
			break;
		default:
			break;
		}
		return name;
	}

}
