package com.solarvillage.datamodel;

import java.io.Serializable;

public class GovtStatusRequest implements Serializable {
	private String permitID;
	private String url;
	private String response;
	
	public String getPermitID() {
		return permitID;
	}
	public void setPermitID(String permitID) {
		this.permitID = permitID;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
}
