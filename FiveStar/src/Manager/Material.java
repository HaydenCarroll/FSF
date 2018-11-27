package Manager;

import java.io.Serializable;

//(Andres R) This class should contain a name, price per foot(what the customer is charged), cost per unit,
//total amount spent on the material, total footage of material sold, total amount sold of material(money amnt),
//make a method to update total spent, total footage,
//total amount of material(ex. updateSold(number) so that sold=sold+number)
//getters and setters

/**
 * @author Andres R
 *
 */
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
	
	/**
	 * 
	 */
	public Material(){
	}
	
	/**
	 * @param name
	 * @param costPU
	 * @param pricePF
	 */
	public Material(String name, double costPU, double pricePF){
		this.materialID=Data.getNextMaterialID();
		this.name = name;
		this.setPricePF(pricePF);
		this.costPU = costPU;
		this.totalAmtSpent = 0;
		this.totalFootage = 0;
		this.totalAmtSold = 0;
	}
	/**
	 * @param name
	 * @param costPU
	 * @param totalAmt
	 * @param totalFootage
	 * @param totalAmtSold
	 * @param pricePF
	 */
	public Material(String name, double costPU, double totalAmt, double totalFootage, double totalAmtSold,double pricePF){
		this.materialID=Data.getNextMaterialID();
		this.name = name;
		this.setPricePF(pricePF);
		this.costPU = costPU;
		this.totalAmtSpent = totalAmt;
		this.totalFootage = totalFootage;
		this.totalAmtSold = totalAmtSold;
	}
	
	
	/**
	 * @param update
	 */
	public void updateTotalAmtSpent(double update){
		this.totalAmtSpent+=update;
	}
	
	/**
	 * @param update
	 */
	public void updateTotalFootage(double update){
		this.totalFootage+= update;
	}
	
	/**
	 * @param update
	 */
	public void updateTotalAmtSold(double update){
		this.totalAmtSold+= update;
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
	public double getCostPU() {
		return costPU;
	}

	/**
	 * @param costPU
	 */
	public void setCostPU(double costPU) {
		this.costPU = costPU;
	}

	/**
	 * @return
	 */
	public double getTotalAmtSpent() {
		return totalAmtSpent;
	}

	/**
	 * @param totalAmtSpent
	 */
	public void setTotalAmtSpent(double totalAmtSpent) {
		this.totalAmtSpent = totalAmtSpent;
	}

	/**
	 * @return
	 */
	public double getTotalFootage() {
		return totalFootage;
	}

	/**
	 * @param totalFootage
	 */
	public void setTotalFootage(double totalFootage) {
		this.totalFootage = totalFootage;
	}

	/**
	 * @return
	 */
	public double getTotalAmtSold() {
		return totalAmtSold;
	}

	/**
	 * @param totalAmtSold
	 */
	public void setTotalAmtSold(double totalAmtSold) {
		this.totalAmtSold = totalAmtSold;
	}

	/**
	 * @return
	 */
	public int getMaterialID() {
		return materialID;
	}

	/**
	 * @param materialID
	 */
	public void assignMaterialID(int materialID) {
		this.materialID=Data.getNextMaterialID();;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}

	/**
	 * @return
	 */
	public double getPricePF() {
		return pricePF;
	}

	/**
	 * @param pricePF
	 */
	public void setPricePF(double pricePF) {
		this.pricePF = pricePF;
	}
	
	
}