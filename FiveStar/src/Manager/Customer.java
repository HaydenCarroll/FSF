package Manager;

import java.io.Serializable;

//(Joey) This class should have a customer id, Ad id, name, address object, number of jobs, billing address, and email.
//use the data class to find the customer id (Data.getNextCustomerId()) 
//getters and setters
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	int adID;
	String name;
	Address address;
	int numOfJobs;
	String billingAddress;
	String email;
	String sAddress;
	String phoneNum;
	public Customer(int adId,String name,Address address,int numOfJobs,String billingAddress,String email, String phoneNum) {
		this.id=Data.getNextCustomerID();
		this.adID=adId;
		this.name=name;
		this.address=address;
		this.numOfJobs=numOfJobs;
		this.billingAddress=billingAddress;
		this.email=email;
		this.sAddress=address.toString();
		this.phoneNum=phoneNum;
	}
	public int getAdID() {
		return adID;
	}
	//this might not be needed
	/*public void setAdID(int adID) {
		this.adID = adID;
	}*/
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
