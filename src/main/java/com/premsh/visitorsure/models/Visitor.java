package com.premsh.visitorsure.models;

public class Visitor {
	private Integer visitorId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String profiePhotoUrl;
	
	public Integer getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(Integer visitorId) {
		this.visitorId = visitorId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProfiePhotoUrl() {
		return profiePhotoUrl;
	}
	public void setProfiePhotoUrl(String profiePhotoUrl) {
		this.profiePhotoUrl = profiePhotoUrl;
	}
	
	
}
