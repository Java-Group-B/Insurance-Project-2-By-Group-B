package com.insuranceproject2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "claim795")
public class Claim795 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int claimId;
	private String claimType;
	private String claimCause;
	private Long claimAmount;
	private int userId;
	
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
	public Long getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(Long claimAmount) {
		this.claimAmount = claimAmount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Claim795 [claimId=" + claimId + ", claimType=" + claimType + ", claimCause=" + claimCause
				+ ", claimAmount=" + claimAmount + ", userId=" + userId + "]";
	}
}
