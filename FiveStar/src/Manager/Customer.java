package Manager;

import java.io.Serializable;
import java.lang.reflect.Field;

//(Joey) This class should have a customer id, Ad id, name, address object, number of jobs, billing address, and email.
//use the data class to find the customer id (Data.getNextCustomerId()) 
//getters and setters


/**
 * @author Joey
 *
 */
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

	/**
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * 
	 */
	public Customer() {
		
	}
	/**
	 * @param name
	 * @param address
	 * @param numOfJobs
	 * @param email
	 * @param phone
	 */
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
	/**
	 * @param refrence
	 * @param name
	 * @param address
	 * @param numOfJobs
	 * @param email
	 * @param phone
	 */
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

	/**
	 * @return
	 */
	public String getRefrence() {
		return refrence;
	}
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
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
	public int getNumOfJobs() {
		return numOfJobs;
	}
	/**
	 * @param numOfJobs
	 */
	public void setNumOfJobs(int numOfJobs) {
		this.numOfJobs = numOfJobs;
	}
	/**
	 * 
	 */
	public void updateNumOfJobs() {
		this.numOfJobs = Data.getJobListByCustomer(this).size();
	}
	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		Field[] f =this.getClass().getDeclaredFields();
		String var = "";
		for (int i=0;i<f.length;i++) {
			var+=f[i].getName()+" ";
		}
		return this.id+" "+this.refrence+ " "+this.name+" "+this.address.toString()+" "+this.numOfJobs+" "+this.phone+" "+this.email+var;
		
	}

	/**
	 * @return
	 */
	public String getsAddress() {
		return sAddress;
	}

	/**
	 * @param sAddress
	 */
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
}
