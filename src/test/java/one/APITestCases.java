package one;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class APITestCases {
	int id = 0;
	
	private String accessToken = "4a47e7c2ccb5a001d4a4baee7831e5c91dc24999dbdeb53ad11b7aa394995b5e";
	APIUtilities apiUtils = new APIUtilities(accessToken);
	protected String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}
		
	
	@Test(priority = 1)
	public void testGETRequest() {
		
		Response getResponse = apiUtils.sendGETRequest("/users");
		System.out.println("Response Body: " + getResponse.getBody().asString());
		getResponse.then().statusCode(200);
	    getResponse.then().log().all();
		}
	
	
	@Test (priority = 2)
	public void testPOSTRequest() {
		
		//String payload ="{\"name\":\"Ten Ramakrishna\", \"gender\":\"male\", \"email\":\"tenali.ramakrishna@15ce.com\", \"status\":\"active\"}";
		
		String email = getSaltString() + "@gmail.com";
		HashMap <String,String>payload = new HashMap<String,String>();
		payload.put("name","Ten Ramakrishna");
		payload.put("gender", "male");
		payload.put("email", email);
		payload.put("status","active");
		
		
		Response postResponse = apiUtils.sendPOSTRequest("/users",payload);
		System.out.println("Response Body: " + postResponse.getBody().asString());
		postResponse.then().statusCode(201);
		postResponse.then().log().all();
		//5705402
		
		 id = postResponse.jsonPath().getInt("id");
		System.out.println(id);
	}
	
	
	@Test(priority = 3)
	public void testPUTRequest() {
		
		String email = getSaltString() + "@gmail.com";
		HashMap <String,String>payload = new HashMap<String,String>();
		payload.put("name","Tenu Ramakrishna");
		payload.put("email", email);
		payload.put("status","active");
		
		//Response putResponse = apiUtils.sendPUTRequest("/users/5705402", payload);
		Response putResponse = apiUtils.sendPUTRequest("/users/" + id, payload);
		//System.out.println("Response Body: " + putResponse.getBody().asString());
	    putResponse.then().statusCode(200);
	    putResponse.then().log().all();
	   }
	
	@Test (priority = 4)
	public void testDELETERequest() {
		//5704425
		
	//Response deleteResponse =  apiUtils.sendDELETERequest("/users/5704425");
	Response deleteResponse =  apiUtils.sendDELETERequest("/users/" + id);
	System.out.println("Response Body: " + deleteResponse.getBody().asString());
	deleteResponse.then().statusCode(204);
	deleteResponse.then().log().all();
	
		
	}
	
	
	

}
