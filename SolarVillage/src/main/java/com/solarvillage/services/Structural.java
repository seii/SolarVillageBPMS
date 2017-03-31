package com.solarvillage.services;

import java.util.HashMap;

import com.solarvillage.constants.Constants;

public class Structural {
	
	static HashMap<String, String> permitList = new HashMap<String, String>();
	static Integer index = 0;

	public static String submitPermitRequest(String requestId) {
		permitList.put(requestId, Constants.STATUS_IN_PROGRESS);
		
		return Constants.STATUS_IN_PROGRESS;
	}
	
	public static String getPermitRequestStatus(String requestId) {
		String result = permitList.get(requestId);
		
		return result;
	}
	
	public static String rescindPermit(String requestId) {
		String result = "";
		
		permitList.remove(requestId);
		
		if(permitList.get(requestId) == null) {
			result = Constants.SUCCESS;
		}else {
			result = Constants.FAILED;
		}
		
		return result;
	}
}
