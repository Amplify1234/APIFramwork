package com.arcfacilities.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.arcfacilities.accelerator.ActionEngine;
import com.arcfacilities.utilities.Json_Script;
import com.arcfacilities.utilities.TestUtil;

public class TC001_spacexdata_api extends ActionEngine {
	// Logger initialization for the class
	private static final Logger LOG = Logger.getLogger(TC001_spacexdata_api.class);

	@DataProvider(name = "Call")
	public Object[][] loginCall() {
		return TestUtil.getData("Call", dataPath, "Test1");
	}
	
	@DataProvider(name = "Status")
	public Object[][] loginStatus() {
		return TestUtil.getData("Status", dataPath, "Test1");
	}

	@Test(dataProvider = "Call", priority = 1)
	public void Login_Call(Hashtable<String, String> data) throws Exception {

		RestAssured.baseURI = data.get("BaseURI");

		// Request object
		httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();		
		//httpRequest.body(requestParams.toJSONString());
		response = httpRequest.get(data.get("ResourcePath"));
		Json_Script.json_body(response.body(), TC001_spacexdata_api.class.getSimpleName());
		Json_Script.json_header(response.headers(), TC001_spacexdata_api.class.getSimpleName());
		 // Validation of responce code
		
		
		Thread.sleep(3000);
	}

	
	
	@Test(dataProvider="Status", priority = 2)
	public void LoginStatus(Hashtable<String, String> data) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		String ststus_code_expected = data.get("StatusCode");
        double d = Double.parseDouble(ststus_code_expected);
        int Datasheet_Responce = (int) d;        
        
       
        int Responce = response.getStatusCode();
     
     // Validation of responce code
        assertValues("Status Code" , getIntValue(data.get("StatusCode")), Responce);
     // Validation of Content Type
    	assertValues("Content Type", data.get("ContentType"), getStringFrom(response.getContentType()));
	}
}