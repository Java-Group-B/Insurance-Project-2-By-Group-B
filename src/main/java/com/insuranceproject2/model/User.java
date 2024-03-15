package com.insuranceproject2.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String emailId;
	@OneToMany(mappedBy = "userId")
	private List<Policy> policylist;
	@OneToMany(mappedBy = "user_id")
	private List<Premium> premiunlist;
	@OneToMany(mappedBy = "userId$")
	private List<Claim> claimlist;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public List<Policy> getPolicylist() {
		return policylist;
	}
	public void setPolicylist(List<Policy> policylist) {
		this.policylist = policylist;
	}
	public List<Premium> getPremiunlist() {
		return premiunlist;
	}
	public void setPremiunlist(List<Premium> premiunlist) {
		this.premiunlist = premiunlist;
	}
	public List<Claim> getClaimlist() {
		return claimlist;
	}
	public void setClaimlist(List<Claim> claimlist) {
		this.claimlist = claimlist;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", policylist=" + policylist + ", premiunlist=" + premiunlist + ", claimlist=" + claimlist + "]";
	}
	
}
