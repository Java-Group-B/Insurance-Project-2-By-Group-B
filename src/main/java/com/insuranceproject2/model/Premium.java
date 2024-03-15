package com.insuranceproject2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
@Entity
@Table(name="premium")
public class Premium {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="premium_serialNo")
	private int premiumSerialNo;
	@Column(name="premium_id")
	private String premiumId;
	@Column(name="plan_name")
	private String premiumPlanName;
	@Column(name="premium_type")
	private String premiumType;
	@Column(name="premium_amount")
	private double premiumAmount;
	@Column(name = "userId")
	private int uid;
	public int getPremiumSerialNo() {
		return premiumSerialNo;
	}
	public void setPremiumSerialNo(int premiumSerialNo) {
		this.premiumSerialNo = premiumSerialNo;
	}
	public String getPremiumId() {
		return premiumId;
	}
	public void setPremiumId(String premiumId) {
		this.premiumId = premiumId;
	}
	public String getPremiumPlanName() {
		return premiumPlanName;
	}
	public void setPremiumPlanName(String premiumPlanName) {
		this.premiumPlanName = premiumPlanName;
	}
	public String getPremiumType() {
		return premiumType;
	}
	public void setPremiumType(String premiumType) {
		this.premiumType = premiumType;
	}
	public double getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Premium [premiumSerialNo=" + premiumSerialNo + ", premiumId=" + premiumId + ", premiumPlanName="
				+ premiumPlanName + ", premiumType=" + premiumType + ", premiumAmount=" + premiumAmount + ", uid=" + uid
				+ "]";
	}
	
	
}
