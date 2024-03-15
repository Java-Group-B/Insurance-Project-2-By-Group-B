package com.insuranceproject2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
@Entity
@Table(name = "claim")
public class Claim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int claimId;
	private String claimType;
	private String claimCause;
	private long claimAmount;
@Column(name="userId")
	private int usd;

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

	public long getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(long claimAmount) {
		this.claimAmount = claimAmount;
	}

	public int getUsd() {
		return usd;
	}

	public void setUsd(int usd) {
		this.usd = usd;
	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", claimType=" + claimType + ", claimCause=" + claimCause
				+ ", claimAmount=" + claimAmount + ", usd=" + usd + "]";
	}
	
}
