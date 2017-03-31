package com.solarvillage.services;

import java.util.Iterator;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.solarvillage.constants.Constants;

@Path("query")
public class MainService {

	/* GET */
	
	@GET
	@Path("status/{type}/{name}")
	public String checkPermitStatus(@PathParam("type") final String type, @PathParam("name") final String name) {
		String result;
		
		result = parsePermitResults(name, type);
		
		return result;
	}
	
	@GET
	@Path("get/all")
	//TODO: Bring this up to date
	public String getAll() {
		String output = "Permits: \n";
		Iterator<String> iter1 = Electrical.permitList.keySet().iterator();
		
		while(iter1.hasNext()) {
			output = output + Electrical.permitList.get(iter1.next()) + "\n";
		}
		
		return output;
	}
	
	/* POST */
	
	@POST
	@Path("create/{type}/{name}")
	public String createPermit(@PathParam("type") final String type, @PathParam("name") final String name) {
		String result;
		
		if(type != null && name != null) {
			if(type.equals("electrical")) {
				String elecCheck = Electrical.permitList.get(name);
				
				if(elecCheck == null) {
					Electrical.permitList.put(name, Constants.STATUS_IN_PROGRESS);
					result = Constants.SUCCESS;
				}else {
					result = "ERROR: Electrical permit already created!";
				}
			}else if(type.equals("structural")) {
				String strucCheck = Structural.permitList.get(name);
				
				if(strucCheck == null) {
					Structural.permitList.put(name, Constants.STATUS_IN_PROGRESS);
					result = Constants.SUCCESS;
				}else {
					result = "ERROR: Structural permit already created!";
				}
			}else {
				result = "ERROR: Invalid type specified!";
			}
		}else {
			result = "ERROR: Name or type not specified!";
		}
		
		return result;
	}

	/* DELETE */
	
	@DELETE
	@Path("rescind/{type}/{name}")
	public String rescindPermit(@PathParam("type") final String type, @PathParam("name") final String name) {
		String result;
		
		if(type != null && name != null) {
			if(type.equals("electrical")) {
				String elecCheck = Electrical.permitList.get(name);
				
				if(elecCheck == null) {
					result = "ERROR: Permit doesn't exist!";
				}else {
					Electrical.permitList.remove(name);
					result = Constants.SUCCESS;
				}
			}else if(type.equals("structural")) {
				String strucCheck = Structural.permitList.get(name);
				
				if(strucCheck == null) {
					result = "ERROR: Permit doesn't exist!";
				}else {
					Structural.permitList.remove(name);
					result = Constants.SUCCESS;
				}
			}else {
				result = "ERROR: Invalid type specified!";
			}
		}else {
			result = "ERROR: Name or type not specified!";
		}
		
		return result;
	}
	
	/* LOCAL METHODS */
	
	private String parsePermitResults(String name, String type) {
		String typeResult = null;
		
		if(type != null) {
			if(type.equals("electrical")) {
				typeResult = Electrical.getPermitRequestStatus(name);
			}else if(type.equals("structural")) {
				typeResult = Structural.getPermitRequestStatus(name);
			}else {
				typeResult = "ERROR: Invalid type parameter!";
			}
		}else {
			typeResult = "ERROR: Missing type parameter!";
		}
		
		if(typeResult == null) {
			typeResult = "ERROR: Permit with that name does not exist!";
		}
		
		return typeResult;
	}
}