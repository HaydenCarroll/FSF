package Manager;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Goal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate start;
	private LocalDate end;
	private double goalAmt;
	private double cost;
	
	
	public LocalDate getStart() {
		return start;
	}
	public void setStart(LocalDate start) {
		this.start = start;
	}
	public LocalDate getEnd() {
		return end;
	}
	public void setEnd(LocalDate end) {
		this.end = end;
	}
	public double getGoalAmt() {
		return goalAmt;
	}
	public void setGoalAmt(double goalAmt) {
		this.goalAmt = goalAmt;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public double getRevSoFar() {
		ArrayList<Job> jobList = Data.getJobByDate(start, end);
		return Data.getTotalRev(jobList);
	}
	

}
