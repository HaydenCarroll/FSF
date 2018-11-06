package Manager;

import java.io.Serializable;

//(Andres R) This class should contain a name, price per foot(what the customer is charged), cost per unit,
//total amount spent on the material, total footage of material sold, total amount sold of material(money amnt),
//make a method to update total spent, total footage,
//total amount of material(ex. updateSold(number) so that sold=sold+number)
//getters and setters
public class Material implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int materialID;
	private String name;
	private double pricePF;
	private double costPU;
	private double totalAmtSpent;
	private double totalFootage;
	private double totalAmtSold;
	
	public Material(){
		this.materialID=Data.getNextMaterialID();
		this.name = "<Default name>";
		this.pricePF = 0;
		this.costPU = 0;
		this.totalAmtSpent = 0;
		this.totalFootage = 0;
		this.totalAmtSold = 0;
	}
	
	public Material(String name, double PricePF, double costPU){
		this.materialID=Data.getNextMaterialID();
		this.name = name;
		this.pricePF = PricePF;
		this.costPU = costPU;
		this.totalAmtSpent = 0;
		this.totalFootage = 0;
		this.totalAmtSold = 0;
	}
	public Material(String name, double PricePF, double costPU, double totalAmt, double totalFootage, double totalAmtSold){
		this.materialID=Data.getNextMaterialID();
		this.name = name;
		this.pricePF = PricePF;
		this.costPU = costPU;
		this.totalAmtSpent = totalAmt;
		this.totalFootage = totalFootage;
		this.totalAmtSold = totalAmtSold;
	}
	
	public double totalMatSold(){
		double totalPrice;
		totalPrice = this.pricePF*this.totalFootage;
		return totalPrice;
	}
	
	public void updateTotalAmtSpent(double update){
		this.totalAmtSpent+=update;
	}
	
	public void updateTotalFootage(double update){
		this.totalFootage+= update;
	}
	
	public void updateTotalAmtSold(double update){
		this.totalAmtSold+= update;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPricePF() {
		return pricePF;
	}

	public void setPricePF(double pricePF) {
		this.pricePF = pricePF;
	}

	public double getCostPU() {
		return costPU;
	}

	public void setCostPU(double costPU) {
		this.costPU = costPU;
	}

	public double getTotalAmtSpent() {
		return totalAmtSpent;
	}

	public void setTotalAmtSpent(double totalAmtSpent) {
		this.totalAmtSpent = totalAmtSpent;
	}

	public double getTotalFootage() {
		return totalFootage;
	}

	public void setTotalFootage(double totalFootage) {
		this.totalFootage = totalFootage;
	}

	public double getTotalAmtSold() {
		return totalAmtSold;
	}

	public void setTotalAmtSold(double totalAmtSold) {
		this.totalAmtSold = totalAmtSold;
	}

	public int getMaterialID() {
		return materialID;
	}

	public void assignMaterialID(int materialID) {
		this.materialID=Data.getNextMaterialID();;
	}
	
	
}