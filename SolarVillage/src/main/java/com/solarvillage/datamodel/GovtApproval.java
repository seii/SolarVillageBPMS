package com.solarvillage.datamodel;

public class GovtApproval {
	private String ownerName;
	private String ownerAddress;
	private String structuralPermitID;
	private String electricalPermitID;
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
	public String getStructuralPermitID() {
		return structuralPermitID;
	}
	public void setStructuralPermitID(String structuralPermitID) {
		this.structuralPermitID = structuralPermitID;
	}
	public String getElectricalPermitID() {
		return electricalPermitID;
	}
	public void setElectricalPermitID(String electricalPermitID) {
		this.electricalPermitID = electricalPermitID;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
}
