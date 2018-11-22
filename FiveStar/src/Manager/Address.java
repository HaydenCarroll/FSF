package Manager;

import java.io.Serializable;

//(Joey) this class contains the information for an address
//street, city, state, zip code
//getters and setters
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
	
	public Address(String street,String city, String state,int zipcode) {
		this.setAddressID(Data.getNextAddressID());
		this.street=street;
		this.city=city;
		this.state=state;
		this.zipcode=zipcode;
	}
	public Address() {
		
	}
	
	public String toString() {
		return (""+this.street+", "+this.city+", "+this.state+", "+this.zipcode);
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
}
