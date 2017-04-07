package com.solarvillage.datamodel;

import java.io.Serializable;

public class GovtStatusError implements Serializable {
	private String queryID;
	private String queryType;
	private String queryResponse;
	
	public String getQueryID() {
		return queryID;
	}
	public void setQueryID(String queryID) {
		this.queryID = queryID;
	}
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	public String getQueryResponse() {
		return queryResponse;
	}
	public void setQueryResponse(String queryResponse) {
		this.queryResponse = queryResponse;
	}
	
}
