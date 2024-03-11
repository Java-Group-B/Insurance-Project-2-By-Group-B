package com.insuranceproject2.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "claim807")
public class Claim807 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int claimId;
	private String claimType;
	private String claimCause;
	private String claimAmount;
	
	private int policyNo;

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getClaimCause() {
		return claimCause;
	}

	public void setClaimCause(String claimCause) {
		this.claimCause = claimCause;
	}

	public String getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(String claimAmount) {
		this.claimAmount = claimAmount;
	}

	public int getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", claimType=" + claimType + ", claimCause=" + claimCause
				+ ", claimAmount=" + claimAmount + ", policyNo=" + policyNo + "]";
	}
	
}
