package com.to;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class Trainee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int traineeId;
	private String traineeName;
	private double marksScored;
	private long contractNumber;
	
	public Trainee() {}

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public double getMarksScored() {
		return marksScored;
	}

	public void setMarksScored(double marksScored) {
		this.marksScored = marksScored;
	}

	public long getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(long contractNumber) {
		this.contractNumber = contractNumber;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName=" + traineeName + ", marksScored=" + marksScored
				+ ", contractNumber=" + contractNumber + "]";
	}

	public Trainee(String traineeName, double marksScored, long contractNumber) {
		this.traineeName = traineeName;
		this.marksScored = marksScored;
		this.contractNumber = contractNumber;
	}
	
	
	
}
