package Manager;


//(Andres R) This class is used to create the Ad objects that contain the data about the advertisements or other references 
//it should contain the name of the person/ad, the location/zone it is in (if a location is not passed is should default to online),
//how much the ad cost, how much has been sold as a result of the ad, and the number of customers that have used the ad
//be sure to have overloading instantiation methods for cases where variables are not passed.
//make a method that updates the the amount sold (ex. updateSoldAmnt(number) that equals amount sold+number)
//make a method that updates the number of customers that used the ad (ex. DEFAULT METHOD: updateAdUse() that equals ad use+1, METHOD: updateAdUse(number) that equals ad use+number)
//getters and setters
public class Ad {
	private int adID;
	private int adCost;
	private String name;
	private int numberOfUses;
	private String location;
	private int amtSold;
	
	public Ad(String name, int adCost, int numberOfUses, int amtSold){
		this.adID=Data.getNextAdID();
		this.name = name;
		this.adCost = adCost;
		this.numberOfUses = numberOfUses;
		this.location = "Online";
	}
	
	public Ad(String name, String location, int adCost, int numberOfUses, int amtSold){
		this.adID=Data.getNextAdID();
		this.name = name;
		this.adCost = adCost;
		this.numberOfUses = numberOfUses;
		this.location = location;
		this.amtSold = amtSold;
	}
	
	public Ad(){
		this.adID=Data.getNextAdID();
		this.name = "<Default Name>";
		this.adCost = 0;
		this.numberOfUses = 0;
		this.location = "<Default Location>";
	
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

	public int getAdCost() {
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAmtSold() {
		return amtSold;
	}

	public void setAmtSold(int amtSold) {
		this.amtSold = amtSold;
	}
	
	
}
