package com.solarvillage.datamodel;

import java.io.Serializable;
import java.time.LocalDate;

public class HOAApproval implements Serializable {
	private String ownerName;
	private String ownerAddress;
	private String hoaName;
	private String hoaAddress;
	private LocalDate hoaMeetingDate;
	private boolean isApproved;
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerAddress() {
		return ownerAddress;
	}
	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}
	public String getHoaName() {
		return hoaName;
	}
	public void setHoaName(String hoaName) {
		this.hoaName = hoaName;
	}
	public String getHoaAddress() {
		return hoaAddress;
	}
	public void setHoaAddress(String hoaAddress) {
		this.hoaAddress = hoaAddress;
	}
	public LocalDate getHoaMeetingDate() {
		return hoaMeetingDate;
	}
	public void setHoaMeetingDate(LocalDate hoaMeetingDate) {
		this.hoaMeetingDate = hoaMeetingDate;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
}
