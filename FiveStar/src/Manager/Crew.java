package Manager;

import java.io.Serializable;
import java.util.ArrayList;

//(Andres G) this class should have the crew name, crew id, how many jobs they have done, and a list of jobs that they have worked on
//make a method that updates the number of jobs they have done (ex. updateJobNum() that just makes job number = job number+1)
//make sure the job list is generic to the Job class and make a method that adds a new job to the list. 
//getters and setters
public class Crew implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int crewID;
	private String name;
	private int numOfJobs;
	private ArrayList<Job> jobList;
	private String sJobsList;
	
	public Crew() {
		
	}
	public Crew(String name) {
		this.crewID=Data.getNextCrewID();
		this.name=name;
		this.numOfJobs=0;
		this.jobList=new ArrayList<Job>();
		this.sJobsList="";
		
	}
	

	public Crew(String name,int numOfJobs) {
		this.crewID=Data.getNextCrewID();
		this.name=name;
		this.numOfJobs=numOfJobs;
		this.jobList=new ArrayList<Job>();
		this.sJobsList="";
	}
	
	public void addJob(Job job) {
		jobList.add(job);
		numOfJobs++;
		populateSJobsList();
	}
	public void removeJob(Job job) {
		if(jobList.contains(job)) {
			jobList.remove(job);
			numOfJobs--;
			populateSJobsList();
		}
	}
	
	public void populateSJobsList() {
		sJobsList="";
		for(int i=0;i<jobList.size();i++) {
			if(i!=0&&i%3==0) {
				sJobsList+="\n";
			}
			sJobsList+=jobList.get(i).getName()+", ";
		}
	}
	public int getCrewID() {
		return crewID;
	}
	public void setCrewID(int crewID) {
		this.crewID = crewID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumOfJobs() {
		return numOfJobs;
	}
	public void setNumOfJobs(int numOfJobs) {
		this.numOfJobs = numOfJobs;
	}
	public ArrayList<Job> getJobList() {
		return jobList;
	}
	public void setJobList(ArrayList<Job> jobList) {
		this.jobList = jobList;
	}
	
	public void updateJobList() {
		this.jobList=Data.getJobListByCrew(this);
	}
	public String getSJobsList() {
		populateSJobsList();
		return this.sJobsList;
	}
	public String toString() {
		return this.name;
	}
	

}
