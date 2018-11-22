package Manager;

import java.io.Serializable;
import java.lang.reflect.Field;

//(Joey) This class should have a customer id, Ad id, name, address object, number of jobs, billing address, and email.
//use the data class to find the customer id (Data.getNextCustomerId()) 
//getters and setters
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	int id;
	private String refrence;
	private String name;
	private Address address;
	private int numOfJobs;
	private String email;
	private String sAddress;
	private String phone;

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Customer() {
		
	}
	public Customer(String name,Address address,int numOfJobs,String email, String phone) {
		this.id=Data.getNextCustomerID();
		this.refrence="";
		this.name=name;
		this.address=address;
		this.numOfJobs=numOfJobs;
		this.email=email;
		this.setsAddress(address.toString());
		this.phone=phone;
	}
	public Customer(String refrence,String name,Address address,int numOfJobs,String email, String phone) {
		this.id=Data.getNextCustomerID();
		this.refrence=refrence;
		this.name=name;
		this.address=address;
		this.numOfJobs=numOfJobs;
		this.email=email;
		this.setsAddress(address.toString());
		this.phone=phone;
	}

	public String getRefrence() {
		return refrence;
	}
	//this might not be needed
	/*public void setAdID(int refrence) {
		this.refrence = refrence;
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
	/*public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}*/
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		Field[] f =this.getClass().getDeclaredFields();
		String var = "";
		for (int i=0;i<f.length;i++) {
			var+=f[i].getName()+" ";
		}
		return this.id+" "+this.refrence+ " "+this.name+" "+this.address.toString()+" "+this.numOfJobs+" "+this.phone+" "+this.email+var;
		
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
}
