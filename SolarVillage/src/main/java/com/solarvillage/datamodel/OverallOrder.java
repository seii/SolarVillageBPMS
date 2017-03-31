package com.solarvillage.datamodel;

public class OverallOrder {
	HOAApproval hoaApproval;
	GovtApproval govtApproval;
	
	//Constructor for owners who are not part of an HOA
	public OverallOrder(String ownerName, String ownerAddress, String elecPermID, String strucPermID) {
		hoaApproval = null;
		govtApproval = new GovtApproval();
		
		govtApproval.setElectricalPermitID(elecPermID);
		govtApproval.setStructuralPermitID(strucPermID);
		govtApproval.setOwnerName(ownerName);
		govtApproval.setOwnerAddress(ownerAddress);
	}
	
	//Constructor for owners who are part of an HOA
	public OverallOrder(String ownerName, String ownerAddress, String hoaName, String hoaAddress,
						String elecPermID, String strucPermID) {
		hoaApproval = new HOAApproval();
		govtApproval = new GovtApproval();
		
		hoaApproval.setHoaAddress(hoaAddress);
		hoaApproval.setHoaName(hoaName);
		hoaApproval.setOwnerAddress(ownerAddress);
		hoaApproval.setOwnerName(ownerName);
		
		govtApproval.setElectricalPermitID(elecPermID);
		govtApproval.setStructuralPermitID(strucPermID);
		govtApproval.setOwnerName(ownerName);
		govtApproval.setOwnerAddress(ownerAddress);
	}

	public HOAApproval getHoaApproval() {
		return hoaApproval;
	}

	public void setHoaApproval(HOAApproval hoaApproval) {
		this.hoaApproval = hoaApproval;
	}

	public GovtApproval getGovtApproval() {
		return govtApproval;
	}

	public void setGovtApproval(GovtApproval govtApproval) {
		this.govtApproval = govtApproval;
	}
	
}
