package Manager;

import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;

//(Andres G) this class is equivalent to an order and should include the customer id, job id, address, 
//quote, date(i will set this part up when i finish the ui so dont worry about it), Material,
//labor cost, the crew, and a boolean of if it has been completed.
//there could be a method used to assign the job id that uses the Data class to find the value (ex. Data.getNextJobId() )
//getters and setters

/**
 * @author Andres G
 *
 */
public class Job implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private int jobID;
	private String name;
	private Customer customer;
	private Ad ad;
	private Crew crew;
	//private Material material;
	private ArrayList<Material> matList;
	private ArrayList<Integer> matUnit;
	private double quote;
	private double footage;
	private Address address;
	private LocalDate date;
	private double laborCost;
	private boolean completed;
	private double profit;
	private LocalDate dateCompleted;
	private String sDate;
	private String sDateCompleted;
	private String cusName;
	private String cityName;
	private String fenceName;
	private String sAd;
	private String sCrew;
	private double totalMatCost;
	private double amntCharged;
	private boolean isRepair;
	
	/**
	 * @param ad
	 * @param crew
	 * @param matList
	 * @param matUnit
	 * @param quote
	 * @param footage
	 * @param address
	 * @param laborCost
	 * @param date
	 * @param customer
	 * @param jobName
	 * @param fenceName
	 * @param isRepair
	 */
	public Job(Ad ad, Crew crew, ArrayList<Material> matList,ArrayList<Integer> matUnit, double quote, double footage, Address address, double laborCost,
			LocalDate date,Customer customer, String jobName, String fenceName, boolean isRepair) {
		this.jobID=Data.getNextJobID();
		this.ad=ad;
		this.ad.updateAdUse();
		this.setMatUnit(matUnit);
		this.crew=crew;
		this.setMatList(matList);
		this.quote=quote;
		this.footage=footage;
		this.address=address;
		this.laborCost=laborCost;
		this.date=date;
		this.customer=customer;
		this.setName(jobName);
		this.setCusName(customer.getName());
		this.setSDate(date.toString());
		this.setCityName(address.getCity());
		this.setFenceName(fenceName);
		this.setSAd(ad.getName());
		this.setSCrew(crew.getName());
		this.setTotalMatCost(getTotalMatCost());
		this.dateCompleted=null;
		this.completed=false;
		this.profit=0;
		this.sDateCompleted=null;
		this.totalMatCost=0;
		this.amntCharged=0;
		this.isRepair=isRepair;
	}
	/**
	 * 
	 */
	public Job() {
		
	}
	
	/**
	 * @param ad
	 * @param crew
	 * @param matList
	 * @param matUnit
	 * @param quote
	 * @param footage
	 * @param address
	 * @param laborCost
	 * @param date
	 * @param customer
	 * @param jobName
	 * @param fenceName
	 * @param isRepair
	 */
	public void setJob(Ad ad, Crew crew, ArrayList<Material> matList,ArrayList<Integer> matUnit, double quote, double footage, Address address, double laborCost,
			LocalDate date,Customer customer, String jobName, String fenceName, boolean isRepair) {
		this.ad=ad;
		this.setMatUnit(matUnit);
		this.crew=crew;
		this.setMatList(matList);
		this.quote=quote;
		this.footage=footage;
		this.address=address;
		this.laborCost=laborCost;
		this.date=date;
		this.customer=customer;
		this.setName(jobName);
		this.setCusName(customer.getName());
		this.setSDate(date.toString());
		this.setCityName(address.getCity());
		this.setFenceName(fenceName);
		this.setSAd(ad.getName());
		this.setSCrew(crew.getName());
		this.setTotalMatCost(getTotalMatCost());
		this.dateCompleted=null;
		this.completed=false;
		this.profit=0;
		this.sDateCompleted=null;
		this.totalMatCost=0;
		this.amntCharged=0;
		this.isRepair=isRepair;
		
	}
	
	/**
	 * @param ad
	 * @param crew
	 * @param matList
	 * @param matUnit
	 * @param quote
	 * @param footage
	 * @param address
	 * @param laborCost
	 * @param date
	 * @param customer
	 * @param jobName
	 * @param fenceName
	 * @param dateCompleted
	 * @param matCost
	 * @param charged
	 * @param isRepair
	 */
	public void setCompletedJob(Ad ad, Crew crew, ArrayList<Material> matList,ArrayList<Integer> matUnit, double quote, double footage, Address address,
			double laborCost, LocalDate date,Customer customer, String jobName, String fenceName,LocalDate dateCompleted, double matCost, double charged, boolean isRepair) {
		this.ad=ad;
		this.setMatUnit(matUnit);
		this.crew=crew;
		this.setMatList(matList);
		this.quote=quote;
		this.footage=footage;
		this.address=address;
		this.laborCost=laborCost;
		this.date=date;
		this.customer=customer;
		this.setName(jobName);
		this.setCusName(customer.getName());
		this.setSDate(date.toString());
		this.setCityName(address.getCity());
		this.setFenceName(fenceName);
		this.setSAd(ad.getName());
		this.setSCrew(crew.getName());
		this.setTotalMatCost(getTotalMatCost());
		this.dateCompleted=dateCompleted;
		this.sDateCompleted=dateCompleted.toString();
		this.totalMatCost=matCost;
		this.amntCharged=charged;
		this.profit=charged-(laborCost+matCost);
		this.isRepair=isRepair;
		this.completed=true;
	}
	
	/**
	 * @param date
	 * @param labor
	 * @param matCost
	 * @param charged
	 */
	public void endJob(LocalDate date, double labor, double matCost, double charged) {
		this.dateCompleted=date;
		this.laborCost=labor;
		this.totalMatCost=matCost;
		this.amntCharged=charged;
		this.sDateCompleted=date.toString();
		this.completed=true;
		this.profit=charged-(labor+matCost);
		
		
		this.ad.updateValue();
		
		this.customer.updateNumOfJobs();
		
		this.crew.updateJobList();
		
		for(int i=0;i<this.matList.size();i++) {
			Data.updateMaterial(this.matList.get(i));
		}
		
	}
	
	/**
	 * @return
	 */
	public double getTotalMatCost() {
		double tot=0;
		for (int i=0;i<this.matList.size();i++) {
			tot+=this.matList.get(i).getCostPU()*this.matUnit.get(i);
		}
		return tot;
	}
	/**
	 * 
	 */
	public void assignJobID() {
		this.jobID=Data.getNextJobID();
	}
	
	/**
	 * @return
	 */
	public int getJobID() {
		return jobID;
	}
	/**
	 * @param jobID
	 */
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	
	/**
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * @return
	 */
	public Ad getAd() {
		return ad;
	}
	/**
	 * @param ad
	 */
	public void setAd(Ad ad) {
		this.ad = ad;
	}
	
	/**
	 * @return
	 */
	public Crew getCrew() {
		return crew;
	}
	/**
	 * @param crew
	 */
	public void setCrew(Crew crew) {
		this.crew = crew;
	}
	
	
	/**
	 * @return
	 */
	public double getQuote() {
		return quote;
	}
	/**
	 * @param quote
	 */
	public void setQuote(double quote) {
		this.quote = quote;
	}
	
	/**
	 * @return
	 */
	public double getFootage() {
		return footage;
	}
	/**
	 * @param footage
	 */
	public void setFootage(double footage) {
		this.footage = footage;
	}
	
	/**
	 * @return
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * @return
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return
	 */
	public double getLaborCost() {
		return laborCost;
	}

	/**
	 * @param laborCost
	 */
	public void setLaborCost(int laborCost) {
		this.laborCost = laborCost;
	}

	/**
	 * @return
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * @param completed
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	/**
	 * @return
	 */
	public LocalDate getDateCompleted() {
		return dateCompleted;
	}
	/**
	 * @param dateCompleted
	 */
	public void setDateCompleted(LocalDate dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	/**
	 * @return
	 */
	public String getSDate() {
		return sDate;
	}
	/**
	 * @param sDate
	 */
	public void setSDate(String sDate) {
		this.sDate = sDate;
	}
	/**
	 * @return
	 */
	public String getCusName() {
		return cusName;
	}
	/**
	 * @param cusName
	 */
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	/**
	 * @return
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return
	 */
	public String getFenceName() {
		return fenceName;
	}
	/**
	 * @param fenceName
	 */
	public void setFenceName(String fenceName) {
		this.fenceName = fenceName;
	}
	/**
	 * @return
	 */
	public String getSCrew() {
		return sCrew;
	}
	/**
	 * @param sCrew
	 */
	public void setSCrew(String sCrew) {
		this.sCrew = sCrew;
	}
	/**
	 * @return
	 */
	public String getSAd() {
		return sAd;
	}
	/**
	 * @param sAd
	 */
	public void setSAd(String sAd) {
		this.sAd = sAd;
	}
	/**
	 * @return
	 */
	public double getProfit() {
		return profit;
	}
	/**
	 * @param profit
	 */
	public void setProfit(double profit) {
		this.profit = profit;
	}
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param jobName
	 */
	public void setName(String jobName) {
		this.name = jobName;
	}
	/**
	 * @return
	 */
	public ArrayList<Material> getMatList() {
		return matList;
	}
	/**
	 * @param matList
	 */
	public void setMatList(ArrayList<Material> matList) {
		this.matList = matList;
	}
	/**
	 * @return
	 */
	public ArrayList<Integer> getMatUnit() {
		return matUnit;
	}
	/**
	 * @param matUnit
	 */
	public void setMatUnit(ArrayList<Integer> matUnit) {
		this.matUnit = matUnit;
	}

	/**
	 * @return
	 */
	public String getsDateCompleted() {
		return sDateCompleted;
	}

	/**
	 * @param sDateCompleted
	 */
	public void setsDateCompleted(String sDateCompleted) {
		this.sDateCompleted = sDateCompleted;
	}

	/**
	 * @param totalMatCost
	 */
	public void setTotalMatCost(double totalMatCost) {
		this.totalMatCost = totalMatCost;
	}

	/**
	 * @return
	 */
	public double getAmntCharged() {
		return amntCharged;
	}

	/**
	 * @param amntCharged
	 */
	public void setAmntCharged(double amntCharged) {
		this.amntCharged = amntCharged;
	}
	/**
	 * @return
	 */
	public boolean isRepair() {
		return isRepair;
	}
	/**
	 * @param isRepair
	 */
	public void setRepair(boolean isRepair) {
		this.isRepair = isRepair;
	}
	
	/**
	 * @return
	 */
	public double getSpending() {
		return this.totalMatCost+this.laborCost;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.name;
	}

}
