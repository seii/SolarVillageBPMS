package com.solarvillage.datamodel;

import java.time.LocalDate;

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
						String elecPermID, String strucPermID, String hoaMeetingDate) {
		hoaApproval = new HOAApproval();
		govtApproval = new GovtApproval();
		
		hoaApproval.setHoaAddress(hoaAddress);
		hoaApproval.setHoaName(hoaName);
		hoaApproval.setOwnerAddress(ownerAddress);
		hoaApproval.setOwnerName(ownerName);
		
		//The below is the Java 7 and below way of performing Date calculations
		/*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date parsedMeetingDate;
		
		try {
			parsedMeetingDate = dateFormat.parse(hoaMeetingDate);
			hoaApproval.setHoaMeetingDate(parsedMeetingDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//The below is the Java 8 and above way of performing LocalDate calculations
		LocalDate meetingDate = LocalDate.parse(hoaMeetingDate);
		
		hoaApproval.setHoaMeetingDate(meetingDate);
		
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
