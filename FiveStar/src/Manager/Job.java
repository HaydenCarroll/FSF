package Manager;

import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;

//(Andres G) this class is equivalent to an order and should include the customer id, job id, address, 
//quote, date(i will set this part up when i finish the ui so dont worry about it), Material,
//labor cost, the crew, and a boolean of if it has been completed.
//there could be a method used to assign the job id that uses the Data class to find the value (ex. Data.getNextJobId() )
//getters and setters
public class Job implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int jobID;
	private String jobName;
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
	private String cusName;
	private String cityName;
	private String fenceName;
	private String sAd;
	private String sCrew;
	private double totalMatCost;
	
	public Job(Ad ad, Crew crew, ArrayList<Material> matList,ArrayList<Integer> matUnit, double quote, double footage, Address address, double laborCost, LocalDate date,Customer customer, String jobName) {
		this.jobID=Data.getNextJobID();
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
		this.setJobName(jobName);
		this.setCusName(customer.getName());
		this.setsDate(date.toString());
		this.setCityName(address.getCity());
		this.setFenceName(fenceName);
		this.setsAd(ad.getName());
		this.setsCrew(crew.getName());
		this.totalMatCost=getTotalMatCost();
		this.dateCompleted=null;
	}
	
	public double getTotalMatCost() {
		double tot=0;
		for (int i=0;i<this.matList.size();i++) {
			tot+=this.matList.get(i).getCostPU()*this.matUnit.get(i);
		}
		return tot;
	}
	public void assignJobID() {
		this.jobID=Data.getNextJobID();
	}
	
	public int getJobID() {
		return jobID;
	}
	/*public void setJobID(int jobID) {
		this.jobID = jobID;
	}*/
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Ad getAd() {
		return ad;
	}
	public void setAd(Ad ad) {
		this.ad = ad;
	}
	
	public Crew getCrew() {
		return crew;
	}
	public void setCrew(Crew crew) {
		this.crew = crew;
	}
	
	/*public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}*/
	
	public double getQuote() {
		return quote;
	}
	public void setQuote(double quote) {
		this.quote = quote;
	}
	
	public double getFootage() {
		return footage;
	}
	public void setFootage(double footage) {
		this.footage = footage;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getLaborCost() {
		return laborCost;
	}

	public void setLaborCost(int laborCost) {
		this.laborCost = laborCost;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public LocalDate getDateCompleted() {
		return dateCompleted;
	}
	public void setDateCompleted(LocalDate dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getFenceName() {
		return fenceName;
	}
	public void setFenceName(String fenceName) {
		this.fenceName = fenceName;
	}
	public String getsCrew() {
		return sCrew;
	}
	public void setsCrew(String sCrew) {
		this.sCrew = sCrew;
	}
	public String getsAd() {
		return sAd;
	}
	public void setsAd(String sAd) {
		this.sAd = sAd;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public ArrayList<Material> getMatList() {
		return matList;
	}
	public void setMatList(ArrayList<Material> matList) {
		this.matList = matList;
	}
	public ArrayList<Integer> getMatUnit() {
		return matUnit;
	}
	public void setMatUnit(ArrayList<Integer> matUnit) {
		this.matUnit = matUnit;
	}
	
	
	

}
