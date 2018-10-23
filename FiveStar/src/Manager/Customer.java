package Manager;

//(Joey) This class should have a customer id, Ad id, name, address object, number of jobs, billing address, and email.
//use the data class to find the customer id (Data.getNextCustomerId()) 
//getters and setters
public class Customer {
	int adID;
	String name;
	Address address;
	int numOfJobs;
	String billingAddress;
	String email;
	public Customer(int id,int adId,String name,Address address,int numOfJobs,String billingAddress,String email) {
		id=Data.getNextCustomerId();
		this.adID=adId;
		this.name=name;
		this.address=address;
		this.numOfJobs=numOfJobs;
		this.billingAddress=billingAddress;
		this.email=email;
	}
	public int getAdID() {
		return adID;
	}
	public void setAdID(int adID) {
		this.adID = adID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getNumOfJobs() {
		return numOfJobs;
	}
	public void setNumOfJobs(int numOfJobs) {
		this.numOfJobs = numOfJobs;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
