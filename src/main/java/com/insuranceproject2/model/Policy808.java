package com.insuranceproject2.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="policy808")
public class Policy808 {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="policy_serialno")
	private int policySerialNo;
	@Column(name="policy_id")
	private String policyId;
	@Column(name="policy_name")
	private String policyName;
	@Column(name="policy_status")
	private String policyStatus;
	@Column(name="policy_coverage (Rs)")
	private double coverageAmount;
	@Column(name="policy_term (yr)")
	private int policyTerm;
	
	private int userId;
	
	@OneToMany(mappedBy="policyNo")
	private List<PolicyPremium808> premiumPlans;
	
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
	
	public String getPolicyName() {
		return policyName;
	}
	
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	
	public String getPolicyStatus() {
		return policyStatus;
	}
	
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
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
	
	public List<PolicyPremium808> getPremiumPlans() {
		return premiumPlans;
	}

	public void setPremiumPlans(List<PolicyPremium808> premiumPlans) {
		this.premiumPlans = premiumPlans;
	}

	@Override
	public String toString() {
		return "Policy808 [policySerialNo=" + policySerialNo + ", policyId=" + policyId + ", policyName=" + policyName
				+ ", policyStatus=" + policyStatus + ", coverageAmount=" + coverageAmount + ", policyTerm=" + policyTerm
				+ ", userId=" + userId + ", premiumPlans=" + premiumPlans + "]";
	}
}


