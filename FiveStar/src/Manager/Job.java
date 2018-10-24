package Manager;

import java.time.LocalDate;

//(Andres G) this class is equivalent to an order and should include the customer id, job id, address, 
//quote, date(i will set this part up when i finish the ui so dont worry about it), Material,
//labor cost, the crew, and a boolean of if it has been completed.
//there could be a method used to assign the job id that uses the Data class to find the value (ex. Data.getNextJobId() )
//getters and setters
public class Job {
	private int jobID;
	private Customer customer;
	private Ad ad;
	private Crew crew;
	private Material material;
	private double quote;
	private double footage;
	private Address address;
	private LocalDate date;
	private double laborCost;
	private boolean completed;
	private LocalDate dateCompleted;
	private String sDate;
	
	public Job(Ad ad, Crew crew, Material material, double quote, double footage, Address address, double laborCost, LocalDate date) {
		this.jobID=Data.getNextJobID();
		this.ad=ad;
		this.crew=crew;
		this.material=material;
		this.quote=quote;
		this.footage=footage;
		this.address=address;
		this.laborCost=laborCost;
		this.date=date;
		this.setsDate(date.toString());
		
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
	
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	
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
	
	
	

}
