package com.insuranceproject2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="policy")
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int policySerialNo;
	private String policyId;
	private String policyStatus;
	private String policyName;
	private double coverageAmount;
	private int policyTerm;
	private int userId;
	public int getPolicySerialNo() {
		return policySerialNo;
	}
	public void setPolicySerialNo(int policySerialNo) {
		this.policySerialNo = policySerialNo;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public double getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	public int getPolicyTerm() {
		return policyTerm;
	}
	public void setPolicyTerm(int policyTerm) {
		this.policyTerm = policyTerm;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Policy [policySerialNo=" + policySerialNo + ", policyId=" + policyId + ", policyStatus=" + policyStatus
				+ ", policyName=" + policyName + ", coverageAmount=" + coverageAmount + ", policyTerm=" + policyTerm
				+ ", userId=" + userId + "]";
	}
	
	
}
