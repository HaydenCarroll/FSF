package Manager;

import java.io.Serializable;
import java.util.ArrayList;

//(Andres R) This class is used to create the Ad objects that contain the data about the advertisements or other references 
//it should contain the name of the person/ad, the location/zone it is in (if a location is not passed is should default to online),
//how much the ad cost, how much has been sold as a result of the ad, and the number of customers that have used the ad
//be sure to have overloading instantiation methods for cases where variables are not passed.
//make a method that updates the the amount sold (ex. updateSoldAmnt(number) that equals amount sold+number)
//make a method that updates the number of customers that used the ad (ex. DEFAULT METHOD: updateAdUse() that equals ad use+1, METHOD: updateAdUse(number) that equals ad use+number)
//getters and setters
public class Ad implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int adID;
	private double adCost;
	private String name;
	private int numberOfUses;
	private ArrayList<String> location;
	private String sLocation;
	private int amtSold;
	private double value;
	
	public Ad(String name, double adCost, int numberOfUses, int amtSold){
		this.adID=Data.getNextAdID();
		this.name = name;
		this.adCost = adCost;
		this.numberOfUses = numberOfUses;
		this.location=new ArrayList<String>();
		this.location.add("Online");
		updateSLocation();
	}
	
	public Ad(String name, String location, double adCost, int numberOfUses, int amtSold){
		this.adID=Data.getNextAdID();
		this.name = name;
		this.adCost = adCost;
		this.numberOfUses = numberOfUses;
		this.location=new ArrayList<String>();
		this.location.add(location);
		this.amtSold = amtSold;
		updateSLocation();
	}
	public Ad(String name, ArrayList<String> location, double adCost, int numberOfUses, double value){
		this.adID=Data.getNextAdID();
		this.name = name;
		this.adCost = adCost;
		this.numberOfUses = numberOfUses;
		this.location=location;
		this.value = value;
		updateSLocation();
	}
	
	public Ad(){
	
	}
	public int getAdID() {
		return this.adID;
	}
	public void updateSoldAmnt(int number){
		this.amtSold = this.amtSold + number;
	}
	
	public void updateAdUse(){
		this.numberOfUses++;
	}
	
	public void updateAdUse(int number){
		this.numberOfUses=+number;
	}

	public double getAdCost() {
		return adCost;
	}

	public void setAdCost(int adCost) {
		this.adCost = adCost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfUses() {
		return numberOfUses;
	}

	public void setNumberOfUses(int numberOfUses) {
		this.numberOfUses = numberOfUses;
	}

	public ArrayList<String> getLocation() {
		return location;
	}

	public void setLocation(ArrayList<String> location) {
		this.location = location;
	}
	public void updateLocation(ArrayList<String> location) {
		this.location.addAll(location);
	}
	public void updateLocation(String location) {
		this.location.add(location);
	}

	public int getAmtSold() {
		return amtSold;
	}

	public void setAmtSold(int amtSold) {
		this.amtSold = amtSold;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	public void updateValue() {
		this.value = Data.getAdValue(this);
	}

	public String getsLocation() {
		return sLocation;
	}

	public void setsLocation(String sLocation) {
		this.sLocation = sLocation;
	}
	
	public String updateSLocation() {
		String s = "";
		for (int i=0;i<location.size();i++) {
			if(location.size()-i==1) {
				System.out.println("adding "+location.get(i));
				s+=location.get(i);
			}
			System.out.println("adding "+location.get(i)+", ");
			s+=location.get(i)+" ,";
		}
		return s;
	}
	
	
}
