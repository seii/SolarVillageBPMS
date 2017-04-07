package com.solarvillage.datamodel;

import java.io.Serializable;

public class GovtApproval implements Serializable {
	private String ownerName;
	private String ownerAddress;
	private String permitID;
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
	public String getPermitID() {
		return permitID;
	}
	public void setPermitID(String permitID) {
		this.permitID = permitID;
		this.structuralPermitID = permitID + "-struct";
		this.electricalPermitID = permitID + "-elec";
	}
	public String getStructuralPermitID() {
		return structuralPermitID;
	}
	public String getElectricalPermitID() {
		return electricalPermitID;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
}
