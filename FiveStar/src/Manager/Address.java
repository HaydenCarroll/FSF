package Manager;

import java.io.Serializable;

//(Joey) this class contains the information for an address
//street, city, state, zip code
//getters and setters

/**
 * @author Joey
 *
 */
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int addressID;
	private String street;
	private String city;
	private String state;
	private int zipcode;
	
	/**
	 * @param street
	 * @param city
	 * @param state
	 * @param zipcode
	 */
	public Address(String street,String city, String state,int zipcode) {
		this.setAddressID(Data.getNextAddressID());
		this.street=street;
		this.city=city;
		this.state=state;
		this.zipcode=zipcode;
	}
	/**
	 * 
	 */
	public Address() {
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return (""+this.street+", "+this.city+", "+this.state+", "+this.zipcode);
	}

	/**
	 * @return
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return
	 */
	public int getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode
	 */
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return
	 */
	public int getAddressID() {
		return addressID;
	}

	/**
	 * @param addressID
	 */
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
}
