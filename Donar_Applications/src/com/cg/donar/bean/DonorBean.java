package com.cg.donar.bean;

import java.util.Date;

public class DonorBean {
	private String donorId;
	private String donorName;
	private String phoneNumber;
	private String address;
	private double donationAmount;
	private Date donationDate;
	public String getDonorId() {
		return donorId;
	}
	public void setDonorId(String donorId) {
		this.donorId = donorId;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getDonationAmount() {
		return donationAmount;
	}
	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}
	public Date getDonationDate() {
		return donationDate;
	}
	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}
	
	@Override
	public String toString() {
		return "DonorBean [donorId=" + donorId + ", donorName=" + donorName + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", donationAmount=" + donationAmount + ", donationDate=" + donationDate
				+ "]";
	}
	
	

}
