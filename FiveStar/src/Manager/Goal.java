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
	
	
	public Goal() {
		
	}
	public Goal(LocalDate start,LocalDate end, double goalAmt) {
		this.start=start;
		this.end=end;
		this.goalAmt=goalAmt;
	}
	
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
	
	public double getRevSoFar() {
		ArrayList<Job> jobList = Data.getJobByDate(start, end);
		return Data.getTotalRev(jobList);
	}
	

}
