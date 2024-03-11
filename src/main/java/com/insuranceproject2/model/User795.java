package com.insuranceproject2.model;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user795")
public class User795 {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String firstName;
private String lastName;
private String emailId;
@OneToMany(mappedBy = "userId")

private List<Claim795> claimList;
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
public List<Claim795> getClaimList() {
	return claimList;
}
public void setClaimList(List<Claim795> claimList) {
	this.claimList = claimList;
}
@Override
public String toString() {
	return "User795 [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
			+ ", claimList=" + claimList + "]";
}
}