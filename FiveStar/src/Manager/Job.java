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
	private int laborCost;
	private boolean completed;
	
	
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

	public int getLaborCost() {
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
	
	
	

}
